package com.fsantos.votofacil.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum SituacaoSessao
{

   FINALIZADO("Finalizado"),
   INICIADO("Iniciado");

   private String autorizacao;

}
