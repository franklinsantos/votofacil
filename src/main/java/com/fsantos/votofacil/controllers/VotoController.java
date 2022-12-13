package com.fsantos.votofacil.controllers;

import lombok.extern.log4j.Log4j2;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fsantos.votofacil.dto.ErroResponseDto;
import com.fsantos.votofacil.dto.VotoRequestDto;
import com.fsantos.votofacil.service.VotoService;
@Log4j2
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
      ErroResponseDto erroResponseDto = ErroResponseDto.builder().build();
      try
      {
         return ResponseEntity.ok(votoService.obtemTodos());
      }
      catch (Exception e)
      {
         log.error(e.getMessage(), e);
         erroResponseDto.setMensagem(e.getMessage());
      }
      return ResponseEntity.badRequest().body(erroResponseDto);

   }

   @PostMapping("/")
   public ResponseEntity<?> criar(@Valid
   @RequestBody
      VotoRequestDto dto)
   {
      ErroResponseDto erroResponseDto = ErroResponseDto.builder().build();
      try
      {
         return ResponseEntity.ok(votoService.criar(dto));
      }
      catch (Exception e)
      {
         log.error(e.getMessage(), e);
         erroResponseDto.setMensagem(e.getMessage());
      }
      return ResponseEntity.badRequest().body(erroResponseDto);

   }
}
