package com.fsantos.votofacil.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fsantos.votofacil.dto.VotoRequestDto;
import com.fsantos.votofacil.service.VotoService;

@RestController
@RequestMapping("/api/v1/votos")
public class VotoController
{

   private final VotoService votoService;

   @Autowired
   public VotoController(VotoService votoService)
   {
      this.votoService = votoService;
   }

   @GetMapping(value = "/")
   public ResponseEntity<?> obtemVotos()
   {
      return ResponseEntity.ok(votoService.obtemTodos());
   }

   @PostMapping("/")
   public ResponseEntity<?> criar(@Valid
   @RequestBody
      VotoRequestDto dto)
   {
      return ResponseEntity.ok(votoService.criar(dto));
   }
}
