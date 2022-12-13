package com.fsantos.votofacil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fsantos.votofacil.model.Associado;
import com.fsantos.votofacil.model.Pauta;
import com.fsantos.votofacil.model.RespostaVoto;
import com.fsantos.votofacil.model.Voto;
import com.fsantos.votofacil.model.VotoId;

@Repository
public interface VotoRepository extends JpaRepository<Voto, VotoId>
{

   boolean existsById_AssociadoAndId_Sessao_Pauta(Associado associado, Pauta pauta);

   long countById_Sessao_PautaAndResposta(Pauta pauta, RespostaVoto resposta);



}
