package com.bulletproof.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bulletproof.application.CsvJsonApplication;
import com.bulletproof.repository.CustomerRepository;
import com.bulletproof.resource.Customer;
import com.google.gson.JsonArray;

@RestController
@RequestMapping(value = "/")
public class CustomerServiceController {

    @Autowired
    private CustomerRepository customerRepository;

    // works. Sends json string to rest endpoint.
    @RequestMapping(value = "/rest/customer", method = RequestMethod.GET)
    public JsonArray getAllCustomers1() {
	System.out.println("1");
	return CsvJsonApplication.jsonCustomer;
    }

    @RequestMapping(value = "/rest/customer", method = RequestMethod.POST)
    public JsonArray getAllCustomers2() {
	System.out.println("2");
	return CsvJsonApplication.jsonCustomer;
    }

    @RequestMapping(value = "/rest/addCustomer", method = RequestMethod.POST)
    public String getAllCustomers3(@RequestBody(required = true) String data) {

	System.out.println("3");
	System.out.println(data);
	// assume happy case
	String[] str = data.split(",");
	Customer c = new Customer(str[0], str[1], str[2]);
	customerRepository.save(c);

	return "Saved";

    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Customer> getAllUsers() {
	System.out.println("4"); // This returns a JSON or XML with the users
	return customerRepository.findAll();
    }

}
