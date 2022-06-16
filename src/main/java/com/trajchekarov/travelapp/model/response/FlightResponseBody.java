package com.trajchekarov.travelapp.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightResponseBody implements Serializable {

    static final long serialVersionUID = 1L;

    private Long id;

    private String origin;

    private String destination;

    private LocalDate departureDate;

    private LocalTime departureTime;

    private LocalTime arrivalTime;

    private LocalDate arrivalDate;

    private Float price;

}