package com.tsybulko.insurance.service;

import com.tsybulko.insurance.entity.Policy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PolicyService {
    Page<Policy> findAll(Pageable pageable);
    Optional<Policy> findById(Integer id);
    List<Policy> findByPersonID (Integer id);
    void addPolicy(Policy policy);
    void editPolicy(Policy policy, Integer id);
    void delete(Policy policy);
    void deleteById(Integer id);
    void deleteAll();
}
