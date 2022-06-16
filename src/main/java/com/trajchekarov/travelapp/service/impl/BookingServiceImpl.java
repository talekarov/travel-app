package com.trajchekarov.travelapp.service.impl;

import com.trajchekarov.travelapp.exception.FlightNotFoundException;
import com.trajchekarov.travelapp.model.response.BookingResponseBody;
import com.trajchekarov.travelapp.persistence.model.Booking;
import com.trajchekarov.travelapp.persistence.model.FlightEntity;
import com.trajchekarov.travelapp.persistence.repository.BookingRepository;
import com.trajchekarov.travelapp.persistence.repository.FlightRepository;
import com.trajchekarov.travelapp.service.BookingService;
import com.trajchekarov.travelapp.utils.AuthenticationUtils;
import com.trajchekarov.travelapp.utils.ConvertUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@Slf4j
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final FlightRepository flightRepository;

    @Autowired
    public BookingServiceImpl (BookingRepository bookingRepository, FlightRepository flightRepository){
        this.bookingRepository = bookingRepository;
        this.flightRepository = flightRepository;
    }

    @Override
    public BookingResponseBody bookFlight(Long flightId, Integer numPassengers) {
        Optional<FlightEntity> flightEntity = flightRepository.findById(flightId);
        if(flightEntity.isPresent()){
            FlightEntity flight = flightEntity.get();
            Booking booking = Booking.builder()
                    .flight(flight)
                    .user(AuthenticationUtils.getUsername())
                    .dateBooked(LocalDate.now())
                    .numPassengers(numPassengers)
                    .totalPrice(flight.getPrice()*numPassengers)
                    .build();

            bookingRepository.save(booking);
            flightRepository.delete(flight);
            flight.setAvailableSeats(flight.getAvailableSeats()-numPassengers);
            flightRepository.save(flight);

            return ConvertUtils.convertToBookingResponseBody(booking);
        }
        else throw new FlightNotFoundException();

    }
}
