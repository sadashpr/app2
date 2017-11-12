package com.bulletproof.resource;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.bulletproof.model.Customer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

@Service
public class CSVParser {

    // link to the CSV file.
    private static final String csvFile = "Book1.csv";
    private static ArrayList<Customer> customers = new ArrayList<>();

    /**
     * Logic to parse CSV to customer objects
     * 
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void parseData() throws FileNotFoundException, IOException {

	BufferedReader bReader = new BufferedReader(
		new InputStreamReader(this.getClass().getResourceAsStream("/" + csvFile)));

	String[] fields;
	String line;
	// read one line at a time
	while ((line = bReader.readLine()) != null) {
	    fields = line.split(",");
	    Customer c = new Customer(fields[0], fields[1], fields[2]);
	    customers.add(c);
	}
    }

    /**
     * get a json array from list of objects
     * 
     * @return
     * @throws JsonProcessingException
     */
    public JsonArray getJsondata() throws JsonProcessingException {

	Gson gson = new GsonBuilder().create();
	JsonArray jsonCustomer = gson.toJsonTree(customers).getAsJsonArray();
	return jsonCustomer;
    }

}
