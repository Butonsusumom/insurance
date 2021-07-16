package com.tsybulko.insurance.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "propertyes")
public class Property extends InsuranceObject {
    @Column(name="addresse",unique=true)
    private String address;

    @Column(name="zip")
    private String zip;
}
