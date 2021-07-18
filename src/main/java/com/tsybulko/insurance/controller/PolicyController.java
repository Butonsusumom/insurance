package com.tsybulko.insurance.controller;

import com.tsybulko.insurance.dto.PolicyDTO;
import com.tsybulko.insurance.entity.Person;
import com.tsybulko.insurance.entity.Policy;
import com.tsybulko.insurance.exception.ResourceNotFoundException;
import com.tsybulko.insurance.service.PolicyService;
import com.tsybulko.insurance.util.Mapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RestControllerAdvice
@RequestMapping("/policy")
@Log4j2
public class PolicyController {
    private final PolicyService policyService;

    @Autowired
    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }

    @Operation(summary = "Get all policies")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found policies") })
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Page<Policy> policyList(
            @RequestParam Optional<Integer> page,
            @RequestParam Optional<String> sortBy) {
        log.info("Print all policies");
        return policyService.findAll(PageRequest.of(
                page.orElse(0),
                5,
                Sort.Direction.ASC, sortBy.orElse("id")
        ));
    }

    @Operation(summary = "Get policy by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found a policy"),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied")})
    @GetMapping(value = {"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Optional<Policy> findById(@PathVariable("id") Integer id) throws ResourceNotFoundException {
        log.info("Print policy by ID");
        return  policyService.findById(id);
        //return Mapper.map(personService.findById(id), PersonDTO.class);
    }

    @Operation(summary = "Get persons policies")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found policies"),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied")})
    @GetMapping(value = {"/person/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public List<Policy> findByPerson(@PathVariable("id") Integer id) throws ResourceNotFoundException {
        log.info("Print policy by person ID");
        return  policyService.findByPersonID(id);
        //return Mapper.map(personService.findById(id), PersonDTO.class);
    }

    @Operation(summary = "Create a policy")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Policy created",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Policy.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid input supplied",
                    content = @Content)})
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void  savePolicy(@Valid @RequestBody PolicyDTO policyDto) {
        log.info("Add new policy");
        policyService.addPolicy(Mapper.map(policyDto, Policy.class));
    }

    @Operation(summary = "Edit policy by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Policy have edited",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Policy.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid input supplied",
                    content = @Content)})
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void editPolicy(@PathVariable("id") Integer id, @Valid @RequestBody PolicyDTO policydto) throws ResourceNotFoundException {
        if (policyService.findById(id).isPresent()) {
            policyService.editPolicy(Mapper.map(policydto, Policy.class),id);
            log.info("Edit policy by ID");
        }
           else log.warn("No such policy by ID");
    }

    @Operation(summary = "Delete policy by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Policy deleted")})
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePolicy(@PathVariable("id") Integer id) throws ResourceNotFoundException {
        policyService.deleteById(id);
        log.info("Delete policy by ID");
    }

    @Operation(summary = "Delete all")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All policies deleted")})
    @DeleteMapping(value = "")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAll () throws ResourceNotFoundException {
        policyService.deleteAll();
        log.info("Delete all policies");
    }
}

