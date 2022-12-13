package com.fsantos.votofacil.model;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class SessaoTest
{

   @Mock
   Pauta pauta;
   @Mock
   List<Voto> votos;
   @InjectMocks
   Sessao sessao;

   @BeforeEach
   void setUp()
   {
      MockitoAnnotations.openMocks(this);
   }

   @Test
   void testSetId()
   {
      sessao.setId(Long.valueOf(1));
   }

   @Test
   void testSetPauta()
   {
      sessao.setPauta(new Pauta());
   }

   @Test
   void testSetVotos()
   {
      sessao.setVotos(List.of(new Voto()));
   }

   @Test
   void testSetTempoExpiracao()
   {
      sessao.setTempoExpiracao(Integer.valueOf(0));
   }

   @Test
   void testSetDataHoraInicio()
   {
      sessao.setDataHoraInicio(LocalDateTime.of(2022, Month.DECEMBER, 13, 14, 6, 3));
   }

   @Test
   void testSetDataHoraFim()
   {
      sessao.setDataHoraFim(LocalDateTime.of(2022, Month.DECEMBER, 13, 14, 6, 3));
   }
}
