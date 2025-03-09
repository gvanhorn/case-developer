package com.befrank.casedeveloperjava.service.investment;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Mock placeholder for the InvestmentsService which should call an external service in the future.
 */
@Service
public class InvestmentsService {

  public List<Fund> getTotalFundValue(final String participantInvestmentAccountIban) {
    return List.of(new Fund(BigDecimal.valueOf(100_000)));
  }
}
