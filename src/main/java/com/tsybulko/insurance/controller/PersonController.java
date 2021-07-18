package com.tsybulko.insurance.controller;

import com.tsybulko.insurance.dto.PersonDTO;
import com.tsybulko.insurance.entity.Person;
import com.tsybulko.insurance.exception.ResourceNotFoundException;
import com.tsybulko.insurance.service.PersonService;
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
import java.util.Optional;

@RestController
@RestControllerAdvice
@RequestMapping("/person")
@Log4j2
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @Operation(summary = "Get all persons")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found persons") })
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Page<Person> personList(
            @RequestParam Optional<Integer> page,
            @RequestParam Optional<String> sortBy) {
        log.info("Print all persons");
            return personService.findAll(
                    PageRequest.of(
                            page.orElse(0),
                            5,
                            Sort.Direction.ASC, sortBy.orElse("id")
                    )
            );
    }

    @Operation(summary = "Get person by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found a person"),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied")})
    @GetMapping(value = {"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Optional<Person> findById(@PathVariable("id") Integer id) throws ResourceNotFoundException {
        log.info("Print person by ID");
        return  personService.findById(id);
       //return Mapper.map(personService.findById(id), PersonDTO.class);
    }

    @Operation(summary = "Create a person")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Person created",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Person.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid input supplied",
                    content = @Content)})
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void  savePerson(@Valid @RequestBody PersonDTO personDto) {
        log.info("Add a new person");
        personService.addPerson(Mapper.map(personDto, Person.class));
    }

    @Operation(summary = "Edit person by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Person have edited",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Person.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid input supplied",
                    content = @Content)})
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void editPerson(@PathVariable("id") Integer id, @Valid @RequestBody PersonDTO persondto) throws ResourceNotFoundException {
        if (personService.findById(id).isPresent()) {
            personService.editPerson(Mapper.map(persondto, Person.class),id);
            log.info("Edit person by ID");
        }
        else log.warn("No such person by ID");
    }

    @Operation(summary = "Delete person by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Person deleted")})
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePerson(@PathVariable("id") Integer id) throws ResourceNotFoundException {
        log.info("Delete person by ID");
        personService.deleteById(id);
    }

    @Operation(summary = "Delete all")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All persons deleted")})
    @DeleteMapping(value = "")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAll () throws ResourceNotFoundException {
        log.info("Delete all persons");
        personService.deleteAll();
    }
}
