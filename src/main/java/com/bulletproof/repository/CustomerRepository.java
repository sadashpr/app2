package com.bulletproof.repository;

import org.springframework.data.repository.CrudRepository;

import com.bulletproof.resource.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
