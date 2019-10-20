package com.spandiar.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

//import javax.persistence.*;

@Entity
@Table (name="customer_details")
public class CustomerDetails {
	@Id
	private int customerID;
	@Column (name="first_name")
	private String customerFirstName;
	@Column (name="last_name")
	private String customerLastName;
	@Column (name="email")
	private String customerEmail;
	private LocalDate DoB;
	@Temporal (TemporalType.TIMESTAMP)
	private Date createdDt;
	@ElementCollection (fetch=FetchType.EAGER)
	//@JoinTable (name="customer_address", joinColumns = @JoinColumn(name="customerid"))
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	//@OneToMany
	@JoinColumn(name="customerid")
	private Collection<CustomerAddress> address = new ArrayList<CustomerAddress>();
	
	
	public Date getCreatedDt() {
		return createdDt;
	}
	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getCustomerFirstName() {
		return customerFirstName;
	}
	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}
	
	public String getCustomerLastName() {
		return customerLastName;
	}
	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	
	public LocalDate getDoB() {
		return DoB;
	}
	public void setDoB(LocalDate doB) {
		DoB = doB;
	}
	
	public CustomerDetails() {
	// default constructor	
	}
	
	public CustomerDetails(int Id, String fN, String lN, String email, LocalDate DoB ){
		// Default Constructor
		this.customerID = Id;
		this.customerFirstName = fN;
		this.customerLastName = lN;
		this.customerEmail = email;
		this.DoB = DoB;
		this.createdDt = new Date();
		
	}
	public Collection<CustomerAddress> getAddress() {
		return address;
	}
	public void setAddress(Collection<CustomerAddress> address) {
		this.address = address;
	}
	
}
