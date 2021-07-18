package com.tsybulko.insurance.controller;

import com.tsybulko.insurance.entity.InsuranceObject;
import com.tsybulko.insurance.entity.Policy;
import com.tsybulko.insurance.exception.ResourceNotFoundException;
import com.tsybulko.insurance.service.InsuranceObjectService;
import com.tsybulko.insurance.service.PolicyService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/insuranceobject")
@Log4j2
public class InsuranceObjectController {

    private final InsuranceObjectService insuranceObjectService;

    @Autowired
    public InsuranceObjectController(InsuranceObjectService insuranceObjectService) {
        this.insuranceObjectService = insuranceObjectService;
    }

    @GetMapping(value = {"/person/{id}"})
    public List<InsuranceObject> findByOwner(@PathVariable("id") Integer id) throws ResourceNotFoundException {
        log.info("Print objects by person ID");
        return  insuranceObjectService.findByOwnerId(id);
        //return Mapper.map(personService.findById(id), PersonDTO.class);
    }
}
