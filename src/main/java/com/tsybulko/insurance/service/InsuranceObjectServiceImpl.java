package com.tsybulko.insurance.service;

import com.tsybulko.insurance.entity.InsuranceObject;
import com.tsybulko.insurance.entity.Person;
import com.tsybulko.insurance.repository.InsuranceObjectRepository;
import com.tsybulko.insurance.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsuranceObjectServiceImpl implements InsuranceObjectService{

    @Autowired
    private InsuranceObjectRepository insuranceObjectRepository;

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<InsuranceObject> findAll() {
        return insuranceObjectRepository.findAll();
    }

    @Override
    public Optional<InsuranceObject> findById(Integer id) {
        return insuranceObjectRepository.findById(id);
    }

    @Override
    public List<InsuranceObject> findByOwnerId(Integer id) {
        Optional<Person> person = personRepository.findById(id);
        return insuranceObjectRepository.findInsuranceObjectsByOwner(person);
    }

    @Override
    public void addInsuranceObject(InsuranceObject insuranceObject) {
        insuranceObjectRepository.save(insuranceObject);
    }

    @Override
    public void editInsuranceObject(InsuranceObject insuranceObject, Integer id) {
        insuranceObject.setId(id);
        insuranceObjectRepository.save(insuranceObject);
    }

    @Override
    public void delete(InsuranceObject insuranceObject) {
        insuranceObjectRepository.delete(insuranceObject);
    }

    @Override
    public void deleteById(Integer id) {
        insuranceObjectRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        insuranceObjectRepository.deleteAll();
    }
}
