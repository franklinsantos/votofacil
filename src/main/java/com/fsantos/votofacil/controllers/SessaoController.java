package com.fsantos.votofacil.controllers;

import lombok.extern.log4j.Log4j2;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fsantos.votofacil.dto.ErroResponseDto;
import com.fsantos.votofacil.dto.SessaoRequestDto;
import com.fsantos.votofacil.service.SessaoService;
@Log4j2
@RestController
@RequestMapping("/api/v1/sessoes")
public class SessaoController
{

   private final SessaoService sessaoService;

   @Autowired
   public SessaoController(SessaoService sessaoService)
   {
      this.sessaoService = sessaoService;
   }

   @GetMapping(value = "/")
   public ResponseEntity<?> obtemSessaos()
   {
      ErroResponseDto erroResponseDto = ErroResponseDto.builder().build();
      try
      {
         return ResponseEntity.ok(sessaoService.obtemTodos());
      }
      catch (Exception e)
      {
         log.error(e.getMessage(), e);
         erroResponseDto.setMensagem(e.getMessage());
      }
      return ResponseEntity.badRequest().body(erroResponseDto);
   }

   @GetMapping("/{id}")
   public ResponseEntity<?> buscar(@PathVariable("id") long id)
   {
      ErroResponseDto erroResponseDto = ErroResponseDto.builder().build();
      try
      {
         return ResponseEntity.ok(sessaoService.buscar(id));
      }
      catch (Exception e)
      {
         log.error(e.getMessage(), e);
         erroResponseDto.setMensagem(e.getMessage());
      }
      return ResponseEntity.badRequest().body(erroResponseDto);

   }

   @PostMapping("/")
   public ResponseEntity<?> criar(@Valid @RequestBody SessaoRequestDto dto)
   {

      ErroResponseDto erroResponseDto = ErroResponseDto.builder().build();
      try
      {
         return ResponseEntity.ok(sessaoService.criar(dto));
      }
      catch (Exception e)
      {
         log.error(e.getMessage(), e);
         erroResponseDto.setMensagem(e.getMessage());
      }
      return ResponseEntity.badRequest().body(erroResponseDto);

   }

   @DeleteMapping("/{id}")
   public void remover(@PathVariable("id") long id)
   {
      sessaoService.remover(id);
   }

   @PutMapping("/")
   public ResponseEntity<?> atualizar(@Valid @RequestBody SessaoRequestDto dto)
   {
      ErroResponseDto erroResponseDto = ErroResponseDto.builder().build();
      try
      {
         return ResponseEntity.ok(sessaoService.atualizar(dto));
      }
      catch (Exception e)
      {
         log.error(e.getMessage(), e);
         erroResponseDto.setMensagem(e.getMessage());
      }
      return ResponseEntity.badRequest().body(erroResponseDto);

   }

}
