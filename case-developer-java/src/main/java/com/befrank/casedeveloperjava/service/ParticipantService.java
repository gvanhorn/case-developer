package com.befrank.casedeveloperjava.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.befrank.casedeveloperjava.domain.Employment;
import com.befrank.casedeveloperjava.domain.Participant;
import com.befrank.casedeveloperjava.repository.ParticipantRepository;
import com.befrank.casedeveloperjava.service.investment.Fund;
import com.befrank.casedeveloperjava.service.investment.InvestmentsService;

@Service
public class ParticipantService {

  private static final BigDecimal ROI = BigDecimal.valueOf(0.03);

  private final ParticipantRepository repository;
  private final InvestmentsService investmentsService;

  public ParticipantService(final ParticipantRepository repository, final InvestmentsService investmentsService) {
    this.repository = repository;
    this.investmentsService = investmentsService;
  }

  public BigDecimal calculateExpectedValueForAge(final UUID participantId, final BigDecimal age) {
    return BigDecimal.ZERO;
  }
}
