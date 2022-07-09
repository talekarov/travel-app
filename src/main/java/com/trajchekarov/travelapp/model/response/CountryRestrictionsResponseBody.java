package com.trajchekarov.travelapp.model.response;

import com.trajchekarov.travelapp.persistence.model.Restriction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryRestrictionsResponseBody {

    private String country;

    private Restriction restrictionType;

    private Set<String> approvedVaccines;
}
