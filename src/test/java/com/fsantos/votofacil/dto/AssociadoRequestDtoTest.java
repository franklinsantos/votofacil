package com.fsantos.votofacil.dto;

import org.junit.jupiter.api.Test;

class AssociadoRequestDtoTest
{

   AssociadoRequestDto associadoRequestDto = new AssociadoRequestDto("cpf");

   @Test
   void testSetCpf()
   {
      associadoRequestDto.setCpf("cpf");
   }
}
