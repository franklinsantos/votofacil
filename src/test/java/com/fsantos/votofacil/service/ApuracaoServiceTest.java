package com.fsantos.votofacil.service;

import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.fsantos.votofacil.dto.ApuracaoResponseDto;
import com.fsantos.votofacil.dto.PautaResponseDto;
import com.fsantos.votofacil.mappers.PautaMapper;
import com.fsantos.votofacil.model.Pauta;
import com.fsantos.votofacil.repository.PautaRepository;
import com.fsantos.votofacil.repository.VotoRepository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class ApuracaoServiceTest
{

   @Mock
   VotoRepository votoRepository;
   @Mock
   PautaRepository pautaRepository;
   @Mock
   PautaMapper pautaMapper;
   @InjectMocks
   ApuracaoService apuracaoService;

   @BeforeEach
   void setUp()
   {
      MockitoAnnotations.openMocks(this);
   }

   @Test
   void testObtemResultado()
   {
      when(votoRepository.countById_Sessao_PautaAndResposta(any(), any())).thenReturn(0L);
      when(pautaRepository.findById(any())).thenReturn(Optional.of(new Pauta()));
      when(pautaMapper.converteJPAEmDTO(any())).thenReturn(new PautaResponseDto(Long.valueOf(1), "titulo"));

      ApuracaoResponseDto result = apuracaoService.obtemResultado(0L);
      assertNotNull(result);
   }
}
