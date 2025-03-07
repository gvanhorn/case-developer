package com.befrank.casedeveloperjava.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.befrank.casedeveloperjava.generated.api.ParticipantsApi;
import com.befrank.casedeveloperjava.generated.model.ParticipantDTO;
import com.befrank.casedeveloperjava.mapper.DTOMapper;
import com.befrank.casedeveloperjava.repository.ParticipantRepository;

@RestController
public class ParticipantApiImpl implements ParticipantsApi {

  private final ParticipantRepository participantRepository;

  public ParticipantApiImpl(final ParticipantRepository participantRepository) {
    this.participantRepository = participantRepository;
  }

  @Override
  public ResponseEntity<List<ParticipantDTO>> getParticipants() {
    return ResponseEntity.ok(participantRepository.findAll().stream().map(DTOMapper.INSTANCE::toDto).toList());
  }
}
