package com.fsantos.votofacil.controllers;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.fsantos.votofacil.dto.PautaRequestDto;
import com.fsantos.votofacil.dto.PautaResponseDto;
import com.fsantos.votofacil.service.PautaService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class PautaControllerTest
{

   @Mock
   PautaService pautaService;
   @InjectMocks
   PautaController pautaController;

   @BeforeEach
   void setUp()
   {
      MockitoAnnotations.openMocks(this);
   }

   @Test
   void testObtemPautas()
   {
      when(pautaService.obtemTodos()).thenReturn(criaPautaResponseDTOList());

      ResponseEntity<?> result = pautaController.obtemPautas();
      assertEquals(HttpStatus.OK, result.getStatusCode());
      assertNotNull(result.getBody());
   }

   private List<PautaResponseDto> criaPautaResponseDTOList()
   {
      return List.of(criaPautaResponseDto());
   }

   private PautaResponseDto criaPautaResponseDto()
   {
      return new PautaResponseDto(Long.valueOf(1), "titulo");
   }

   @Test
   void testBuscar()
   {
      when(pautaService.buscar(anyLong())).thenReturn(criaPautaResponseDto());

      ResponseEntity<?> result = pautaController.buscar(0L);
      assertEquals(HttpStatus.OK, result.getStatusCode());
      assertNotNull(result.getBody());
   }

   @Test
   void testSalvar()
   {
      when(pautaService.salvar(any())).thenReturn(criaPautaResponseDto());

      ResponseEntity<?> result = pautaController.salvar(criaPautaRequestDto());

      assertEquals(HttpStatus.OK, result.getStatusCode());
      assertNotNull(result.getBody());
   }

   private PautaRequestDto criaPautaRequestDto()
   {
      return new PautaRequestDto("titulo");
   }

   @Test
   void testRemover()
   {
      pautaController.remover(0L);
   }

   @Test
   void testAtualizar()
   {
      when(pautaService.atualizar(any())).thenReturn(criaPautaResponseDto());

      ResponseEntity<?> result = pautaController.atualizar(criaPautaRequestDto());
      assertEquals(HttpStatus.OK, result.getStatusCode());
      assertNotNull(result.getBody());
   }
}
