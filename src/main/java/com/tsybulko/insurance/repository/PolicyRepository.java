package com.tsybulko.insurance.repository;

import com.tsybulko.insurance.entity.Person;
import com.tsybulko.insurance.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface PolicyRepository extends JpaRepository<Policy, Integer> {
    List<Policy> findPoliciesByPerson(Optional<Person> person);
}
