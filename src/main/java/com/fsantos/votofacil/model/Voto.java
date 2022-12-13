package com.fsantos.votofacil.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.Hibernate;

@Entity
@Getter
@Setter
@Table(name = "voto")
public class Voto
{

   @EmbeddedId
   private VotoId id;

   private RespostaVoto resposta;

   @Override
   public boolean equals(Object o)
   {
      if (this == o)
         return true;
      if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
         return false;
      Voto pauta = (Voto) o;
      return id != null && Objects.equals(id, pauta.id);
   }

   @Override
   public int hashCode()
   {
      return getClass().hashCode();
   }
}
