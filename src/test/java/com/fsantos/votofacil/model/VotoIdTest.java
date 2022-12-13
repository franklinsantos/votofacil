package com.fsantos.votofacil.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class VotoIdTest
{

   @Mock
   Sessao sessao;
   @Mock
   Associado associado;
   @InjectMocks
   VotoId votoId;

   @BeforeEach
   void setUp()
   {
      MockitoAnnotations.openMocks(this);
   }

   @Test
   void testSetSessao()
   {
      votoId.setSessao(new Sessao());
   }

   @Test
   void testSetAssociado()
   {
      votoId.setAssociado(new Associado());
   }

   @Test
   void testBuilder()
   {
      VotoId.VotoIdBuilder result = VotoId.builder();
      assertNotNull(result.build());
   }
}
