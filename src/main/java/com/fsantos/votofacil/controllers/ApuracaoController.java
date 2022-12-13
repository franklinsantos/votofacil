package com.fsantos.votofacil.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fsantos.votofacil.service.ApuracaoService;

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
   public ResponseEntity<?> obtemApuracao(@PathVariable("id") long id)
   {
      return ResponseEntity.ok(apuracaoService.obtemResultado(id));
   }
}
