package com.tsybulko.insurance.service;

import com.tsybulko.insurance.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    List<Person> findAll();
    Optional<Person> findById(Integer id);
    void addPerson(Person person);
    void editPerson(Person person, Integer id);
    void delete(Person object);
    void deleteById(Integer id);
    void deleteAll();
}
