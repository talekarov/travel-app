package com.trajchekarov.travelapp.service;


import com.trajchekarov.travelapp.model.request.FlightRequestBody;
import com.trajchekarov.travelapp.model.response.FlightResponseBody;

import java.util.List;

public interface FlightService {

    List<FlightResponseBody> getFlights(FlightRequestBody flightRequestBody);

}
