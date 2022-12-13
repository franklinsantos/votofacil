package com.fsantos.votofacil.service;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import com.fsantos.votofacil.dto.AssociadoRequestDto;
import com.fsantos.votofacil.dto.AssociadoResponseDto;
import com.fsantos.votofacil.exception.IntegracaoException;
import com.fsantos.votofacil.exception.NaoEncontradoException;
import com.fsantos.votofacil.exception.RegraDeNegocioException;
import com.fsantos.votofacil.mappers.AssociadoMapper;
import com.fsantos.votofacil.model.Associado;
import com.fsantos.votofacil.repository.AssociadoRepository;

@Service
public class AssociadoService
{

   private final AssociadoRepository associadoRepository;
   private final AssociadoMapper associadoMapper;
   private final RestTemplate restTemplate;
   private final Environment environment;

   private final String VOTO_AUTORIZADO = "ABLE_TO_VOTE";

   @Autowired
   public AssociadoService(AssociadoRepository associadoRepository, AssociadoMapper associadoMapper,
      RestTemplate restTemplate, Environment environment)
   {
      this.associadoRepository = associadoRepository;
      this.associadoMapper = associadoMapper;
      this.restTemplate = restTemplate;
      this.environment = environment;
   }

   public List<AssociadoResponseDto> obtemTodos()
   {
      List<Associado> associados = this.associadoRepository.findAll();

      return associadoMapper.converteJPAsEmDTOs(associados);
   }

   public AssociadoResponseDto salvar(AssociadoRequestDto dto)
   {
      Associado associado = associadoMapper.converteDTOemJPA(dto);

      associado = associadoRepository.save(associado);

      return this.associadoMapper.converteJPAEmDTO(associado);
   }

   public AssociadoResponseDto buscar(long id)
   {
      Associado associado = this.associadoRepository.findById(id).
         orElseThrow(() -> new NaoEncontradoException("Associado nao encontrada"));

      return this.associadoMapper.converteJPAEmDTO(associado);
   }

   public void remover(long id)
   {
      associadoRepository.deleteById(id);
   }

   public AssociadoResponseDto atualizar(AssociadoRequestDto dto)
   {
      Associado associado = associadoMapper.converteDTOemJPA(dto);

      associado = associadoRepository.save(associado);

      return this.associadoMapper.converteJPAEmDTO(associado);
   }

   public boolean verificaSeAssociadoPodeVotar(long id)
   {
      Associado associado = this.associadoRepository.findById(id).
         orElseThrow(() -> new NaoEncontradoException("Associado nao encontrada"));

      try
      {
         boolean wsAtivo = Boolean.parseBoolean(environment.getProperty("votofacil.associado.validacao-ativa"));

         if (wsAtivo)
         {
            String url = environment.getProperty("votofacil.associado.validacao-cpf-url") + associado.getCpf();
            ResponseEntity<?> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);

            return Objects.equals(response.getBody(), VOTO_AUTORIZADO);
         }

         return true;
      }
      catch (HttpStatusCodeException ex)
      {
         if (ex.getStatusCode() == HttpStatus.NOT_FOUND)
            throw new RegraDeNegocioException("CPF não encontrado no sistema de integração");

         throw new IntegracaoException("Ocorreu um erro ao consultar o CPF no sistema de integração.");
      }
   }
}
