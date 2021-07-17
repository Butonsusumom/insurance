package com.tsybulko.insurance.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;


@Data
@Entity
@Table(name = "term_conditions")
public class TermCondition {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(name="description")
    private String description;

    @Column(name="price")
    private Integer price;

    @Column(name="insurance_type")
    @Enumerated(EnumType.STRING)
    private InsType insType;

    @Column(name="start_date")
    private Date startDate;

    @Column(name="end_date")
    private Date endDate;


}
