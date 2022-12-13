package com.fsantos.votofacil.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.Hibernate;

@Entity
@Getter
@Setter
@Table(name = "associado")
public class Associado
{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
   @Column
   private Long id;

   @Column
   private String cpf;

   @Column
   private AutorizacaoVoto autorizacao;

   @Override
   public boolean equals(Object o)
   {
      if (this == o)
         return true;
      if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
         return false;
      Associado associado = (Associado) o;
      return id != null && Objects.equals(id, associado.id);
   }

   @Override
   public int hashCode()
   {
      return getClass().hashCode();
   }
}
