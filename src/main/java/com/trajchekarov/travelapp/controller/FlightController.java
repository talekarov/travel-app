package com.trajchekarov.travelapp.controller;

import com.trajchekarov.travelapp.model.request.FlightRequestBody;
import com.trajchekarov.travelapp.model.response.FlightResponseBody;
import com.trajchekarov.travelapp.service.impl.FlightServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/flights")
public class FlightController {

    private final FlightServiceImpl flightService;

    @Autowired
    public FlightController(FlightServiceImpl flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public List<FlightResponseBody> findFlights(@RequestBody FlightRequestBody flightRequestBody) {
        return flightService.getFlights(flightRequestBody);
    }
}
