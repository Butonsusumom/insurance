package com.tsybulko.insurance.repository;

import com.tsybulko.insurance.entity.Person;
import com.tsybulko.insurance.entity.Policy;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
