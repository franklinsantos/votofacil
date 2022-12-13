package com.fsantos.votofacil.dto;

import org.junit.jupiter.api.Test;

class PautaRequestDtoTest
{

   PautaRequestDto pautaRequestDto = new PautaRequestDto("titulo");

   @Test
   void testSetTitulo()
   {
      pautaRequestDto.setTitulo("titulo");
   }
}
