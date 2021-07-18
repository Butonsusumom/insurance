package com.tsybulko.insurance.controller;

import com.tsybulko.insurance.dto.PersonDTO;
import com.tsybulko.insurance.entity.Person;
import com.tsybulko.insurance.exception.ResourceNotFoundException;
import com.tsybulko.insurance.service.PersonService;
import com.tsybulko.insurance.util.Mapper;
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
@RequestMapping("/person")
@Log4j2
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("")
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

    @GetMapping(value = {"/{id}"})
    public Optional<Person> findById(@PathVariable("id") Integer id) throws ResourceNotFoundException {
        log.info("Print person by ID");
        return  personService.findById(id);
       //return Mapper.map(personService.findById(id), PersonDTO.class);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void  savePerson(@Valid @RequestBody PersonDTO personDto) {
        log.info("Add a new person");
        personService.addPerson(Mapper.map(personDto, Person.class));
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void editPerson(@PathVariable("id") Integer id, @Valid @RequestBody PersonDTO persondto) throws ResourceNotFoundException {
        if (personService.findById(id)!=null) {
            personService.editPerson(Mapper.map(persondto, Person.class),id);
            log.info("Edit person by ID");
        }
        else log.warn("No such person by ID");

    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePerson(@PathVariable("id") Integer id) throws ResourceNotFoundException {
        log.info("Delete person by ID");
        personService.deleteById(id);
    }

    @DeleteMapping(value = "")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAll () throws ResourceNotFoundException {
        log.info("Delete all persons");
        personService.deleteAll();
    }
}
