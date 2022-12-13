package com.fsantos.votofacil.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class VotoId implements Serializable
{

   private static final long serialVersionUID = -5969232998220437454L;

   @ManyToOne
   private Sessao sessao;

   @ManyToOne
   private Associado associado;
}
