package com.spandiar.dto;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//@Embeddable
@Entity
@Table (name="customer_address")
public class CustomerAddress {

	@Id
	@GeneratedValue
	private int addressId;
	private String addressType;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String country;
	private String zip;
	@ManyToOne 
	@JoinColumn(name="customerid")
	private CustomerDetails customer;
	
	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	
	public CustomerDetails getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDetails customer) {
		this.customer = customer;
	}
	
	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public CustomerAddress() {
		// TODO Auto-generated constructor stub
	}
	
	public CustomerAddress(String addType, String add1, String add2, String city, String state, String country, String zip) {
		// TODO Auto-generated constructor stub
		this.addressType = addType;
		this.address1 = add1;
		this.address2 = add2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
	}

}
