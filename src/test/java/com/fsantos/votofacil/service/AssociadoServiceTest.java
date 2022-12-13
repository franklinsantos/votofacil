package com.fsantos.votofacil.service;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;
import com.fsantos.votofacil.dto.AssociadoRequestDto;
import com.fsantos.votofacil.dto.AssociadoResponseDto;
import com.fsantos.votofacil.mappers.AssociadoMapper;
import com.fsantos.votofacil.model.Associado;
import com.fsantos.votofacil.model.Pauta;
import com.fsantos.votofacil.repository.AssociadoRepository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class AssociadoServiceTest
{

   @Mock
   AssociadoRepository associadoRepository;
   @Mock
   AssociadoMapper associadoMapper;
   @Mock
   RestTemplate restTemplate;
   @Mock
   Environment environment;
   @InjectMocks
   AssociadoService associadoService;

   @BeforeEach
   void setUp()
   {
      MockitoAnnotations.openMocks(this);
   }

   @Test
   void testObtemTodos()
   {
      when(associadoMapper.converteJPAsEmDTOs(any())).thenReturn(List.of(new AssociadoResponseDto(Long.valueOf(1), "cpf")));

      List<AssociadoResponseDto> result = associadoService.obtemTodos();
      assertNotNull(result);
   }

   @Test
   void testSalvar()
   {
      when(associadoMapper.converteJPAEmDTO(any())).thenReturn(new AssociadoResponseDto(Long.valueOf(1), "cpf"));
      when(associadoRepository.findById(any())).thenReturn(Optional.of(new Associado()));

      AssociadoResponseDto result = associadoService.salvar(new AssociadoRequestDto("cpf"));
      assertNotNull(result);
   }

   @Test
   void testBuscar()
   {
      when(associadoMapper.converteJPAEmDTO(any())).thenReturn(new AssociadoResponseDto(Long.valueOf(1), "cpf"));
      when(associadoRepository.findById(any())).thenReturn(Optional.of(new Associado()));
      AssociadoResponseDto result = associadoService.buscar(0L);
      when(associadoRepository.findById(any())).thenReturn(Optional.of(new Associado()));
      assertNotNull(result);
   }

   @Test
   void testRemover()
   {
      associadoService.remover(0L);
   }

   @Test
   void testAtualizar()
   {
      when(associadoMapper.converteJPAEmDTO(any())).thenReturn(new AssociadoResponseDto(Long.valueOf(1), "cpf"));
      when(associadoRepository.findById(any())).thenReturn(Optional.of(new Associado()));

      AssociadoResponseDto result = associadoService.atualizar(new AssociadoRequestDto("cpf"));
      assertNotNull(result);
   }

   @Test
   void testVerificaSeAssociadoPodeVotar()
   {
      when(associadoRepository.findById(any())).thenReturn(Optional.of(new Associado()));
      boolean result = associadoService.verificaSeAssociadoPodeVotar(0L);
      assertNotNull(result);
   }
}
