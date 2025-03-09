package com.befrank.casedeveloperjava.api;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.befrank.casedeveloperjava.generated.api.ParticipantsApi;
import com.befrank.casedeveloperjava.generated.model.ParticipantDTO;
import com.befrank.casedeveloperjava.mapper.DTOMapper;
import com.befrank.casedeveloperjava.repository.ParticipantRepository;
import com.befrank.casedeveloperjava.service.ParticipantService;

@RestController
public class ParticipantApiImpl implements ParticipantsApi {

  private final ParticipantRepository participantRepository;
  private final ParticipantService service;

  public ParticipantApiImpl(final ParticipantRepository participantRepository, final ParticipantService service) {
    this.participantRepository = participantRepository;
    this.service = service;
  }

  @Override
  public ResponseEntity<List<ParticipantDTO>> getParticipants() {
    return ResponseEntity.ok(participantRepository.findAll().stream().map(DTOMapper.INSTANCE::toDto).toList());
  }

  @Override
  public ResponseEntity<BigDecimal> calculateExpectedValue(final UUID participantId, final BigDecimal pensionAge) {
    return ResponseEntity.ok(service.calculateExpectedValueForAge(participantId, pensionAge));
  }

}
