package com.tsybulko.insurance.service;


import com.tsybulko.insurance.entity.InsuranceObject;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface InsuranceObjectService {
    List<InsuranceObject> findAll();
    Optional<InsuranceObject> findById(Integer id);
    void addInsuranceObject(InsuranceObject insuranceObject);
    void editInsuranceObject(InsuranceObject insuranceObject, Integer id);
    void delete(InsuranceObject insuranceObject);
    void deleteById(Integer id);
    void deleteAll();
}
