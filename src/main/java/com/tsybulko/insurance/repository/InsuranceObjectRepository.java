package com.tsybulko.insurance.repository;

import com.tsybulko.insurance.entity.InsuranceObject;
import com.tsybulko.insurance.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InsuranceObjectRepository extends JpaRepository<InsuranceObject, Integer> {
    List<InsuranceObject> findInsuranceObjectsByOwner(Optional<Person> person);
}
