package com.tsybulko.insurance.service;

import com.tsybulko.insurance.entity.Policy;

import java.util.List;
import java.util.Optional;

public interface PolicyService {
    List<Policy> findAll();
    Optional<Policy> findById(Integer id);
    void addPolicy(Policy policy);
    void editPolicy(Policy policy, Integer id);
    void delete(Policy policy);
    void deleteById(Integer id);
    void deleteAll();
}
