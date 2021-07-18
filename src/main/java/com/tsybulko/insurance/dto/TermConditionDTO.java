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
    @Digits(integer=10, fraction=2, message = "{valid.price.digits}")
    private Integer price;

    @NotNull(message = "{valid.instype.notNull}")
    private InsType insType;

    @NotNull(message = "{valid.startdate.notNull}")
    private Date startDate;

    @NotNull(message = "{valid.enddate.notNull}")
    private Date endDate;
}
