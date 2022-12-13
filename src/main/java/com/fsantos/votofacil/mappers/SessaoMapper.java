package com.fsantos.votofacil.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import com.fsantos.votofacil.dto.SessaoRequestDto;
import com.fsantos.votofacil.dto.SessaoResponseDto;
import com.fsantos.votofacil.model.Sessao;

@Mapper(componentModel = "spring")
public interface SessaoMapper
{

   SessaoResponseDto converteJPAEmDTO(Sessao jpa);

   List<SessaoResponseDto> converteJPAsEmDTOs(List<Sessao> jpas);

   Sessao converteDTOemJPA(SessaoRequestDto dto);
}
