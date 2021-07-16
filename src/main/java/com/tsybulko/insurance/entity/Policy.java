package com.tsybulko.insurance.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "policies")
public class Policy {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(name="police_number",unique=true)
    private String policeNumber;

    @ManyToOne
    @JoinColumn(name="person_id")
    private Person person;

    @OneToOne
    @JoinColumn(name="condition_id")
    private TermCondition condition;

    @OneToOne
    @JoinColumn(name="object_id")
    private InsuranceObject object;
}
