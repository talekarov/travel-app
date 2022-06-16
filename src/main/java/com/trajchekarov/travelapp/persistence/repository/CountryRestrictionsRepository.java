package com.trajchekarov.travelapp.persistence.repository;

import com.trajchekarov.travelapp.persistence.model.CountryRestrictions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryRestrictionsRepository extends JpaRepository<CountryRestrictions,Long> {

    Optional<CountryRestrictions> findByCountry(String country);
}
