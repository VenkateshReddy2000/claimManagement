package com.expensemanagement;


import java.time.LocalDate;

import com.expensemanagement.domain.Department;
import com.expensemanagement.domain.Employee;
import com.expensemanagement.domain.Employees;
import com.expensemanagement.domain.ExpenseClaim;
import com.expensemanagement.domain.ExpenseItem;
import com.expensemanagement.domain.ExpenseType;


public class Main {

	public static void main(String[] args) {
		
		Employee employee1 = new Employee();
		employee1.setId(1);
		employee1.setTitle("Mr");
		employee1.setFirstName("MAYA");
		employee1.setSurName("sai");
		
		System.out.println(employee1.getMailingName());
		System.out.println(employee1.getMailingName(true));
		System.out.println(employee1.getMailingName(false));
		
		Employee employee2= new Employee(2,"Manager");
		employee2.setTitle("Dr");
		employee2.setFirstName("Denis");
		employee2.setSurName("felicon");
		
		Employees employees = new Employees();
		employees.addEmployee(employee1);
		employees.addEmployee(employee2);
		employees.addEmployee(new Employee(3,"Mrs","Susan","Brown","Director",Department.PRODCTION));
		
		employees.printEmployees();
		
		Employee foundEmployee = employees.findBySurname("Brown");
		System.out.println("Found " + foundEmployee.getMailingName());
		
		Employee foundEmployee1 = employees.findBySurname("mani");
		System.out.println(" didn't Found " + (foundEmployee1 == null));
		
		
		ExpenseClaim expenseClaim = new ExpenseClaim(24,642,LocalDate.now());
		System.out.println(expenseClaim.getEmployeeId());
		expenseClaim.setPaid(true);
		System.out.println(expenseClaim.getPaid());
		expenseClaim.setApproved(true);
		expenseClaim.setPaid(true);
		System.out.println(expenseClaim.getPaid());
		
		ExpenseItem expenseItem = new ExpenseItem(24,102,ExpenseType.ACCOMODATION,"The Grand hotel",69.99);
        System.out.println(expenseItem.getDescription());
	
	   System.out.println(employee1);
	   
	   String name1="Matt";
	   String name2 = "Matt";
	   
	   Employee employee3 = new Employee();
		employee3.setId(1);
		employee3.setTitle("Mr");
		employee3.setFirstName("MAYA");
		employee3.setSurName("sai");
	   
		System.out.println(employee1.equals(employee3));
		System.out.println(employee1 == employee1);
		System.out.println(employee1.getClass());
	}

}
