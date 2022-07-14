package com.trajchekarov.travelapp.controller;

import com.trajchekarov.travelapp.model.request.FlightRequestBody;
import com.trajchekarov.travelapp.model.response.FlightResponseBody;
import com.trajchekarov.travelapp.service.impl.FlightServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/flights")
@Api(value = "Endpoint for searching flights")
@CrossOrigin
public class FlightController {

    private final FlightServiceImpl flightService;

    @Autowired
    public FlightController(FlightServiceImpl flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    @ApiOperation(value = "List flights from search", response = List.class)
    @ResponseBody
    public List<FlightResponseBody> findFlights(@RequestBody FlightRequestBody flightRequestBody) {
        if (flightRequestBody.getDestination().isBlank()) {
            return flightService.getFlightsNoDate(flightRequestBody);
        } else return flightService.getFlights(flightRequestBody);
    }
}
