package com.fsantos.votofacil.controllers;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.fsantos.votofacil.dto.AssociadoResponseDto;
import com.fsantos.votofacil.dto.PautaResponseDto;
import com.fsantos.votofacil.dto.SessaoResponseDto;
import com.fsantos.votofacil.dto.VotoRequestDto;
import com.fsantos.votofacil.dto.VotoResponseDto;
import com.fsantos.votofacil.model.RespostaVoto;
import com.fsantos.votofacil.service.VotoService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

class VotoControllerTest
{

   @Mock
   VotoService votoService;
   @InjectMocks
   VotoController votoController;

   @BeforeEach
   void setUp()
   {
      MockitoAnnotations.openMocks(this);
   }

   @Test
   void testObtemVotos()
   {
      when(votoService.obtemTodos()).thenReturn(
         List.of(criaVotoResponseDto()));

      ResponseEntity<?> result = votoController.obtemVotos();
      assertEquals(HttpStatus.OK, result.getStatusCode());
      assertNotNull(result.getBody());
   }

   @Test
   void testCriar()
   {
      when(votoService.criar(any())).thenReturn(criaVotoResponseDto());

      ResponseEntity<?> result = votoController.criar(criaVotoRequestDto());
      assertEquals(HttpStatus.OK, result.getStatusCode());
      assertNotNull(result.getBody());
   }

   private VotoResponseDto criaVotoResponseDto()
   {
      return new VotoResponseDto(
         new SessaoResponseDto(Long.valueOf(1), Integer.valueOf(0), LocalDateTime.of(2022, Month.DECEMBER, 13, 11, 44, 11),
            LocalDateTime.of(2022, Month.DECEMBER, 13, 11, 44, 11), new PautaResponseDto(Long.valueOf(1), "titulo")),
         new AssociadoResponseDto(Long.valueOf(1), "cpf"), RespostaVoto.NAO);
   }

   private VotoRequestDto criaVotoRequestDto()
   {
      return new VotoRequestDto(0L, 0L, RespostaVoto.NAO);
   }
}
