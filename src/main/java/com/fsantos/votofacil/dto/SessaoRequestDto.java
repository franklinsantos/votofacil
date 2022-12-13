package com.fsantos.votofacil.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SessaoRequestDto
{

   private long pautaId;
   private int tempoExpiracao;
}
