package com.fsantos.votofacil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fsantos.votofacil.model.Pauta;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Long>
{

}
