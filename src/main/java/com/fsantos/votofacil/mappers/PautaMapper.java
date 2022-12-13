package com.fsantos.votofacil.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import com.fsantos.votofacil.dto.PautaRequestDto;
import com.fsantos.votofacil.dto.PautaResponseDto;
import com.fsantos.votofacil.model.Pauta;

@Mapper(componentModel = "spring")
public interface PautaMapper
{

   PautaResponseDto converteJPAEmDTO(Pauta jpa);

   List<PautaResponseDto> converteJPAsEmDTOs(List<Pauta> jpas);

   Pauta converteDTOemJPA(PautaRequestDto dto);
}
