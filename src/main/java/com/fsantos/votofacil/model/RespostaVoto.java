package com.fsantos.votofacil.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum RespostaVoto
{

   NAO("Não"),
   SIM("Sim");

   private String resposta;

}
