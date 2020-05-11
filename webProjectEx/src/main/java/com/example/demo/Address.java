package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Address")
public class Address {
	
	@Id
	private int StreetId;
	private String street;
	private String city;
	private String country;
	private String pincode;
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	
	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", country=" + country + ", pincode=" + pincode + "]";
	}
	
	
	public Address(String street, String city, String country, String pincode) {
		super();
		this.street = street;
		this.city = city;
		this.country = country;
		this.pincode = pincode;
	}
	
	
	public Address() {
		super();
	}
	
	
	
}
