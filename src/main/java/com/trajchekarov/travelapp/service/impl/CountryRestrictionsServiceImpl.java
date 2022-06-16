package com.trajchekarov.travelapp.service.impl;

import com.trajchekarov.travelapp.exception.RestrictionsNotFoundException;
import com.trajchekarov.travelapp.model.response.CountryRestrictionsResponseBody;
import com.trajchekarov.travelapp.persistence.model.CountryRestrictions;
import com.trajchekarov.travelapp.persistence.repository.CountryRestrictionsRepository;
import com.trajchekarov.travelapp.service.CountryRestrictionsService;
import com.trajchekarov.travelapp.utils.ConvertUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class CountryRestrictionsServiceImpl implements CountryRestrictionsService {

    private final CountryRestrictionsRepository countryRestrictionsRepository;

    @Autowired
    public CountryRestrictionsServiceImpl(CountryRestrictionsRepository countryRestrictionsRepository){
        this.countryRestrictionsRepository = countryRestrictionsRepository;
    }

    @Override
    public CountryRestrictionsResponseBody getByCountry(String country) {
        Optional<CountryRestrictions> countryRestrictions = countryRestrictionsRepository.findByCountry(country);
        if(countryRestrictions.isPresent()) {
            return ConvertUtils.convertToCountryRestrictionsResponesBody(countryRestrictions.get());
        }
        else throw new RestrictionsNotFoundException("No Restrictions found for this country");
    }
}
