package com.tsybulko.insurance.controller;

import com.tsybulko.insurance.dto.PersonDTO;
import com.tsybulko.insurance.entity.Person;
import com.tsybulko.insurance.exception.ResourceNotFoundException;
import com.tsybulko.insurance.service.PersonService;
import com.tsybulko.insurance.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("")
    public List<PersonDTO> personList() {
            return Mapper.mapAll(personService.findAll(), PersonDTO.class);
    }

    @GetMapping(value = {"/{id}"})
    public Optional<Person> findById(@PathVariable("id") Integer id) throws ResourceNotFoundException {
        return  personService.findById(id);
       //return Mapper.map(personService.findById(id), PersonDTO.class);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void  savePerson(@Valid @RequestBody PersonDTO personDto) {
        personService.addPerson(Mapper.map(personDto, Person.class));
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void editPerson(@PathVariable("id") Integer id, @Valid @RequestBody PersonDTO persondto) throws ResourceNotFoundException {
        if (personService.findById(id).isPresent())
            personService.editPerson(Mapper.map(persondto, Person.class),id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePerson(@PathVariable("id") Integer id) throws ResourceNotFoundException {
        personService.deleteById(id);
    }

    @DeleteMapping(value = "")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAll () throws ResourceNotFoundException {
        personService.deleteAll();
    }
}
