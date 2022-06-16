package com.trajchekarov.travelapp.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingResponseBody {

    private Long flightId;

    private String user;

    private LocalDate dateBooked;

    private Integer numPassengers;

    private Float totalPrice;

}
