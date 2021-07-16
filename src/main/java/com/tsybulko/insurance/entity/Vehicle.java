package com.tsybulko.insurance.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "vehicles")
public class Vehicle extends InsuranceObject {
    @Column(name="drivers_licence")
    private String driversLicence;

    @Column(name="registry_number",unique=true)
    private String regNumber;
}
