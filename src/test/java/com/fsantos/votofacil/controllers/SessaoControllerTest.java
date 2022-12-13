package com.fsantos.votofacil.controllers;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.fsantos.votofacil.dto.PautaResponseDto;
import com.fsantos.votofacil.dto.SessaoRequestDto;
import com.fsantos.votofacil.dto.SessaoResponseDto;
import com.fsantos.votofacil.service.SessaoService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class SessaoControllerTest
{

   @Mock
   SessaoService sessaoService;
   @InjectMocks
   SessaoController sessaoController;

   @BeforeEach
   void setUp()
   {
      MockitoAnnotations.openMocks(this);
   }

   @Test
   void testObtemSessaos()
   {
      when(sessaoService.obtemTodos()).thenReturn(
         List.of(criaSessaoResponseDto()));

      ResponseEntity<?> result = sessaoController.obtemSessaos();
      assertEquals(HttpStatus.OK, result.getStatusCode());
      assertNotNull(result.getBody());
   }

   private SessaoResponseDto criaSessaoResponseDto()
   {
      return new SessaoResponseDto(Long.valueOf(1), Integer.valueOf(0), LocalDateTime.of(2022, Month.DECEMBER, 13, 11, 41, 32),
         LocalDateTime.of(2022, Month.DECEMBER, 13, 11, 41, 32), new PautaResponseDto(Long.valueOf(1), "titulo"));
   }

   @Test
   void testBuscar()
   {
      when(sessaoService.buscar(anyLong())).thenReturn(
         criaSessaoResponseDto());

      ResponseEntity<?> result = sessaoController.buscar(0L);
      assertEquals(HttpStatus.OK, result.getStatusCode());
      assertNotNull(result.getBody());
   }

   @Test
   void testCriar()
   {
      when(sessaoService.criar(any())).thenReturn(
         criaSessaoResponseDto());

      ResponseEntity<?> result = sessaoController.criar(new SessaoRequestDto(0L, 0));
      assertEquals(HttpStatus.OK, result.getStatusCode());
      assertNotNull(result.getBody());
   }

   @Test
   void testRemover()
   {
      sessaoController.remover(0L);
   }

   @Test
   void testAtualizar()
   {
      when(sessaoService.atualizar(any())).thenReturn(
         criaSessaoResponseDto());

      ResponseEntity<?> result = sessaoController.atualizar(new SessaoRequestDto(0L, 0));
      assertEquals(HttpStatus.OK, result.getStatusCode());
      assertNotNull(result.getBody());
   }
}
