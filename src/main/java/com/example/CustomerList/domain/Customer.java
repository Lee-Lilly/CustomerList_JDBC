package com.example.CustomerList.domain;


public class Customer {
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	
	public Customer () { //initiate an constructor with null value.
	        this.id = 1;
	        this.firstName = null;
	        this.lastName = null;
	        this.email = null;
	 }
	 
	 public Customer (long id, String firstName, String lastName, String email) {
	        this.id = id;
	        this.firstName = firstName;
	        this.lastName = lastName;
	 }
	 //in case the customer_id is incremental automatically in the schema.sql  
	 public Customer (String firstName, String lastName, String email) {
	        this.id = 0;
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.email = email;
	 }
	
	@Override
	public String toString() {
		return String.format("Customer[id=%d, firstName='%s', lastName='%s', email='%s']", id, firstName, lastName, email);
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
}
