package com.fsantos.votofacil.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fsantos.votofacil.model.AutorizacaoVoto;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssociadoResponseDto
{

   private Long id;
   private String cpf;

}
