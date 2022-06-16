package com.trajchekarov.travelapp.persistence.repository;

import com.trajchekarov.travelapp.persistence.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
