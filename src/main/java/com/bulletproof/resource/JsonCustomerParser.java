package com.bulletproof.resource;

import com.google.gson.Gson;

public class JsonCustomerParser {

    /**
     * Convert json string to Customer object.
     * 
     * @param data
     * @return
     */
    public static Customer convertToACustomer(String data) {

	Gson g = new Gson();
	Customer customer = g.fromJson(data, Customer.class);
	System.out.println(customer.toString());
	return customer;
    }

    /**
     * Convert jsonstring to array of customer objects .
     * 
     * @param data
     * @return
     */
    public static Customer[] convertToManyCustomers(String data) {

	System.out.println(data);
	Gson g = new Gson();
	Customer[] customers = g.fromJson(data, Customer[].class);
	System.out.println(customers.toString());
	return customers;
    }
}
