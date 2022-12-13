package com.fsantos.votofacil.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class ApuracaoResponseDtoTest
{

   @Mock
   PautaResponseDto pauta;
   @InjectMocks
   ApuracaoResponseDto apuracaoResponseDto;

   @BeforeEach
   void setUp()
   {
      MockitoAnnotations.openMocks(this);
   }

   @Test
   void testSetPauta()
   {
      apuracaoResponseDto.setPauta(new PautaResponseDto(Long.valueOf(1), "titulo"));
   }

   @Test
   void testSetTotalSim()
   {
      apuracaoResponseDto.setTotalSim(Long.valueOf(1));
   }

   @Test
   void testSetTotalNao()
   {
      apuracaoResponseDto.setTotalNao(Long.valueOf(1));
   }

   @Test
   void testBuilder()
   {
      ApuracaoResponseDto.ApuracaoResponseDtoBuilder result = ApuracaoResponseDto.builder();
      assertNotNull(result.build());
   }
}
