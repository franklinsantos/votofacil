package com.fsantos.votofacil.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class VotoTest
{

   @Mock
   VotoId id;
   @InjectMocks
   Voto voto;

   @BeforeEach
   void setUp()
   {
      MockitoAnnotations.openMocks(this);
   }

   @Test
   void testSetId()
   {
      voto.setId(new VotoId(new Sessao(), new Associado()));
   }

   @Test
   void testSetResposta()
   {
      voto.setResposta(RespostaVoto.NAO);
   }
}
