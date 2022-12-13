package com.fsantos.votofacil.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.fsantos.votofacil.dto.VotoRequestDto;
import com.fsantos.votofacil.dto.VotoResponseDto;
import com.fsantos.votofacil.model.Voto;

@Mapper(componentModel = "spring")
public interface VotoMapper
{

   @Mapping(source = "jpa.id.sessao", target = "sessao")
   @Mapping(source = "jpa.id.associado", target = "associado")
   VotoResponseDto converteJPAEmDTO(Voto jpa);

   List<VotoResponseDto> converteJPAsEmDTOs(List<Voto> jpas);

   Voto converteDTOemJPA(VotoRequestDto dto);
}
