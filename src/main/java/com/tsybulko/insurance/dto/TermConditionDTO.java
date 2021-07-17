package com.tsybulko.insurance.dto;

import com.tsybulko.insurance.entity.InsType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TermConditionDTO {
    private Integer id;

    @NotNull(message = "{valid.description.notNull}")
    private String description;

    @NotNull(message = "{valid.price.notNull}")
    @Digits(integer=10, fraction=2, message = "{valid..notNull}")
    private Integer price;

    @Column(name="insurance_type")
    private InsType insType;

    @Column(name="start_date")
    private Date startDate;

    @Column(name="end_date")
    private Date endDate;
}
