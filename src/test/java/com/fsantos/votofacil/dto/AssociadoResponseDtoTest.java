package com.fsantos.votofacil.dto;

import org.junit.jupiter.api.Test;

class AssociadoResponseDtoTest
{

   AssociadoResponseDto associadoResponseDto = new AssociadoResponseDto(Long.valueOf(1), "cpf");

   @Test
   void testSetId()
   {
      associadoResponseDto.setId(Long.valueOf(1));
   }

   @Test
   void testSetCpf()
   {
      associadoResponseDto.setCpf("cpf");
   }
}
