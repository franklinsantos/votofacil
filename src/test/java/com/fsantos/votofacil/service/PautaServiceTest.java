package com.fsantos.votofacil.service;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.fsantos.votofacil.dto.PautaRequestDto;
import com.fsantos.votofacil.dto.PautaResponseDto;
import com.fsantos.votofacil.mappers.PautaMapper;
import com.fsantos.votofacil.model.Pauta;
import com.fsantos.votofacil.repository.PautaRepository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class PautaServiceTest
{

   @Mock
   PautaRepository pautaRepository;
   @Mock
   PautaMapper pautaMapper;
   @InjectMocks
   PautaService pautaService;

   @BeforeEach
   void setUp()
   {
      MockitoAnnotations.openMocks(this);
   }

   @Test
   void testObtemTodos()
   {
      when(pautaMapper.converteJPAsEmDTOs(any())).thenReturn(List.of(new PautaResponseDto(Long.valueOf(1), "titulo")));

      List<PautaResponseDto> result = pautaService.obtemTodos();
      assertNotNull(result);
   }

   @Test
   void testSalvar()
   {
      when(pautaMapper.converteJPAEmDTO(any())).thenReturn(new PautaResponseDto(Long.valueOf(1), "titulo"));
      when(pautaMapper.converteDTOemJPA(any())).thenReturn(new Pauta());

      PautaResponseDto result = pautaService.salvar(new PautaRequestDto("titulo"));
      assertNotNull(result);
   }

   @Test
   void testBuscar()
   {
      when(pautaMapper.converteJPAEmDTO(any())).thenReturn(new PautaResponseDto(Long.valueOf(1), "titulo"));
      when(pautaRepository.findById(any())).thenReturn(Optional.of(new Pauta()));
      PautaResponseDto result = pautaService.buscar(0L);
      assertNotNull(result);
   }

   @Test
   void testRemover()
   {
      pautaService.remover(0L);
   }

   @Test
   void testAtualizar()
   {
      when(pautaMapper.converteJPAEmDTO(any())).thenReturn(new PautaResponseDto(Long.valueOf(1), "titulo"));
      when(pautaMapper.converteDTOemJPA(any())).thenReturn(new Pauta());

      PautaResponseDto result = pautaService.atualizar(new PautaRequestDto("titulo"));
      assertNotNull(result);
   }
}
