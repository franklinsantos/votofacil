package com.fsantos.votofacil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fsantos.votofacil.dto.ApuracaoResponseDto;
import com.fsantos.votofacil.exception.NaoEncontradoException;
import com.fsantos.votofacil.mappers.PautaMapper;
import com.fsantos.votofacil.model.Pauta;
import com.fsantos.votofacil.model.RespostaVoto;
import com.fsantos.votofacil.repository.PautaRepository;
import com.fsantos.votofacil.repository.VotoRepository;

@Service
public class ApuracaoService
{

   private final VotoRepository votoRepository;
   private final PautaRepository pautaRepository;
   private final PautaMapper pautaMapper;

   @Autowired
   public ApuracaoService(VotoRepository votoRepository, PautaMapper pautaMapper, PautaRepository pautaRepository)
   {
      this.votoRepository = votoRepository;
      this.pautaRepository = pautaRepository;
      this.pautaMapper = pautaMapper;
   }

   public ApuracaoResponseDto obtemResultado(long pautaId)
   {
      Pauta pauta = this.pautaRepository.findById(pautaId).
         orElseThrow(() -> new NaoEncontradoException("Pauta nao encontrada"));

      return ApuracaoResponseDto
         .builder()
         .totalSim(votoRepository.countById_Sessao_PautaAndResposta(pauta, RespostaVoto.SIM))
         .totalNao(votoRepository.countById_Sessao_PautaAndResposta(pauta, RespostaVoto.NAO))
         .pauta(pautaMapper.converteJPAEmDTO(pauta))
         .build();
   }
}
