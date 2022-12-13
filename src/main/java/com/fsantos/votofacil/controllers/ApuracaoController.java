package com.fsantos.votofacil.controllers;

import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fsantos.votofacil.dto.ErroResponseDto;
import com.fsantos.votofacil.exception.NaoEncontradoException;
import com.fsantos.votofacil.service.ApuracaoService;

@Log4j2
@RestController
@RequestMapping("/api/v1/apuracao")
public class ApuracaoController
{

   private final ApuracaoService apuracaoService;

   @Autowired
   public ApuracaoController(ApuracaoService apuracaoService)
   {
      this.apuracaoService = apuracaoService;
   }

   @GetMapping("/{id}")
   public ResponseEntity<?> obtemApuracao(
      @PathVariable("id")
         long id)
   {
      ErroResponseDto erroResponseDto = ErroResponseDto.builder().build();
      try
      {
         return ResponseEntity.ok(apuracaoService.obtemResultado(id));
      }
      catch (Exception e)
      {
         log.error(e.getMessage(), e);
         erroResponseDto.setMensagem(e.getMessage());
      }
      return ResponseEntity.badRequest().body(erroResponseDto);
   }
}
