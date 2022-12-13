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
import com.fsantos.votofacil.dto.PautaRequestDto;
import com.fsantos.votofacil.service.PautaService;

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
      return ResponseEntity.ok(pautaService.obtemTodos());
   }

   @GetMapping("/{id}")
   public ResponseEntity<?> buscar(@PathVariable("id") long id)
   {
      return ResponseEntity.ok(pautaService.buscar(id));
   }

   @PostMapping("/")
   public ResponseEntity<?> salvar(@Valid @RequestBody PautaRequestDto dto)
   {
      return ResponseEntity.ok(pautaService.salvar(dto));
   }

   @DeleteMapping("/{id}")
   public void remover(@PathVariable("id") long id)
   {
      pautaService.remover(id);
   }

   @PutMapping("/")
   public ResponseEntity<?> atualizar(@Valid @RequestBody PautaRequestDto dto)
   {
      return ResponseEntity.ok(pautaService.atualizar(dto));
   }

}
