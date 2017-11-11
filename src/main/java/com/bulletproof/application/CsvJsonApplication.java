package com.bulletproof.application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bulletproof.resource.CSVParser;
import com.bulletproof.resource.Customer;
import com.google.gson.JsonArray;

@SpringBootApplication
public class CsvJsonApplication {

    public static HashMap<String, Customer> hmCustomer;
    public static long ID;
    public static JsonArray jsonCustomer;

    public static void main(String[] args) throws FileNotFoundException, IOException {

	CSVParser parser = new CSVParser();
	parser.parseData();
	jsonCustomer = parser.getJsondata();

	// System.out.println(jsonCustomer.toString());
	SpringApplication.run(CsvJsonApplication.class, args);
    }

}
