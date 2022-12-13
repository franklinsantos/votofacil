package com.fsantos.votofacil.repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.fsantos.votofacil.model.Sessao;
import com.fsantos.votofacil.model.SituacaoSessao;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, Long>
{

   @Query("select s from Sessao s where s.dataHoraFim <= ?1 and s.situacao <> ?2")
   List<Sessao> findByDataHoraFimLessThanEqualAndSituacaoNot(LocalDateTime dataHoraFim, SituacaoSessao situacao);

}
