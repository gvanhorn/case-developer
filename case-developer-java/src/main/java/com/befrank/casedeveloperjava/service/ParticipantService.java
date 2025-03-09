package com.befrank.casedeveloperjava.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.befrank.casedeveloperjava.domain.Employment;
import com.befrank.casedeveloperjava.domain.Participant;
import com.befrank.casedeveloperjava.repository.ParticipantRepository;
import com.befrank.casedeveloperjava.service.investment.Fund;
import com.befrank.casedeveloperjava.service.investment.InvestmentsService;

@Service
public class ParticipantService {

  private static final BigDecimal ROI = new BigDecimal("0.03");

  private final ParticipantRepository repository;
  private final InvestmentsService investmentsService;

  public ParticipantService(final ParticipantRepository repository, final InvestmentsService investmentsService) {
    this.repository = repository;
    this.investmentsService = investmentsService;
  }

  public BigDecimal calculateExpectedValueForAge(final UUID participantId, final BigDecimal pensionAge) {
    final Participant participant = repository.findById(participantId).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));

    BigDecimal value = getCurrentValue(participant);
    final BigDecimal yearlyPremium = getYearlyPremium(participant);

    for (int i = participant.getAge(); i < pensionAge.intValue(); i++) {
      value = calculateYearlyValue(value, yearlyPremium);
    }
    return value.setScale(2, RoundingMode.HALF_UP);
  }

  private BigDecimal getCurrentValue(final Participant participant) {
    final List<Fund> funds = investmentsService.getTotalFundValue(participant.getInvestmentAccountIban());
    return funds.stream().map(Fund::getValue).reduce(BigDecimal.ZERO, BigDecimal::add);
  }

  private static BigDecimal calculateYearlyValue(final BigDecimal value, final BigDecimal yearlyPremium) {
    return value
        .add(yearlyPremium)
        .add(value
            .add(yearlyPremium.divide(BigDecimal.TWO, RoundingMode.HALF_UP))
            .multiply(ROI));
  }

  private BigDecimal getYearlyPremium(final Participant participant) {
    final Optional<Employment> employment = Optional.ofNullable(participant.getEmployment());
    return employment.map(e -> {
      final BigDecimal base = e.getFulltimeSalary().subtract(e.getFranchise());
      return base.multiply(e.getParttimePercentage()).multiply(e.getPremiumPercentage());
    }).orElse(BigDecimal.ZERO);
  }
}
