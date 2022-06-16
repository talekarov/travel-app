package com.trajchekarov.travelapp.service;

import com.trajchekarov.travelapp.model.request.VaccinationStatusRequestBody;
import com.trajchekarov.travelapp.model.response.VaccinationStatusResponseBody;

public interface VaccinationStatusService {

    VaccinationStatusResponseBody getVaccinationStatus();

    VaccinationStatusResponseBody updateVaccinationStatus(VaccinationStatusRequestBody vaccinationStatusRequestBody);

    VaccinationStatusResponseBody createVaccinationStatus(VaccinationStatusRequestBody vaccinationStatusRequestBody);
}
