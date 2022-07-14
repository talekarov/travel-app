package com.trajchekarov.travelapp.utils;

import com.trajchekarov.travelapp.model.response.BookingResponseBody;
import com.trajchekarov.travelapp.model.response.CountryRestrictionsResponseBody;
import com.trajchekarov.travelapp.model.response.FlightResponseBody;
import com.trajchekarov.travelapp.model.response.VaccinationStatusResponseBody;
import com.trajchekarov.travelapp.persistence.model.Booking;
import com.trajchekarov.travelapp.persistence.model.CountryRestrictions;
import com.trajchekarov.travelapp.persistence.model.FlightEntity;
import com.trajchekarov.travelapp.persistence.model.VaccinationStatus;

import java.util.List;
import java.util.stream.Collectors;

public final class ConvertUtils {

    private ConvertUtils() {
    }

    public static FlightResponseBody convertToFlightResponseBody(FlightEntity flightEntity, Integer numPassengers) {
        return FlightResponseBody.builder()
                .id(flightEntity.getId())
                .origin(flightEntity.getOrigin())
                .destination(flightEntity.getDestination())
                .departureDate(flightEntity.getDepartureDate())
                .departureTime(flightEntity.getDepartureTime())
                .arrivalDate(flightEntity.getArrivalDate())
                .arrivalTime(flightEntity.getArrivalTime())
                .price(flightEntity.getPrice() * numPassengers)
                .build();
    }

    public static List<FlightResponseBody> convertToFlightResponseBodies(List<FlightEntity> flightEntities, Integer numPassengers) {
        return flightEntities.stream()
                .map(flight -> ConvertUtils.convertToFlightResponseBody(flight, numPassengers))
                .collect(Collectors.toList());
    }

    public static VaccinationStatusResponseBody convertToVaccinationStatusResponseBody(VaccinationStatus vaccinationStatus) {
        return VaccinationStatusResponseBody.builder()
                .vaccinated(vaccinationStatus.getVaccinated())
                .vaccine(vaccinationStatus.getVaccine())
                .vaccinationDate(vaccinationStatus.getVaccinationDate())
                .validUntil(vaccinationStatus.getValidUntil())
                .build();
    }

    public static CountryRestrictionsResponseBody convertToCountryRestrictionsResponesBody(CountryRestrictions countryRestrictions){
        return CountryRestrictionsResponseBody.builder()
                .country(countryRestrictions.getCountry())
                .restrictionType(countryRestrictions.getRestrictionType())
                .approvedVaccines(countryRestrictions.getApprovedVaccines())
                .build();
    }

    public static BookingResponseBody convertToBookingResponseBody(Booking booking){
        return BookingResponseBody.builder()
                .flightId(booking.getFlight().getId())
                .user(booking.getUser())
                .dateBooked(booking.getDateBooked())
                .numPassengers(booking.getNumPassengers())
                .totalPrice(booking.getTotalPrice())
                .build();

    }
}