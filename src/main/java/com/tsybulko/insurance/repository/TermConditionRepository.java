package com.tsybulko.insurance.repository;

import com.tsybulko.insurance.entity.TermCondition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TermConditionRepository extends JpaRepository<TermCondition, Integer> {
}
