package com.tsybulko.insurance.repository;

import com.tsybulko.insurance.entity.InsuranceObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceObjectRepository extends JpaRepository<InsuranceObject, Integer> {
}
