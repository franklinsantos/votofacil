package com.fsantos.votofacil.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RespostaVotoTest
{
   @Test
   void testValues()
   {
      RespostaVoto[] result = RespostaVoto.values();
      Assertions.assertArrayEquals(new RespostaVoto[]{RespostaVoto.NAO, RespostaVoto.SIM}, result);
   }

   @Test
   void testValueOf()
   {
      RespostaVoto result = RespostaVoto.valueOf("NAO");
      Assertions.assertEquals(RespostaVoto.NAO, result);
   }
}
