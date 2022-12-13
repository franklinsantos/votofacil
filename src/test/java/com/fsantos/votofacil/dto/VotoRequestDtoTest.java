package com.fsantos.votofacil.dto;

import org.junit.jupiter.api.Test;
import com.fsantos.votofacil.model.RespostaVoto;

class VotoRequestDtoTest
{

   VotoRequestDto votoRequestDto = new VotoRequestDto(0L, 0L, RespostaVoto.NAO);

   @Test
   void testSetSessaoId()
   {
      votoRequestDto.setSessaoId(0L);
   }

   @Test
   void testSetAssociadoId()
   {
      votoRequestDto.setAssociadoId(0L);
   }

   @Test
   void testSetResposta()
   {
      votoRequestDto.setResposta(RespostaVoto.NAO);
   }
}
