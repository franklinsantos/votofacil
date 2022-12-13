package com.fsantos.votofacil.service;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.fsantos.votofacil.dto.AssociadoResponseDto;
import com.fsantos.votofacil.dto.PautaResponseDto;
import com.fsantos.votofacil.dto.SessaoResponseDto;
import com.fsantos.votofacil.dto.VotoRequestDto;
import com.fsantos.votofacil.dto.VotoResponseDto;
import com.fsantos.votofacil.mappers.VotoMapper;
import com.fsantos.votofacil.model.Associado;
import com.fsantos.votofacil.model.RespostaVoto;
import com.fsantos.votofacil.model.Sessao;
import com.fsantos.votofacil.model.Voto;
import com.fsantos.votofacil.repository.AssociadoRepository;
import com.fsantos.votofacil.repository.SessaoRepository;
import com.fsantos.votofacil.repository.VotoRepository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class VotoServiceTest
{

   @Mock
   VotoRepository votoRepository;
   @Mock
   SessaoRepository sessaoRepository;
   @Mock
   AssociadoRepository associadoRepository;
   @Mock
   AssociadoService associadoService;
   @Mock
   VotoMapper votoMapper;
   @InjectMocks
   VotoService votoService;

   @BeforeEach
   void setUp()
   {
      MockitoAnnotations.openMocks(this);
   }

   @Test
   void testObtemTodos()
   {
      when(votoMapper.converteJPAsEmDTOs(any())).thenReturn(
         List.of(criaVotoResponseDto()));

      List<VotoResponseDto> result = votoService.obtemTodos();
      assertNotNull(result);
   }

   @Test
   void testCriar()
   {
      when(votoRepository.existsById_AssociadoAndId_Sessao_Pauta(any(), any())).thenReturn(false);
      when(associadoService.verificaSeAssociadoPodeVotar(anyLong())).thenReturn(true);
      when(votoMapper.converteJPAEmDTO(any())).thenReturn(criaVotoResponseDto());
      when(sessaoRepository.findById(any())).thenReturn(Optional.of(criaSessao()));
      when(associadoRepository.findById(any())).thenReturn(Optional.of(new Associado()));

      VotoResponseDto result = votoService.criar(new VotoRequestDto(0L, 0L, RespostaVoto.NAO));
      assertNotNull(result);
   }

   private Sessao criaSessao()
   {
      Sessao sessao = new Sessao();
      sessao.setDataHoraInicio(LocalDateTime.now());
      sessao.setDataHoraFim(LocalDateTime.now().plusMinutes(30));
      return sessao;
   }

   @Test
   void testAtualizar()
   {
      when(votoMapper.converteJPAEmDTO(any())).thenReturn(criaVotoResponseDto());
      when(votoMapper.converteDTOemJPA(any())).thenReturn(new Voto());

      VotoResponseDto result = votoService.atualizar(new VotoRequestDto(0L, 0L, RespostaVoto.NAO));
      assertNotNull(result);
   }

   private VotoResponseDto criaVotoResponseDto()
   {
      return new VotoResponseDto(
         new SessaoResponseDto(Long.valueOf(1), Integer.valueOf(0), LocalDateTime.of(2022, Month.DECEMBER, 13, 14, 48, 37),
            LocalDateTime.of(2022, Month.DECEMBER, 13, 14, 48, 37), new PautaResponseDto(Long.valueOf(1), "titulo")),
         new AssociadoResponseDto(Long.valueOf(1), "cpf"), RespostaVoto.NAO);
   }
}
