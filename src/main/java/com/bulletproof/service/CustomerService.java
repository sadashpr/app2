package com.bulletproof.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bulletproof.model.Customer;
import com.bulletproof.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void save(Customer customer) {
	customerRepository.save(customer);
    }

    public Iterable<Customer> findAll() {
	return customerRepository.findAll();
    }

    public Customer findOne(Long id) {
	return customerRepository.findOne(id);
    }

    public Customer[] findCustomerByFirstname(String firstname) {
	return customerRepository.findCustomerByFirstname(firstname);
    }

}
