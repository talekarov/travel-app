package com.trajchekarov.travelapp.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightRequestBody {

    private String origin;

    private String destination;

    private LocalDate departureDate;

    private Integer numPassengers;

}