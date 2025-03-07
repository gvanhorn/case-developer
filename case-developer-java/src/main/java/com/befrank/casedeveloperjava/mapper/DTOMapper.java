package com.befrank.casedeveloperjava.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.befrank.casedeveloperjava.domain.Participant;
import com.befrank.casedeveloperjava.generated.model.ParticipantDTO;

@Mapper
public interface DTOMapper {

  DTOMapper INSTANCE = Mappers.getMapper(DTOMapper.class);

  ParticipantDTO toDto(Participant participant);
}
