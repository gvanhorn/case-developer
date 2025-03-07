package com.befrank.casedeveloperjava.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.befrank.casedeveloperjava.domain.Participant;

/**
 * Repository for {@link Participant}.
 */
public interface ParticipantRepository extends JpaRepository<Participant, UUID> {
}
