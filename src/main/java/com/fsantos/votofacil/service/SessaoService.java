package com.fsantos.votofacil.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.fsantos.votofacil.dto.SessaoRequestDto;
import com.fsantos.votofacil.dto.SessaoResponseDto;
import com.fsantos.votofacil.exception.NaoEncontradoException;
import com.fsantos.votofacil.mappers.SessaoMapper;
import com.fsantos.votofacil.model.Pauta;
import com.fsantos.votofacil.model.Sessao;
import com.fsantos.votofacil.repository.PautaRepository;
import com.fsantos.votofacil.repository.SessaoRepository;

@Service
public class SessaoService
{

   private final SessaoRepository sessaoRepository;
   private final PautaRepository pautaRepository;
   private final SessaoMapper sessaoMapper;
   private final Environment environment;

   @Autowired
   public SessaoService(SessaoRepository sessaoRepository, SessaoMapper sessaoMapper,
      PautaRepository pautaRepository, Environment environment)
   {
      this.sessaoRepository = sessaoRepository;
      this.sessaoMapper = sessaoMapper;
      this.pautaRepository = pautaRepository;
      this.environment = environment;
   }

   public List<SessaoResponseDto> obtemTodos()
   {
      List<Sessao> sessaos = this.sessaoRepository.findAll();

      return sessaoMapper.converteJPAsEmDTOs(sessaos);
   }

   public SessaoResponseDto criar(SessaoRequestDto dto)
   {
      Pauta pauta = this.pautaRepository.findById(dto.getPautaId()).
         orElseThrow(() -> new NaoEncontradoException("Pauta nao encontrada"));

      int tempoExpiracao = dto.getTempoExpiracao();

      if (tempoExpiracao <= 0)
         tempoExpiracao = (Integer.parseInt(Objects.requireNonNull(environment.getProperty("votofacil.sessao.tempo-expiracao"))));

      Sessao sessao = new Sessao();
      sessao.setPauta(pauta);
      sessao.setTempoExpiracao(tempoExpiracao);
      sessao.setDataHoraInicio(LocalDateTime.now());
      sessao.setDataHoraFim(LocalDateTime.now().plusMinutes(tempoExpiracao));

      sessao = sessaoRepository.save(sessao);

      return this.sessaoMapper.converteJPAEmDTO(sessao);
   }

   public SessaoResponseDto buscar(long id)
   {
      Sessao sessao = this.sessaoRepository.findById(id).
         orElseThrow(() -> new NaoEncontradoException("Sessão nao encontrada"));

      return this.sessaoMapper.converteJPAEmDTO(sessao);
   }

   public void remover(long id)
   {
      try
      {
         sessaoRepository.deleteById(id);
      }
      catch (IllegalArgumentException e)
      {
         throw new NaoEncontradoException("Sessão nao encontrada");
      }
   }

   public SessaoResponseDto atualizar(SessaoRequestDto dto)
   {
      Sessao sessao = sessaoMapper.converteDTOemJPA(dto);

      sessao = sessaoRepository.save(sessao);

      return this.sessaoMapper.converteJPAEmDTO(sessao);
   }
}
