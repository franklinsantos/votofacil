package com.fsantos.votofacil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fsantos.votofacil.model.Associado;
import com.fsantos.votofacil.model.Voto;

@Repository
public interface AssociadoRepository extends JpaRepository<Associado, Long>
{

}
