package com.trajchekarov.travelapp.controller;

import com.trajchekarov.travelapp.model.request.VaccinationStatusRequestBody;
import com.trajchekarov.travelapp.model.response.VaccinationStatusResponseBody;
import com.trajchekarov.travelapp.service.impl.VaccinationStatusServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/vstatus")
@Api(value = "Endpoints for managing vaccination status")
public class VaccinationStatusController {

    private final VaccinationStatusServiceImpl vaccinationStatusService;

    @Autowired
    public VaccinationStatusController(VaccinationStatusServiceImpl vaccinationStatusService){
        this.vaccinationStatusService = vaccinationStatusService;
    }

    @ApiOperation(value = "Return user vaccination status", response = VaccinationStatusResponseBody.class)
    @GetMapping(value = "/get")
    @ResponseBody
    public VaccinationStatusResponseBody getUserVaccinationStatus(){
        return vaccinationStatusService.getVaccinationStatus();
    }

    @ApiOperation(value = "Create new user vaccination status", response = VaccinationStatusResponseBody.class)
    @PostMapping(value = "/add")
    @ResponseBody
    public VaccinationStatusResponseBody AddUserVaccinationStatus(@RequestBody VaccinationStatusRequestBody vaccinationStatusRequestBody) {
        return vaccinationStatusService.createVaccinationStatus(vaccinationStatusRequestBody);
    }

    @ApiOperation(value = "Update existing user vaccination status", response = VaccinationStatusResponseBody.class)
    @PutMapping(value = "/update")
    @ResponseBody
    public VaccinationStatusResponseBody UpdateUserVaccinationStatus(@RequestBody VaccinationStatusRequestBody vaccinationStatusRequestBody) {
        return vaccinationStatusService.updateVaccinationStatus(vaccinationStatusRequestBody);
    }
}
