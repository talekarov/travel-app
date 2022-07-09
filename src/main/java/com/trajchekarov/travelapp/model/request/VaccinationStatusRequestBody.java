package com.trajchekarov.travelapp.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class VaccinationStatusRequestBody {

    private Boolean vaccinated = false;

    private String vaccine;

    private Date vaccinationDate;

    private Date validUntil;
}
