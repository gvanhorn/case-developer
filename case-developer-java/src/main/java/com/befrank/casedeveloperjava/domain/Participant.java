package com.befrank.casedeveloperjava.domain;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Participant {

  @GeneratedValue(strategy = GenerationType.UUID)
  @Id private UUID id;

  private String name;

  private LocalDate dateOfBirth;

  @OneToOne
  private Address address;

  @OneToOne
  private Employment employment;

  public UUID getId() {
    return id;
  }

  public void setId(final UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(final LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(final Address address) {
    this.address = address;
  }

  public Employment getEmployment() {
    return employment;
  }

  public void setEmployment(final Employment employment) {
    this.employment = employment;
  }
}
