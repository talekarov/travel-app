package com.trajchekarov.travelapp.persistence.repository;

import com.trajchekarov.travelapp.persistence.model.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<FlightEntity,Long> {
}
