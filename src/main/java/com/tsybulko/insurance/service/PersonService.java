package com.tsybulko.insurance.service;

import com.tsybulko.insurance.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PersonService {
    Page<Person> findAll(Pageable pageable);
    Optional<Person> findById(Integer id);
    void addPerson(Person person);
    void editPerson(Person person, Integer id);
    void delete(Person object);
    void deleteById(Integer id);
    void deleteAll();
}
