package com.tsybulko.insurance.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.OverridesAttribute;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO extends InsuranceObjectDTO{
    @NotNull(message = "{valid.licence.notNull}")
    @Pattern(regexp = "^[a-zA-Z]{2}-\\d\\d-(19\\d\\d|20[01][0-9])-\\d{7}$")
    //TN-42-1998-9876543 - example
    private String driversLicence;

    @NotNull(message = "{valid.regnumber.notNull}")
    private String regNumber;
}
