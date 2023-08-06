package com.expensemanagement.utility;

import com.expensemanagement.domain.Employee;
import com.expensemanagement.domain.Employees;
import com.expensemanagement.exceptions.InvalidEmployeeIdException;
import com.expensemanagement.exceptions.NameTooShortException;

public class EmployeeUtilities {

	public boolean employeeExits(Employees employees, Employee employee ) {
		return employees.findBySurname(employee.getSurName()) !=null;
	}
		public Integer validateEmployeeId(String inputId) throws InvalidEmployeeIdException {
			try {
			Integer id = Integer.valueOf(inputId);
			return id;
		}
			catch (NumberFormatException e) {
			throw new InvalidEmployeeIdException();
		}
	
	}
		
		public void validateEmployeeName(String firstName,String surName) throws NameTooShortException{
			Integer length = firstName.length() + surName.length();
			if(length < 6) {
				throw new NameTooShortException();
			}
		}
}
