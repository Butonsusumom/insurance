package com.tsybulko.insurance.controller;

import com.tsybulko.insurance.entity.InsuranceObject;
import com.tsybulko.insurance.entity.Policy;
import com.tsybulko.insurance.exception.ResourceNotFoundException;
import com.tsybulko.insurance.service.InsuranceObjectService;
import com.tsybulko.insurance.service.PolicyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RestControllerAdvice
@RequestMapping("/insuranceobject")
@Log4j2
public class InsuranceObjectController {

    private final InsuranceObjectService insuranceObjectService;

    @Autowired
    public InsuranceObjectController(InsuranceObjectService insuranceObjectService) {
        this.insuranceObjectService = insuranceObjectService;
    }

    @Operation(summary = "Get insurance objects by owner")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found insurance object")})
    @GetMapping(value = {"/person/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public List<InsuranceObject> findByOwner(@PathVariable("id") Integer id) throws ResourceNotFoundException {
        log.info("Print objects by person ID");
        return  insuranceObjectService.findByOwnerId(id);
        //return Mapper.map(personService.findById(id), PersonDTO.class);
    }
}
