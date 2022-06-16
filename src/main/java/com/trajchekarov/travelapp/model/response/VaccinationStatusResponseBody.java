package com.trajchekarov.travelapp.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VaccinationStatusResponseBody implements Serializable {

    static final long serialVersionUID = 1L;

    private Boolean vaccinated = false;

    private String vaccine;

    private Date vaccinationDate;

    private Date validUntil;

}
