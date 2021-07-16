package com.tsybulko.insurance.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.tsybulko.insurance.entity.ObjType;
import com.tsybulko.insurance.entity.Person;
import com.tsybulko.insurance.entity.Property;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@JsonSubTypes({
        @JsonSubTypes.Type(value = VehicleDTO.class),
        @JsonSubTypes.Type(value = PropertyDTO.class)
})
public abstract class InsuranceObjectDTO {
    private Integer id;

    @NotNull(message = "{valid.person.notNull}")
    @NotBlank(message = "{valid.person.notNull}")
    private Person owner;

    @NotNull(message = "{valid.type.notNull}")
    @Pattern(regexp = "Vehicle|Property")
    private ObjType type;

}
