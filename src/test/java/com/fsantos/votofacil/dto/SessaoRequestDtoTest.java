package com.fsantos.votofacil.dto;

import org.junit.jupiter.api.Test;

class SessaoRequestDtoTest
{

   SessaoRequestDto sessaoRequestDto = new SessaoRequestDto(0L, 0);

   @Test
   void testSetPautaId()
   {
      sessaoRequestDto.setPautaId(0L);
   }

   @Test
   void testSetTempoExpiracao()
   {
      sessaoRequestDto.setTempoExpiracao(0);
   }
}
