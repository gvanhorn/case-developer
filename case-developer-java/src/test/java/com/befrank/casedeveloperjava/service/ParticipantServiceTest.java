package com.befrank.casedeveloperjava.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.befrank.casedeveloperjava.domain.Employment;
import com.befrank.casedeveloperjava.domain.Participant;
import com.befrank.casedeveloperjava.repository.ParticipantRepository;
import com.befrank.casedeveloperjava.service.investment.Fund;
import com.befrank.casedeveloperjava.service.investment.InvestmentsService;

@ExtendWith(MockitoExtension.class)
class ParticipantServiceTest {

  @Mock ParticipantRepository participantRepository;
  @Mock InvestmentsService investmentsService;

  @InjectMocks ParticipantService participantService;

  @Test
  void exampleOne() {
    final Participant p = getExampleParticipant();

    when(participantRepository.findById(p.getId())).thenReturn(Optional.of(p));
    when(investmentsService.getTotalFundValue(p.getInvestmentAccountIban())).thenReturn(List.of(new Fund(new BigDecimal("100000"))));

    BigDecimal actualValue = participantService.calculateExpectedValueForAge(p.getId(), BigDecimal.valueOf(61));

    assertEquals(new BigDecimal("104802.68"), actualValue);
  }

  @Test
  void exampleTwo() {
    final Participant p = getExampleParticipant();

    when(participantRepository.findById(p.getId())).thenReturn(Optional.of(p));
    when(investmentsService.getTotalFundValue(p.getInvestmentAccountIban())).thenReturn(List.of(new Fund(new BigDecimal("100000"))));

    BigDecimal actualValue = participantService.calculateExpectedValueForAge(p.getId(), BigDecimal.valueOf(65));

    assertEquals(new BigDecimal("125498.08"), actualValue);
  }

  private static Participant getExampleParticipant() {
    final Participant p = new Participant();
    p.setId(UUID.randomUUID());
    //set current age
    p.setDateOfBirth(LocalDate.now().minusYears(60));
    p.setInvestmentAccountIban("iban");

    final Employment e = new Employment();
    e.setFulltimeSalary(new BigDecimal("60000.00"));
    e.setFranchise(new BigDecimal("15599.00"));
    e.setParttimePercentage(new BigDecimal("0.80"));
    e.setPremiumPercentage(new BigDecimal("0.05"));

    p.setEmployment(e);
    return p;
  }
}