package com.fsantos.votofacil.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fsantos.votofacil.dto.PautaRequestDto;
import com.fsantos.votofacil.dto.PautaResponseDto;
import com.fsantos.votofacil.exception.NaoEncontradoException;
import com.fsantos.votofacil.mappers.PautaMapper;
import com.fsantos.votofacil.model.Pauta;
import com.fsantos.votofacil.repository.PautaRepository;

@Service
public class PautaService
{

   private final PautaRepository pautaRepository;
   private final PautaMapper pautaMapper;

   @Autowired
   public PautaService(PautaRepository pautaRepository, PautaMapper pautaMapper)
   {
      this.pautaRepository = pautaRepository;
      this.pautaMapper = pautaMapper;
   }

   public List<PautaResponseDto> obtemTodos()
   {
      List<Pauta> pautas = this.pautaRepository.findAll();

      return pautaMapper.converteJPAsEmDTOs(pautas);
   }

   public PautaResponseDto salvar(PautaRequestDto dto)
   {
      Pauta pauta = pautaMapper.converteDTOemJPA(dto);

      pauta = pautaRepository.save(pauta);

      return this.pautaMapper.converteJPAEmDTO(pauta);
   }

   public PautaResponseDto buscar(long id)
   {
      Pauta pauta = this.pautaRepository.findById(id).
         orElseThrow(() -> new NaoEncontradoException("Pauta nao encontrada"));

      return this.pautaMapper.converteJPAEmDTO(pauta);
   }

   public void remover(long id)
   {
      pautaRepository.deleteById(id);
   }

   public PautaResponseDto atualizar(PautaRequestDto dto)
   {
      Pauta pauta = pautaMapper.converteDTOemJPA(dto);

      pauta = pautaRepository.save(pauta);

      return this.pautaMapper.converteJPAEmDTO(pauta);
   }
}
