package com.fsantos.votofacil.dto;

import org.junit.jupiter.api.Test;

class PautaResponseDtoTest
{

   PautaResponseDto pautaResponseDto = new PautaResponseDto(Long.valueOf(1), "titulo");

   @Test
   void testSetId()
   {
      pautaResponseDto.setId(Long.valueOf(1));
   }

   @Test
   void testSetTitulo()
   {
      pautaResponseDto.setTitulo("titulo");
   }
}
