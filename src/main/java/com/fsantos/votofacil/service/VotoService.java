package com.fsantos.votofacil.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fsantos.votofacil.dto.VotoRequestDto;
import com.fsantos.votofacil.dto.VotoResponseDto;
import com.fsantos.votofacil.exception.NaoEncontradoException;
import com.fsantos.votofacil.exception.RegraDeNegocioException;
import com.fsantos.votofacil.mappers.VotoMapper;
import com.fsantos.votofacil.model.Associado;
import com.fsantos.votofacil.model.Sessao;
import com.fsantos.votofacil.model.Voto;
import com.fsantos.votofacil.model.VotoId;
import com.fsantos.votofacil.repository.AssociadoRepository;
import com.fsantos.votofacil.repository.SessaoRepository;
import com.fsantos.votofacil.repository.VotoRepository;

@Service
public class VotoService
{

   private final VotoRepository votoRepository;
   private final SessaoRepository sessaoRepository;
   private final AssociadoRepository associadoRepository;
   private final AssociadoService associadoService;
   private final VotoMapper votoMapper;

   @Autowired
   public VotoService(VotoRepository votoRepository, VotoMapper votoMapper,
      SessaoRepository sessaoRepository, AssociadoRepository associadoRepository, AssociadoService associadoService)
   {
      this.votoRepository = votoRepository;
      this.sessaoRepository = sessaoRepository;
      this.associadoRepository = associadoRepository;
      this.associadoService = associadoService;
      this.votoMapper = votoMapper;
   }

   public List<VotoResponseDto> obtemTodos()
   {
      List<Voto> votos = this.votoRepository.findAll();

      return votoMapper.converteJPAsEmDTOs(votos);
   }

   public VotoResponseDto criar(VotoRequestDto dto)
   {

      Sessao sessao = sessaoRepository.findById(dto.getSessaoId())
         .orElseThrow(() -> new NaoEncontradoException("Sessao nao encontrada"));

      Associado associado = this.associadoRepository.findById(dto.getAssociadoId())
         .orElseThrow(() -> new NaoEncontradoException("Associado nao encontrado"));

      validarVoto(sessao, associado, dto);

      Voto voto = new Voto();

      voto.setId(VotoId.builder()
         .sessao(sessao)
         .associado(associado)
         .build());

      voto.setResposta(dto.getResposta());

      voto = votoRepository.save(voto);

      return this.votoMapper.converteJPAEmDTO(voto);
   }

   public VotoResponseDto atualizar(VotoRequestDto dto)
   {
      Voto voto = votoMapper.converteDTOemJPA(dto);

      voto = votoRepository.save(voto);

      return this.votoMapper.converteJPAEmDTO(voto);
   }

   private void validarVoto(Sessao sessao, Associado associado, VotoRequestDto dto)
   {
      if (sessao.getDataHoraFim().isBefore(LocalDateTime.now()))
         throw new RegraDeNegocioException("A sessão de votação já foi encerrada.");

      if (votoRepository.existsById_AssociadoAndId_Sessao_Pauta(associado, sessao.getPauta()))
         throw new RegraDeNegocioException("Associado já votou na pauta associada a esta sessão.");

      if (!associadoService.verificaSeAssociadoPodeVotar(dto.getAssociadoId()))
         throw new RegraDeNegocioException("Associado não está autorizado a votar.");
   }
}
