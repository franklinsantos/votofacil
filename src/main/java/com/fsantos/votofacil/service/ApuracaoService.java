package com.fsantos.votofacil.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.fsantos.votofacil.dto.ApuracaoResponseDto;
import com.fsantos.votofacil.exception.NaoEncontradoException;
import com.fsantos.votofacil.mappers.PautaMapper;
import com.fsantos.votofacil.model.Pauta;
import com.fsantos.votofacil.model.RespostaVoto;
import com.fsantos.votofacil.model.Sessao;
import com.fsantos.votofacil.model.SituacaoSessao;
import com.fsantos.votofacil.repository.PautaRepository;
import com.fsantos.votofacil.repository.SessaoRepository;
import com.fsantos.votofacil.repository.VotoRepository;

@Service
public class ApuracaoService
{

   private final VotoRepository votoRepository;

   private final SessaoRepository sessaoRepository;
   private final PautaRepository pautaRepository;
   private final MensagemService mensagemSerive;
   private final PautaMapper pautaMapper;

   @Autowired
   public ApuracaoService(VotoRepository votoRepository, SessaoRepository sessaoRepository,
      MensagemService mensagemSerive, PautaMapper pautaMapper, PautaRepository pautaRepository)
   {
      this.votoRepository = votoRepository;
      this.sessaoRepository = sessaoRepository;
      this.mensagemSerive = mensagemSerive;
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

   @Scheduled(fixedDelay = 2000)
   private void closeAndBroadcastVotingResult()
   {
      List<Sessao> sessoes = obtemSessoesExpiradasENaoFinalizadas();

      sessoes.forEach(sessao -> {
         ApuracaoResponseDto apuracao = obtemResultado(sessao.getPauta().getId());
         mensagemSerive.enviar(apuracao);

         sessao.setSituacao(SituacaoSessao.FINALIZADO);
         sessaoRepository.save(sessao);
      });
   }

   private List<Sessao> obtemSessoesExpiradasENaoFinalizadas()
   {
      return sessaoRepository.findByDataHoraFimLessThanEqualAndSituacaoNot(LocalDateTime.now(), SituacaoSessao.FINALIZADO);
   }
}
