package com.tsybulko.insurance.service;

import com.tsybulko.insurance.entity.Person;
import com.tsybulko.insurance.entity.Policy;
import com.tsybulko.insurance.repository.PersonRepository;
import com.tsybulko.insurance.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyServiceImpl implements PolicyService {

        @Autowired
        public PolicyRepository policyRepository;

        @Autowired
        public PersonRepository personRepository;

        @Override
        public Page<Policy> findAll(Pageable pageable) {
                return policyRepository.findAll(pageable);
        }

        @Override
        public Optional<Policy> findById(Integer id) {
                return policyRepository.findById(id);
        }

        @Override
        public List<Policy> findByPersonID(Integer id) {
                Optional<Person> person = personRepository.findById(id);
                return policyRepository.findPoliciesByPerson(person);
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
