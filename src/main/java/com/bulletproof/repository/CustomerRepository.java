package com.bulletproof.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bulletproof.resource.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
