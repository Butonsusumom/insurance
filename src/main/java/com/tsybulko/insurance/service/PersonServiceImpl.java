package com.tsybulko.insurance.service;

import com.tsybulko.insurance.entity.Person;
import com.tsybulko.insurance.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService{
    @Autowired
    private PersonRepository personRepository;

    @Override
    public Page<Person> findAll(Pageable pageable) {
        return personRepository.findAll(pageable);
    }

    public Optional<Person> findById(Integer id) {
        return personRepository.findById(id);
    }

    public  void addPerson(Person person){
        personRepository.save(person);
    }

    @Override
    public  void editPerson(Person person, Integer id){
        person.setId(id);
        personRepository.save(person);
    }

    @Override
    public void delete(Person object) {
        personRepository.delete(object);
    }

    @Override
    public void deleteById(Integer id) {
        personRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        personRepository.deleteAll();
    }
}
