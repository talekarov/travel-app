package com.trajchekarov.travelapp.service.impl;

import com.trajchekarov.travelapp.exception.VaccinationStatusNotFoundException;
import com.trajchekarov.travelapp.model.request.VaccinationStatusRequestBody;
import com.trajchekarov.travelapp.model.response.VaccinationStatusResponseBody;
import com.trajchekarov.travelapp.persistence.model.VaccinationStatus;
import com.trajchekarov.travelapp.persistence.repository.VaccinationStatusRepository;
import com.trajchekarov.travelapp.service.VaccinationStatusService;
import com.trajchekarov.travelapp.utils.AuthenticationUtils;
import com.trajchekarov.travelapp.utils.ConvertUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class VaccinationStatusServiceImpl implements VaccinationStatusService {

    private final VaccinationStatusRepository vaccinationStatusRepository;

    @Autowired
    public VaccinationStatusServiceImpl(VaccinationStatusRepository vaccinationStatusRepository) {
        this.vaccinationStatusRepository = vaccinationStatusRepository;
    }

    @Override
    public VaccinationStatusResponseBody createVaccinationStatus(VaccinationStatusRequestBody vaccinationStatusRequestBody) {
        VaccinationStatus vaccinationStatus = VaccinationStatus.builder()
                .vaccinated(vaccinationStatusRequestBody.getVaccinated())
                .vaccine(vaccinationStatusRequestBody.getVaccine())
                .vaccinationDate(vaccinationStatusRequestBody.getVaccinationDate())
                .validUntil(vaccinationStatusRequestBody.getValidUntil())
                .user(AuthenticationUtils.getUsername())
                .build();

        vaccinationStatusRepository.save(vaccinationStatus);
        return ConvertUtils.convertToVaccinationStatusResponseBody(vaccinationStatus);
    }

    @Override
    public VaccinationStatusResponseBody getVaccinationStatus() {
        String username = AuthenticationUtils.getUsername();
        Optional<VaccinationStatus> vaccinationStatus = vaccinationStatusRepository.findByUser(username);
        if (vaccinationStatus.isPresent()) {
            return ConvertUtils.convertToVaccinationStatusResponseBody(vaccinationStatus.get());
        } else throw new VaccinationStatusNotFoundException();
    }

    @Override
    public VaccinationStatusResponseBody updateVaccinationStatus(VaccinationStatusRequestBody vaccinationStatusRequestBody) {
        String username = AuthenticationUtils.getUsername();
        Optional<VaccinationStatus> vStatus = vaccinationStatusRepository.findByUser(username);
        if(vStatus.isPresent()) {
            VaccinationStatus vaccinationStatus = vStatus.get();
            vaccinationStatusRepository.delete(vaccinationStatus);

            vaccinationStatus.setVaccinated(vaccinationStatusRequestBody.getVaccinated());
            vaccinationStatus.setVaccine(vaccinationStatusRequestBody.getVaccine());
            vaccinationStatus.setVaccinationDate(vaccinationStatusRequestBody.getVaccinationDate());
            vaccinationStatus.setValidUntil(vaccinationStatusRequestBody.getValidUntil());

            vaccinationStatusRepository.save(vaccinationStatus);

            return ConvertUtils.convertToVaccinationStatusResponseBody(vaccinationStatus);
        }
        else throw new VaccinationStatusNotFoundException();
    }
}
