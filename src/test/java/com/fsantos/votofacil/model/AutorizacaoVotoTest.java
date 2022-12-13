package com.fsantos.votofacil.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AutorizacaoVotoTest
{
   @Test
   void testValues()
   {
      AutorizacaoVoto[] result = AutorizacaoVoto.values();
      Assertions.assertArrayEquals(new AutorizacaoVoto[]{AutorizacaoVoto.AUTORIZADO, AutorizacaoVoto.NAO_AUTORIZADO}, result);
   }

   @Test
   void testValueOf()
   {
      AutorizacaoVoto result = AutorizacaoVoto.valueOf("AUTORIZADO");
      Assertions.assertEquals(AutorizacaoVoto.AUTORIZADO, result);
   }
}
