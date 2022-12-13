package com.fsantos.votofacil.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import com.fsantos.votofacil.model.AutorizacaoVoto;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssociadoRequestDto
{

   private String cpf;

}
