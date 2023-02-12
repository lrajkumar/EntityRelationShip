package com.EmployeeCrudTest.Entity;

import lombok.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="emplyeecrudtable")
public class Employee {
	  @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 private long id;
	 private String firstName;
	 private String lastName;
	 private String emailId;
	
	 
	 
	public Employee(long id, String firstName, String lastName, String emailId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
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
	public Employee setFirstName(String employee) {
		this.firstName = employee;
		return this;
	}
	public String getLastName() {
		return lastName;
	}
	public Employee setLastName(String employee) {
		this.lastName = employee;
		return this;
	}
	public String getEmailId() {
		return emailId;
	}
	public Employee setEmailId(String employee) {
		this.emailId = employee;
		return this;
	}
	
	
	/*public Employee build(Employee employee) {
		// TODO Auto-generated method stub
		return employee;
	}
	
	

	public void willAnswer(Object employee) {
		// TODO Auto-generated method stub
		
	}*/
	 
	 

}
