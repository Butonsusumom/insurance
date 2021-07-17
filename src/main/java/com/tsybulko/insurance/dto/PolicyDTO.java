package com.tsybulko.insurance.dto;

import com.tsybulko.insurance.entity.InsuranceObject;
import com.tsybulko.insurance.entity.Person;
import com.tsybulko.insurance.entity.TermCondition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PolicyDTO {
    private Integer id;

    @NotBlank(message = "{valid.policenumber.notNull}")
    private String policeNumber;

    @NotNull(message = "{valid.person.notNull}")
    private PersonDTO person;

    @NotNull(message = "{valid.condition.notNull}")
    private TermConditionDTO condition;

    @NotNull(message = "{valid.insobject.notNull}")
    private InsuranceObject object;
}
