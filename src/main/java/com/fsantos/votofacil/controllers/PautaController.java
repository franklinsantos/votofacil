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
import com.fsantos.votofacil.dto.PautaRequestDto;
import com.fsantos.votofacil.service.PautaService;

@Log4j2
@RestController
@RequestMapping("/api/v1/pautas")
public class PautaController
{

   private final PautaService pautaService;

   @Autowired
   public PautaController(PautaService pautaService)
   {
      this.pautaService = pautaService;
   }

   @GetMapping(value = "/")
   public ResponseEntity<?> obtemPautas()
   {
      ErroResponseDto erroResponseDto = ErroResponseDto.builder().build();
      try
      {
         return ResponseEntity.ok(pautaService.obtemTodos());
      }
      catch (Exception e)
      {
         log.error(e.getMessage(), e);
         erroResponseDto.setMensagem(e.getMessage());
      }
      return ResponseEntity.badRequest().body(erroResponseDto);

   }

   @GetMapping("/{id}")
   public ResponseEntity<?> buscar(
      @PathVariable("id")
         long id)
   {
      ErroResponseDto erroResponseDto = ErroResponseDto.builder().build();
      try
      {
         return ResponseEntity.ok(pautaService.buscar(id));
      }
      catch (Exception e)
      {
         log.error(e.getMessage(), e);
         erroResponseDto.setMensagem(e.getMessage());
      }
      return ResponseEntity.badRequest().body(erroResponseDto);

   }

   @PostMapping("/")
   public ResponseEntity<?> salvar(@Valid
   @RequestBody
      PautaRequestDto dto)
   {
      ErroResponseDto erroResponseDto = ErroResponseDto.builder().build();
      try
      {
         return ResponseEntity.ok(pautaService.salvar(dto));
      }
      catch (Exception e)
      {
         log.error(e.getMessage(), e);
         erroResponseDto.setMensagem(e.getMessage());
      }
      return ResponseEntity.badRequest().body(erroResponseDto);
   }

   @DeleteMapping("/{id}")
   public void remover(
      @PathVariable("id")
         long id)
   {
      pautaService.remover(id);
   }

   @PutMapping("/")
   public ResponseEntity<?> atualizar(@Valid
   @RequestBody
      PautaRequestDto dto)
   {
      ErroResponseDto erroResponseDto = ErroResponseDto.builder().build();
      try
      {
         return ResponseEntity.ok(pautaService.atualizar(dto));
      }
      catch (Exception e)
      {
         log.error(e.getMessage(), e);
         erroResponseDto.setMensagem(e.getMessage());
      }
      return ResponseEntity.badRequest().body(erroResponseDto);

   }

}
