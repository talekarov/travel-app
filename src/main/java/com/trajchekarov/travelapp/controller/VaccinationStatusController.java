package com.trajchekarov.travelapp.controller;

import com.trajchekarov.travelapp.model.request.VaccinationStatusRequestBody;
import com.trajchekarov.travelapp.model.response.VaccinationStatusResponseBody;
import com.trajchekarov.travelapp.service.impl.VaccinationStatusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/vstatus")
public class VaccinationStatusController {

    private final VaccinationStatusServiceImpl vaccinationStatusService;

    @Autowired
    public VaccinationStatusController(VaccinationStatusServiceImpl vaccinationStatusService){
        this.vaccinationStatusService = vaccinationStatusService;
    }

    @GetMapping(value = "/get")
    public VaccinationStatusResponseBody getUserVaccinationStatus(){
        return vaccinationStatusService.getVaccinationStatus();
    }

    @PostMapping(value = "/add")
    public VaccinationStatusResponseBody AddUserVaccinationStatus(VaccinationStatusRequestBody vaccinationStatusRequestBody){
        return vaccinationStatusService.createVaccinationStatus(vaccinationStatusRequestBody);
    }

    @PutMapping(value = "/update")
    public VaccinationStatusResponseBody UpdateUserVaccinationStatus(VaccinationStatusRequestBody vaccinationStatusRequestBody){
        return vaccinationStatusService.updateVaccinationStatus(vaccinationStatusRequestBody);
    }
}
