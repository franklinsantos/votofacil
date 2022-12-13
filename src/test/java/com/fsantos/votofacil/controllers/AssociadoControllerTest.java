package com.fsantos.votofacil.controllers;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.fsantos.votofacil.dto.AssociadoRequestDto;
import com.fsantos.votofacil.dto.AssociadoResponseDto;
import com.fsantos.votofacil.service.AssociadoService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class AssociadoControllerTest
{

   @Mock
   AssociadoService associadoService;
   @InjectMocks
   AssociadoController associadoController;

   @BeforeEach
   void setUp()
   {
      MockitoAnnotations.openMocks(this);
   }

   @Test
   void testObtemAssociados()
   {
      when(associadoService.obtemTodos()).thenReturn(criaAssociadoResponseDtoList());

      ResponseEntity<?> result = associadoController.obtemAssociados();

      assertEquals(HttpStatus.OK, result.getStatusCode());

      assertNotNull(result.getBody());
   }

   private List<AssociadoResponseDto> criaAssociadoResponseDtoList()
   {
      return List.of(criaAssociadoResponseDto());
   }

   private AssociadoResponseDto criaAssociadoResponseDto()
   {
      return new AssociadoResponseDto(Long.valueOf(1), "cpf");
   }

   @Test
   void testBuscar()
   {
      when(associadoService.buscar(anyLong())).thenReturn(criaAssociadoResponseDto());

      ResponseEntity<?> result = associadoController.buscar(0L);

      assertEquals(HttpStatus.OK, result.getStatusCode());

      assertNotNull(result.getBody());
   }

   @Test
   void testSalvar()
   {
      when(associadoService.salvar(any())).thenReturn(criaAssociadoResponseDto());

      ResponseEntity<?> result = associadoController.salvar(criaAssociadoRequestDto());

      assertEquals(HttpStatus.OK, result.getStatusCode());

      assertNotNull(result.getBody());
   }

   @Test
   void testRemover()
   {
      associadoController.remover(0L);
   }

   @Test
   void testAtualizar()
   {
      when(associadoService.atualizar(any())).thenReturn(criaAssociadoResponseDto());

      ResponseEntity<?> result = associadoController.atualizar(criaAssociadoRequestDto());
      assertEquals(HttpStatus.OK, result.getStatusCode());

      assertNotNull(result.getBody());
   }

   private AssociadoRequestDto criaAssociadoRequestDto()
   {
      return new AssociadoRequestDto("cpf");
   }
}
