package com.trajchekarov.travelapp.controller;

import com.trajchekarov.travelapp.model.response.CountryRestrictionsResponseBody;
import com.trajchekarov.travelapp.persistence.model.CountryRestrictions;
import com.trajchekarov.travelapp.service.impl.CountryRestrictionsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/restrictions")
public class CountryRestrictionsController {


    private final CountryRestrictionsServiceImpl countryRestrictionsService;

    @Autowired
    public CountryRestrictionsController(CountryRestrictionsServiceImpl countryRestrictionsService){
        this.countryRestrictionsService = countryRestrictionsService;
    }

    @GetMapping(value = "/{country}")
    public CountryRestrictionsResponseBody getRestrictions(@PathVariable ("country") String country){
        return countryRestrictionsService.getByCountry(country);
    }
}
