package com.trajchekarov.travelapp.service;

import com.trajchekarov.travelapp.model.response.CountryRestrictionsResponseBody;
import com.trajchekarov.travelapp.persistence.model.CountryRestrictions;

public interface CountryRestrictionsService {

    CountryRestrictionsResponseBody getByCountry(String country);
}
