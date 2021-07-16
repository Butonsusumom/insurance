package com.tsybulko.insurance.controller;


import com.tsybulko.insurance.dto.InsuranceObjectDTO;
import com.tsybulko.insurance.dto.PersonDTO;
import com.tsybulko.insurance.entity.InsuranceObject;
import com.tsybulko.insurance.entity.Person;
import com.tsybulko.insurance.entity.Vehicle;
import com.tsybulko.insurance.exception.ResourceNotFoundException;
import com.tsybulko.insurance.service.InsuranceObjectService;
import com.tsybulko.insurance.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/object")
public class InsuranceObjectController {

    private final InsuranceObjectService insuranceObjectService;

    @Autowired
    public InsuranceObjectController(InsuranceObjectService insuranceObjectService) {
        this.insuranceObjectService = insuranceObjectService;
    }

    @GetMapping("")
    public List<InsuranceObject> objectList() {
        return Mapper.mapAll(insuranceObjectService.findAll(), InsuranceObject.class);
    }

    @GetMapping("/vehicle")
    public List<Vehicle> vehicleList(){
        return
    }

    @GetMapping(value = {"/{id}"})
    public Optional<InsuranceObject> findById(@PathVariable("id") Integer id) throws ResourceNotFoundException {
        return  insuranceObjectService.findById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void  saveObject(@Valid @RequestBody InsuranceObject insuranceObjectDTO) {
        insuranceObjectService.addInsuranceObject(Mapper.map(insuranceObjectDTO, InsuranceObject.class));
        //insuranceObjectService.addInsuranceObject(insuranceObject);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void editPerson(@PathVariable("id") Integer id, @Valid @RequestBody InsuranceObject insuranceObject) throws ResourceNotFoundException {
        if (insuranceObjectService.findById(id).isPresent())
            insuranceObjectService.editInsuranceObject(insuranceObject,id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePerson(@PathVariable("id") Integer id) throws ResourceNotFoundException {
        insuranceObjectService.deleteById(id);
    }

    @DeleteMapping(value = "")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAll () throws ResourceNotFoundException {
        insuranceObjectService.deleteAll();
    }
}
