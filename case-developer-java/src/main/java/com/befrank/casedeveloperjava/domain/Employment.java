package com.befrank.casedeveloperjava.domain;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employment {

  @GeneratedValue(strategy = GenerationType.UUID)
  @Id private UUID id;

  private String companyName;

  private BigDecimal fulltimeSalary;
  private BigDecimal parttimePercentage;
  private BigDecimal franchise;
  private BigDecimal premiumPercentage;

  public UUID getId() {
    return id;
  }

  public void setId(final UUID id) {
    this.id = id;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(final String companyName) {
    this.companyName = companyName;
  }

  public BigDecimal getFulltimeSalary() {
    return fulltimeSalary;
  }

  public void setFulltimeSalary(final BigDecimal fullTimeSalary) {
    this.fulltimeSalary = fullTimeSalary;
  }

  public BigDecimal getParttimePercentage() {
    return parttimePercentage;
  }

  public void setParttimePercentage(final BigDecimal partTimePercentage) {
    this.parttimePercentage = partTimePercentage;
  }

  public BigDecimal getFranchise() {
    return franchise;
  }

  public void setFranchise(final BigDecimal franchise) {
    this.franchise = franchise;
  }

  public BigDecimal getPremiumPercentage() {
    return premiumPercentage;
  }

  public void setPremiumPercentage(final BigDecimal premiumPercentage) {
    this.premiumPercentage = premiumPercentage;
  }
}
