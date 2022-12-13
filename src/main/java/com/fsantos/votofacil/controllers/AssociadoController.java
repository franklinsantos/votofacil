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
import com.fsantos.votofacil.dto.AssociadoRequestDto;
import com.fsantos.votofacil.dto.ErroResponseDto;
import com.fsantos.votofacil.exception.NaoEncontradoException;
import com.fsantos.votofacil.service.AssociadoService;

@Log4j2
@RestController
@RequestMapping("/api/v1/associados")
public class AssociadoController
{

   private final AssociadoService associadoService;

   @Autowired
   public AssociadoController(AssociadoService associadoService)
   {
      this.associadoService = associadoService;
   }

   @GetMapping(value = "/")
   public ResponseEntity<?> obtemAssociados()
   {
      return ResponseEntity.ok(associadoService.obtemTodos());
   }

   @GetMapping("/{id}")
   public ResponseEntity<?> buscar(
      @PathVariable("id")
         long id)
   {
      ErroResponseDto erroResponseDto = ErroResponseDto.builder().build();
      try
      {
         return ResponseEntity.ok(associadoService.buscar(id));
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
      AssociadoRequestDto dto)
   {
      ErroResponseDto erroResponseDto = ErroResponseDto.builder().build();
      try
      {
         return ResponseEntity.ok(associadoService.salvar(dto));
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
      associadoService.remover(id);
   }

   @PutMapping("/")
   public ResponseEntity<?> atualizar(@Valid
   @RequestBody
      AssociadoRequestDto dto)
   {
      ErroResponseDto erroResponseDto = ErroResponseDto.builder().build();
      try
      {
         return ResponseEntity.ok(associadoService.atualizar(dto));
      }
      catch (Exception e)
      {
         log.error(e.getMessage(), e);
         erroResponseDto.setMensagem(e.getMessage());
      }
      return ResponseEntity.badRequest().body(erroResponseDto);


   }

}
