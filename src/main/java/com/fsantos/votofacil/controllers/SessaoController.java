package com.fsantos.votofacil.controllers;

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
import com.fsantos.votofacil.dto.SessaoRequestDto;
import com.fsantos.votofacil.service.SessaoService;

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
      return ResponseEntity.ok(sessaoService.obtemTodos());
   }

   @GetMapping("/{id}")
   public ResponseEntity<?> buscar(@PathVariable("id") long id)
   {
      return ResponseEntity.ok(sessaoService.buscar(id));
   }

   @PostMapping("/")
   public ResponseEntity<?> criar(@Valid @RequestBody SessaoRequestDto dto)
   {

      
      return ResponseEntity.ok(sessaoService.criar(dto));
   }

   @DeleteMapping("/{id}")
   public void remover(@PathVariable("id") long id)
   {
      sessaoService.remover(id);
   }

   @PutMapping("/")
   public ResponseEntity<?> atualizar(@Valid @RequestBody SessaoRequestDto dto)
   {
      return ResponseEntity.ok(sessaoService.atualizar(dto));
   }

}
