package com.bulletproof.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bulletproof.application.CsvJsonApplication;
import com.bulletproof.model.Customer;
import com.bulletproof.resource.JsonCustomerParser;
import com.bulletproof.service.CustomerService;

@RestController
@Component
@RequestMapping(value = "/")
public class CustomerServiceController {

    // @Autowired
    // private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private JsonCustomerParser jsonCustomerParser;

    /**
     * part of application 1 post json data to rest end point.
     * 
     * @return
     */
    @RequestMapping(value = "/rest/customer", method = RequestMethod.POST)
    public String sendCSVCustomerData() {

	return CsvJsonApplication.jsonCustomer.toString();
    }

    /**
     * gets data as JSON String with array of customers (from application 1)and
     * saves to DB.
     * 
     * @param data
     * @return
     */
    @RequestMapping(value = "/rest/addallcustomer", method = RequestMethod.POST)
    public String allAllCustomerData(@RequestBody(required = true) String data) {

	// assume happy case
	Customer[] customers = jsonCustomerParser.convertToManyCustomers(data);
	for (Customer customer : customers) {
	    customerService.save(customer);
	}
	return "Saved all customer data";
    }

    /**
     * returns all customer data
     * 
     * @return
     */
    @GetMapping(path = "/rest/showallcustomers")
    public @ResponseBody Iterable<Customer> getAllUsers() {
	// This returns a JSON with all customers
	return customerService.findAll();
    }

    /**
     * adds a single customer. Will overwrite existing customer in case of ID
     * conflict.
     * 
     * @param data
     * @return
     */
    @RequestMapping(value = "/rest/addacustomer", method = RequestMethod.POST)
    public String addACustomer(@RequestBody(required = true) String data) {

	// assume happy case Scenario and parse for now .
	Customer c = jsonCustomerParser.convertToACustomer(data);
	customerService.save(c);
	return "Saved";
    }

    /**
     * Search customer by id
     * 
     * @param id
     * @return
     */

    @RequestMapping(value = "/rest/searchacustomerbyID", method = RequestMethod.POST)
    public Customer searchACustomerbyID(@RequestBody(required = true) String id) {

	return customerService.findOne(Long.valueOf(id));
    }

    /**
     * Search customer by first name
     * 
     * @param firstname
     * @return
     */
    @RequestMapping(value = "/rest/searchacustomerbyfirstname", method = RequestMethod.POST)
    public Customer[] searchACustomerbyFirstname(@RequestBody(required = true) String firstname) {

	return customerService.findCustomerByFirstname(firstname);

    }

}