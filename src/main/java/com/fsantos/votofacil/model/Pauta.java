package com.fsantos.votofacil.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.Hibernate;

@Entity
@Getter
@Setter
@Table(name = "pauta")
public class Pauta
{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
   @Column
   private Long id;

   @Column
   private String titulo;

   @OneToMany(mappedBy = "pauta")
   private List<Sessao> sessoes;

   @Override
   public boolean equals(Object o)
   {
      if (this == o)
         return true;
      if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
         return false;
      Pauta pauta = (Pauta) o;
      return id != null && Objects.equals(id, pauta.id);
   }

   @Override
   public int hashCode()
   {
      return getClass().hashCode();
   }
}
