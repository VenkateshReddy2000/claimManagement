package com.expensemanagement.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Employee implements Comparable<Employee> {

	private int id;
	private String title;
	private String firstName;
	private String surName;
	private String jobTitle;
	private Department department;
	private Map<Integer, ExpenseClaim> claims = new HashMap<>();
 
	public Employee() {
      
	}

	public Employee(int id,String jobTitle) {
		this.id= id;
		this.jobTitle=jobTitle;
		
	}
	
	public Employee(int id, String title, String firstName, String surName, String jobTitle, Department department) {
		super();
		this.id = id;
		this.title = title;
		this.firstName = firstName;
		this.surName = surName;
		this.jobTitle = jobTitle;
		this.department = department;
	}
	
	public String getMailingName() {
		return title + " " + firstName + " " + surName;
	}
	public String getMailingName(boolean firstIntialOnly) {
		if(firstIntialOnly) {
			return title +  " " + firstName.substring(0,1) + " " + surName;
		}else {
			return title + " " + surName;
		}
	}
	

	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		if(firstName.length()< 2) {
			System.out.println("Error - firstname must be atleast 2 characters");
		}else {
			this.firstName=firstName;
		}

		this.firstName = firstName;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public Map<Integer,ExpenseClaim> getClaims() {
		return claims;
	}

	@Override
	public int hashCode() {
		return Objects.hash(claims, department, firstName, id, jobTitle, surName, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(claims, other.claims) && department == other.department
				&& Objects.equals(firstName, other.firstName) && id == other.id
				&& Objects.equals(jobTitle, other.jobTitle) && Objects.equals(surName, other.surName)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", title=" + title + ", firstName=" + firstName + ", surName=" + surName
				+ ", jobTitle=" + jobTitle + ", department=" + department + "]";
	}

	@Override
	public int compareTo(Employee o) {
		
		return this.surName.compareTo(getSurName());
	}

   	

}
