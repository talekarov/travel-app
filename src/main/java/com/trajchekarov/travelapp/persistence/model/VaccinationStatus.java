package com.trajchekarov.travelapp.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class VaccinationStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Boolean vaccinated = false;

    private String vaccine;

    private Date vaccinationDate;

    private Date validUntil;

    @Column(nullable = false)
    private String user;

}