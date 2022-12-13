package com.fsantos.votofacil.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.Hibernate;

@Entity
@Getter
@Setter
@Table(name = "sessao")
public class Sessao
{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
   private Long id;

   @ManyToOne
   private Pauta pauta;

   @OneToMany
   private List<Voto> votos;

   private Integer tempoExpiracao;

   private LocalDateTime dataHoraInicio;

   private LocalDateTime dataHoraFim;

   @Override
   public boolean equals(Object o)
   {
      if (this == o)
         return true;
      if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
         return false;
      Sessao sessao = (Sessao) o;
      return id != null && Objects.equals(id, sessao.id);
   }

   @Override
   public int hashCode()
   {
      return getClass().hashCode();
   }
}
