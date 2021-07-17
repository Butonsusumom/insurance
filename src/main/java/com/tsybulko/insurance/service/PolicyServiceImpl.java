package com.tsybulko.insurance.service;

import com.tsybulko.insurance.entity.Policy;
import com.tsybulko.insurance.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyServiceImpl implements PolicyService {

        @Autowired
        public PolicyRepository policyRepository;

        @Override
        public List<Policy> findAll() {
                return policyRepository.findAll();
        }

        @Override
        public Optional<Policy> findById(Integer id) {
                return policyRepository.findById(id);
        }

        @Override
        public void addPolicy(Policy policy) {
                policyRepository.save(policy);
        }

        @Override
        public void editPolicy(Policy policy, Integer id) {
                policy.setId(id);
                policyRepository.save(policy);
        }

        @Override
        public void delete(Policy policy) {
                policyRepository.delete(policy);
        }

        @Override
        public void deleteById(Integer id) {
                policyRepository.deleteById(id);
        }

        @Override
        public void deleteAll() {
                policyRepository.deleteAll();
        }
}
