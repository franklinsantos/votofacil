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
import com.fsantos.votofacil.dto.AssociadoRequestDto;
import com.fsantos.votofacil.service.AssociadoService;

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
      return ResponseEntity.ok(associadoService.buscar(id));
   }

   @PostMapping("/")
   public ResponseEntity<?> salvar(@Valid
   @RequestBody
      AssociadoRequestDto dto)
   {
      return ResponseEntity.ok(associadoService.salvar(dto));
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
      return ResponseEntity.ok(associadoService.atualizar(dto));
   }

}
