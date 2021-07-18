package com.tsybulko.insurance.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDTO extends InsuranceObjectDTO{
    @NotNull(message = "{valid.address.notBlank}")
    private String address;

    @NotNull(message = "{valid.zip.notNull}")
    @Size(min = 6,max = 6, message = "{valid.zip.size.min6}")
    @Digits(integer = 6, fraction = 0, message = "{valid.zip.digits}")
    private String zip;
}
