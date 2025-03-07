package com.befrank.casedeveloperjava.resource;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.befrank.casedeveloperjava.domain.Participant;
import com.befrank.casedeveloperjava.repository.ParticipantRepository;

@RestController("/")
public class ParticipantResource {

  private final ParticipantRepository participantRepository;

  public ParticipantResource(final ParticipantRepository participantRepository) {
    this.participantRepository = participantRepository;
  }

  @GetMapping("/participants")
  public ResponseEntity<List<Participant>> getAllParticipants() {
    return ResponseEntity.ok(participantRepository.findAll());
  }
}
