package com.trajchekarov.travelapp.controller;

import com.trajchekarov.travelapp.model.response.CountryRestrictionsResponseBody;
import com.trajchekarov.travelapp.service.impl.CountryRestrictionsServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/restrictions")
@Api(value = "Endpoint for country restrictions")
@CrossOrigin
public class CountryRestrictionsController {


    private final CountryRestrictionsServiceImpl countryRestrictionsService;

    @Autowired
    public CountryRestrictionsController(CountryRestrictionsServiceImpl countryRestrictionsService){
        this.countryRestrictionsService = countryRestrictionsService;
    }

    @ApiOperation(value = "Return country restrictions", response = CountryRestrictionsResponseBody.class)
    @GetMapping(value = "/{country}")
    @ResponseBody
    public CountryRestrictionsResponseBody getRestrictions(@PathVariable ("country") String country){
        return countryRestrictionsService.getByCountry(country);
    }
}
