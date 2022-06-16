package com.trajchekarov.travelapp.persistence.repository;

import com.trajchekarov.travelapp.persistence.model.VaccinationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VaccinationStatusRepository extends JpaRepository<VaccinationStatus,Long> {

    Optional<VaccinationStatus> findByUser(String username);
}
