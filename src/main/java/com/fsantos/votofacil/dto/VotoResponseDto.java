package com.fsantos.votofacil.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fsantos.votofacil.model.RespostaVoto;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VotoResponseDto
{

   private SessaoResponseDto sessao;
   private AssociadoResponseDto associado;
   private RespostaVoto resposta;
}
