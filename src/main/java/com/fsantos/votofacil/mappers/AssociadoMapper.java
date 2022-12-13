package com.fsantos.votofacil.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import com.fsantos.votofacil.dto.AssociadoRequestDto;
import com.fsantos.votofacil.dto.AssociadoResponseDto;
import com.fsantos.votofacil.model.Associado;

@Mapper(componentModel = "spring")
public interface AssociadoMapper
{

   AssociadoResponseDto converteJPAEmDTO(Associado jpa);

   List<AssociadoResponseDto> converteJPAsEmDTOs(List<Associado> jpas);

   Associado converteDTOemJPA(AssociadoRequestDto dto);
}
