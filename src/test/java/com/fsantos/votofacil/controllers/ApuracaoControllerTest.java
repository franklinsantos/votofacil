package com.fsantos.votofacil.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.fsantos.votofacil.dto.ApuracaoResponseDto;
import com.fsantos.votofacil.dto.PautaResponseDto;
import com.fsantos.votofacil.service.ApuracaoService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;

class ApuracaoControllerTest
{

   @Mock
   ApuracaoService apuracaoService;
   @InjectMocks
   ApuracaoController apuracaoController;

   @BeforeEach
   void setUp()
   {
      MockitoAnnotations.openMocks(this);
   }

   @Test
   void testObtemApuracao()
   {
      when(apuracaoService.obtemResultado(anyLong())).thenReturn(
         criaApuracaoResponseDto());

      ResponseEntity<?> result = apuracaoController.obtemApuracao(0L);

      assertEquals(HttpStatus.OK, result.getStatusCode());
      assertNotNull(result.getBody());
   }

   private ApuracaoResponseDto criaApuracaoResponseDto()
   {
      return new ApuracaoResponseDto(new PautaResponseDto(Long.valueOf(1), "titulo"), Long.valueOf(1), Long.valueOf(1));
   }
}
