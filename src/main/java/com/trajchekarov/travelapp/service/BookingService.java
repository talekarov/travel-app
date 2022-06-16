package com.trajchekarov.travelapp.service;

import com.trajchekarov.travelapp.model.response.BookingResponseBody;

public interface BookingService {

    BookingResponseBody bookFlight(Long flightId, Integer numPassengers);
}
