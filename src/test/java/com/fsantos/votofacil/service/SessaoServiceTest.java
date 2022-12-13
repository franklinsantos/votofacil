package com.fsantos.votofacil.service;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.env.Environment;
import com.fsantos.votofacil.dto.PautaResponseDto;
import com.fsantos.votofacil.dto.SessaoRequestDto;
import com.fsantos.votofacil.dto.SessaoResponseDto;
import com.fsantos.votofacil.mappers.SessaoMapper;
import com.fsantos.votofacil.model.Pauta;
import com.fsantos.votofacil.model.Sessao;
import com.fsantos.votofacil.repository.PautaRepository;
import com.fsantos.votofacil.repository.SessaoRepository;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

class SessaoServiceTest
{

   @Mock
   SessaoRepository sessaoRepository;
   @Mock
   PautaRepository pautaRepository;
   @Mock
   SessaoMapper sessaoMapper;
   @Mock
   Environment environment;
   @InjectMocks
   SessaoService sessaoService;

   @BeforeEach
   void setUp()
   {
      MockitoAnnotations.openMocks(this);
   }

   @Test
   void testObtemTodos()
   {
      when(sessaoMapper.converteJPAsEmDTOs(any())).thenReturn(
         List.of(criaSessaoResponseDto()));

      List<SessaoResponseDto> result = sessaoService.obtemTodos();
      assertNotNull(result);
   }

   private SessaoResponseDto criaSessaoResponseDto()
   {
      return new SessaoResponseDto(Long.valueOf(1), Integer.valueOf(0), LocalDateTime.of(2022, Month.DECEMBER, 13, 14, 43, 12),
         LocalDateTime.of(2022, Month.DECEMBER, 13, 14, 43, 12), new PautaResponseDto(Long.valueOf(1), "titulo"));
   }

   @Test
   void testBuscar()
   {
      when(sessaoMapper.converteJPAEmDTO(any())).thenReturn(
         criaSessaoResponseDto());
      when(sessaoRepository.findById(any())).thenReturn(Optional.of(new Sessao()));
      when(pautaRepository.findById(any())).thenReturn(Optional.of(new Pauta()));
      SessaoResponseDto result = sessaoService.buscar(0L);
      assertNotNull(result);
   }

   @Test
   void testRemover()
   {
      sessaoService.remover(0L);
   }

   @Test
   void testAtualizar()
   {
      when(sessaoMapper.converteJPAEmDTO(any())).thenReturn(
         criaSessaoResponseDto());
      when(sessaoMapper.converteDTOemJPA(any())).thenReturn(new Sessao());

      SessaoResponseDto result = sessaoService.atualizar(new SessaoRequestDto(0L, 0));
      assertNotNull(result);
   }
}
