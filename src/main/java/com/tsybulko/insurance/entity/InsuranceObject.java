package com.tsybulko.insurance.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.tsybulko.insurance.dto.PropertyDTO;
import com.tsybulko.insurance.dto.VehicleDTO;
import lombok.*;
import org.springframework.web.bind.annotation.Mapping;

import javax.persistence.*;


@Data
@Entity
@Table(name = "insurance_objects")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "contenttype")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Vehicle.class),
        @JsonSubTypes.Type(value = Property.class)
})
public abstract class InsuranceObject {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="owner_id")
    private Person owner;

    @Enumerated(EnumType.STRING)
    private ObjType type;
}
