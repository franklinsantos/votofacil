package com.fsantos.votofacil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fsantos.votofacil.model.Sessao;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, Long>
{

}
