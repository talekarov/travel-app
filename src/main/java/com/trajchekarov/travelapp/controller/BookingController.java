package com.trajchekarov.travelapp.controller;

import com.trajchekarov.travelapp.model.response.BookingResponseBody;
import com.trajchekarov.travelapp.service.impl.BookingServiceImpl;
import com.trajchekarov.travelapp.service.impl.EmailSenderServiceImpl;
import com.trajchekarov.travelapp.utils.AuthenticationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    private final BookingServiceImpl bookingService;
    private final EmailSenderServiceImpl emailSenderService;

    @Autowired
    public BookingController(BookingServiceImpl bookingService, EmailSenderServiceImpl emailSenderService){
        this.bookingService = bookingService;
        this.emailSenderService = emailSenderService;
    }

    @PostMapping
    @ResponseBody
    public BookingResponseBody bookFlight(Long flightId, Integer numPassengers){
        emailSenderService.sendEmail(AuthenticationUtils.getUsername(),
                "Booking successful",
                "Successfully booked flight, ID: " + flightId);
        return bookingService.bookFlight(flightId,numPassengers);
    }
}
