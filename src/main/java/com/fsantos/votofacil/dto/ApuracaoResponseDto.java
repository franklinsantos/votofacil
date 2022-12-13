package com.fsantos.votofacil.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApuracaoResponseDto
{

   private PautaResponseDto pauta;
   private Long totalSim;
   private Long totalNao;
}
