package com.bulletproof.resource;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.search.annotations.Field;

@Entity
public class Customer {

    private static long counter = 1;

    @Id
    private long id;
    @Field
    private String firstname;
    @Field
    private String lastname;
    @Field
    private String city;

    public Customer(String firstname, String lastname, String city) {

	this.id = counter++;
	// TODO use UUID.randomUUID().toString() later
	this.firstname = firstname;
	this.lastname = lastname;
	this.city = city;
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public String getFirstname() {
	return firstname;
    }

    public void setFirstname(String firstname) {
	this.firstname = firstname;
    }

    public String getLastname() {
	return lastname;
    }

    public void setLastname(String lastname) {
	this.lastname = lastname;
    }

    public String getCity() {
	return city;
    }

    public void setCity(String city) {
	this.city = city;
    }

    /*
     * @Override public String toString() { return "Customer [ ID =" + id +
     * ", firstname=" + firstname + ", lastname=" + lastname + ", city=" + city +
     * "]"; }
     */

}
