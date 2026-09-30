package com.trainee.spring.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class EmployeeInfo {

	private long id;
	private String name;
	private String city;
	private String street;
	private String zipcode;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	@Override
	public String toString() {
		return "EmployeeInfo [id=" + id + ", name=" + name + ", city=" + city + ", street=" + street + ", zipcode="
				+ zipcode + "]";
	}

	public EmployeeInfo() {

	}

	public EmployeeInfo(String name, String city, String street, String zipcode) {
		this.name = name;
		this.city = city;
		this.street = street;
		this.zipcode = zipcode;

	}
}
