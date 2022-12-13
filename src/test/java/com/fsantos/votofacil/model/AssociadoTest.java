package com.fsantos.votofacil.model;

import org.junit.jupiter.api.Test;

class AssociadoTest
{

   //Field autorizacao of type AutorizacaoVoto - was not mocked since Mockito doesn't mock enums
   Associado associado = new Associado();

   @Test
   void testSetId()
   {
      associado.setId(Long.valueOf(1));
   }

   @Test
   void testSetCpf()
   {
      associado.setCpf("cpf");
   }

   @Test
   void testSetAutorizacao()
   {
      associado.setAutorizacao(AutorizacaoVoto.AUTORIZADO);
   }
}
