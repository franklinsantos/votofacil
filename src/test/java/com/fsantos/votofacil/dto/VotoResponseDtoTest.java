package com.fsantos.votofacil.dto;

import java.time.LocalDateTime;
import java.time.Month;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.fsantos.votofacil.model.RespostaVoto;

import static org.mockito.Mockito.*;

class VotoResponseDtoTest
{

   @Mock
   SessaoResponseDto sessao;
   @Mock
   AssociadoResponseDto associado;
   @InjectMocks
   VotoResponseDto votoResponseDto;

   @BeforeEach
   void setUp()
   {
      MockitoAnnotations.openMocks(this);
   }

   @Test
   void testSetSessao()
   {
      votoResponseDto.setSessao(
         new SessaoResponseDto(Long.valueOf(1), Integer.valueOf(0), LocalDateTime.of(2022, Month.DECEMBER, 13, 11, 54, 49),
            LocalDateTime.of(2022, Month.DECEMBER, 13, 11, 54, 49), new PautaResponseDto(Long.valueOf(1), "titulo")));
   }

   @Test
   void testSetAssociado()
   {
      votoResponseDto.setAssociado(new AssociadoResponseDto(Long.valueOf(1), "cpf"));
   }

   @Test
   void testSetResposta()
   {
      votoResponseDto.setResposta(RespostaVoto.NAO);
   }
}
