package com.fsantos.votofacil.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SessaoResponseDto
{

   private Long id;
   private Integer tempoExpiracao;
   private LocalDateTime dataHoraInicio;
   private LocalDateTime dataHoraFim;
   private PautaResponseDto pauta;
}
