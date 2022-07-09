package com.trajchekarov.travelapp.service.impl;

import com.trajchekarov.travelapp.model.request.FlightRequestBody;
import com.trajchekarov.travelapp.model.response.FlightResponseBody;
import com.trajchekarov.travelapp.persistence.model.FlightEntity;
import com.trajchekarov.travelapp.persistence.repository.FlightRepository;
import com.trajchekarov.travelapp.service.FlightService;
import com.trajchekarov.travelapp.utils.ConvertUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository){
        this.flightRepository=flightRepository;
    }

    @Override
    public List<FlightResponseBody> getFlights(FlightRequestBody flightRequestBody) {
        List<FlightEntity> flights = flightRepository.findAll()
                .stream()
                .filter(f -> f.getOrigin().equals(flightRequestBody.getOrigin()) &&
                        f.getDestination().equals(flightRequestBody.getDestination()) &&
                        f.getDepartureDate().equals(flightRequestBody.getDepartureDate()) &&
                        f.getAvailableSeats() >= flightRequestBody.getNumPassengers())
                .collect(Collectors.toList());

        return ConvertUtils.convertToFlightResponseBodies(flights, flightRequestBody.getNumPassengers());
    }

    @Override
    public List<FlightResponseBody> getFlightsNoDate(FlightRequestBody flightRequestBody) {
        List<FlightEntity> flights = flightRepository.findAll()
                .stream()
                .filter(f -> f.getOrigin().equals(flightRequestBody.getOrigin()) &&
                        f.getDestination().equals(flightRequestBody.getDestination()) &&
                        f.getAvailableSeats() >= flightRequestBody.getNumPassengers())
                .collect(Collectors.toList());

        return ConvertUtils.convertToFlightResponseBodies(flights, flightRequestBody.getNumPassengers());
    }
}
