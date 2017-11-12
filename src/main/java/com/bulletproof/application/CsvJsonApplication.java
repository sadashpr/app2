package com.bulletproof.application;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.bulletproof.resource.CSVParser;
import com.google.gson.JsonArray;

@SpringBootApplication(scanBasePackages = "com.bulletproof")
@Configuration
@ComponentScan({ "com.bulletproof.service", "com.bulletproof.repository", "com.bulletproof" })
@EnableJpaRepositories({ "com.bulletproof.service", "com.bulletproof.repository", "com.bulletproof.resource" })
@EntityScan("com.bulletproof.resource")
public class CsvJsonApplication {

    // store the parsed csv data for quick retrieval.
    public static JsonArray jsonCustomer;

    public static void main(String[] args) throws FileNotFoundException, IOException {

	CSVParser parser = new CSVParser();
	parser.parseData();
	jsonCustomer = parser.getJsondata();

	// start springboot application.
	SpringApplication.run(CsvJsonApplication.class, args);
    }

}
