package com.fsantos.votofacil.dto;

import java.time.LocalDateTime;
import java.time.Month;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class SessaoResponseDtoTest
{

   @Mock
   PautaResponseDto pauta;
   @InjectMocks
   SessaoResponseDto sessaoResponseDto;

   @BeforeEach
   void setUp()
   {
      MockitoAnnotations.openMocks(this);
   }

   @Test
   void testSetId()
   {
      sessaoResponseDto.setId(Long.valueOf(1));
   }

   @Test
   void testSetTempoExpiracao()
   {
      sessaoResponseDto.setTempoExpiracao(Integer.valueOf(0));
   }

   @Test
   void testSetDataHoraInicio()
   {
      sessaoResponseDto.setDataHoraInicio(LocalDateTime.of(2022, Month.DECEMBER, 13, 11, 53, 7));
   }

   @Test
   void testSetDataHoraFim()
   {
      sessaoResponseDto.setDataHoraFim(LocalDateTime.of(2022, Month.DECEMBER, 13, 11, 53, 7));
   }

   @Test
   void testSetPauta()
   {
      sessaoResponseDto.setPauta(new PautaResponseDto(Long.valueOf(1), "titulo"));
   }
}
