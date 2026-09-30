package com.trainee.spring.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


public class Address {

	
	private long id;
	private String street;
	private String zipcode;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Address() {

	}

	public Address(String street, String zipcode) {
		this.street = street;
		this.zipcode = zipcode;

	}

}
