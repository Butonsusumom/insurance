package com.tsybulko.insurance.controller;

import com.tsybulko.insurance.dto.PolicyDTO;
import com.tsybulko.insurance.entity.Policy;
import com.tsybulko.insurance.exception.ResourceNotFoundException;
import com.tsybulko.insurance.service.PolicyService;
import com.tsybulko.insurance.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/policy")
public class PolicyController {
    private final PolicyService policyService;

    @Autowired
    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }

    @GetMapping("")
    public List<Policy> policyList() {
        return policyService.findAll();
    }

    @GetMapping(value = {"/{id}"})
    public Optional<Policy> findById(@PathVariable("id") Integer id) throws ResourceNotFoundException {
        return  policyService.findById(id);
        //return Mapper.map(personService.findById(id), PersonDTO.class);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void  savePolicy(@Valid @RequestBody PolicyDTO policyDto) {
        policyService.addPolicy(Mapper.map(policyDto, Policy.class));
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void editPolicy(@PathVariable("id") Integer id, @Valid @RequestBody PolicyDTO policydto) throws ResourceNotFoundException {
        if (policyService.findById(id).isPresent())
            policyService.editPolicy(Mapper.map(policydto, Policy.class),id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePolicy(@PathVariable("id") Integer id) throws ResourceNotFoundException {
        policyService.deleteById(id);
    }

    @DeleteMapping(value = "")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAll () throws ResourceNotFoundException {
        policyService.deleteAll();
    }
}

