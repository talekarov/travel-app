package com.trajchekarov.travelapp.controller;

import com.trajchekarov.travelapp.model.response.BookingResponseBody;
import com.trajchekarov.travelapp.service.impl.BookingServiceImpl;
import com.trajchekarov.travelapp.service.impl.EmailSenderServiceImpl;
import com.trajchekarov.travelapp.utils.AuthenticationUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/booking")
@Api(value = "Endpoint for booking flights")
public class BookingController {

    private final BookingServiceImpl bookingService;
    private final EmailSenderServiceImpl emailSenderService;

    @Autowired
    public BookingController(BookingServiceImpl bookingService, EmailSenderServiceImpl emailSenderService) {
        this.bookingService = bookingService;
        this.emailSenderService = emailSenderService;
    }

    @ApiOperation(value = "Book flight", response = BookingResponseBody.class)
    @PostMapping(value = "/{id}")
    @ResponseBody
    public BookingResponseBody bookFlight(@PathVariable("id") Long flightId, Integer numPassengers) {
        emailSenderService.sendEmail(AuthenticationUtils.getUsername(),
                "Booking successful",
                "Successfully booked flight, ID: " + flightId);
        return bookingService.bookFlight(flightId, numPassengers);
    }
}
