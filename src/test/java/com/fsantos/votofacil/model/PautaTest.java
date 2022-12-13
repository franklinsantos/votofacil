package com.fsantos.votofacil.model;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class PautaTest
{

   @Mock
   List<Sessao> sessoes;
   @InjectMocks
   Pauta pauta;

   @BeforeEach
   void setUp()
   {
      MockitoAnnotations.openMocks(this);
   }

   @Test
   void testSetId()
   {
      pauta.setId(Long.valueOf(1));
   }

   @Test
   void testSetTitulo()
   {
      pauta.setTitulo("titulo");
   }

   @Test
   void testSetSessoes()
   {
      pauta.setSessoes(List.of(new Sessao()));
   }
}
