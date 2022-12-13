package com.fsantos.votofacil.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum AutorizacaoVoto
{

   AUTORIZADO("Autorizado"),
   NAO_AUTORIZADO("Não Autorizado");

   private String autorizacao;

}
