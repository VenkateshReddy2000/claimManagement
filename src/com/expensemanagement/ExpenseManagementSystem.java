package com.expensemanagement;

import java.time.LocalDate;
import java.util.Scanner;

import com.expensemanagement.domain.Employee;
import com.expensemanagement.domain.Employees;
import com.expensemanagement.domain.ExpenseClaim;
import com.expensemanagement.exceptions.EmployeeNotFoundException;
import com.expensemanagement.management.ExpenseManagementProcess;
import com.expensemanagement.management.RegularExpenseManagementProcess;
import com.expensemanagement.management.ExpressExpenseManagementProcess;
import com.expensemanagement.ui.ExpenseAnalysis;
import com.expensemanagement.ui.ExpenseAnalysisTempImpl;
import com.expensemanagement.ui.UIFunctions;

public class ExpenseManagementSystem {

	public static void main(String[] args) {
      
		Employees employees = new Employees();
		Scanner scanner = new Scanner(System.in);
		UIFunctions uiFunctions = new UIFunctions();
		
		RegularExpenseManagementProcess expressEMP = new RegularExpenseManagementProcess();
		ExpressExpenseManagementProcess regularEMP = new ExpressExpenseManagementProcess();
		
		boolean readyToExit = false;
		
		while(!readyToExit) {
		System.out.println("Expense Management System");
		System.out.println("-------------------------");
		System.out.println("e-register new employee");
		System.out.println("c-register new claim");
		System.out.println("p-print all employees");
		System.out.println("a-approved claim");
		System.out.println("r1-outstanding expense claims");
		System.out.println("r2-paid expense claims");
		System.out.println("r3-expense claims above specified amount");
		System.out.println("x-exit");
		
		String option=scanner.nextLine();
		
		ExpenseAnalysis expenseAnalysis = new ExpenseAnalysisTempImpl();
		
		
		
		switch(option) {
		case "e": 
			Employee e = uiFunctions.registerNewEmployee();
			employees.addEmployee(e);
			break;
		case "c":
			ExpenseClaim claim = uiFunctions.registerNewExpenseClaim();
			try {
				employees.addExpenseClaim(claim);
				expressEMP.registerExpenseClaim(claim);
				int id = regularEMP.registerExpenseClaim(claim);
				System.out.println("The claim has been registered with ID" + id );
			} catch (EmployeeNotFoundException employeeNotFoundExpection) {
				System.out.println("There was no employee with ID " + claim.getEmployeeId());
			}
			break;
		case "p":
			 employees.printEmployees();
			break;
		case "x":
			 readyToExit =true;
			 break;
			 
		case "a":
			System.out.println("Enter the claim id");
			int claimId = scanner.nextInt();
			scanner.nextLine();
			
			System.out.println("Enter the employee id");
			int employeeId = scanner.nextInt();
			scanner.nextLine();
			
			Employee foundEmployee = employees.findById(employeeId);
			
			System.out.println("Enter r for regular , or e for express");
			String claimType = scanner.nextLine();
			
		
			
			if(claimType.equals("r")) {
				Boolean result = regularEMP.approveClaim(claimId, foundEmployee);
				 System.out.println("The result was  " + result);
			}
			else {
				Boolean result = expressEMP.approveClaim(claimId, foundEmployee);
			 System.out.println("The result was  " + result);
			}
			break;	
		case "r1":
			expenseAnalysis.printOutstandingClaims();
			break;
		case "r2":
			System.out.println("Enter date from");
			String dateFrom = scanner.nextLine();
			
			System.out.println("Enter date to");
			String dateTo = scanner.nextLine();
			
			expenseAnalysis.printPaidClaims(LocalDate.parse(dateFrom),LocalDate.parse(dateTo));
			break;
		case "r3":
			System.out.println("Enter the amount");
			double amount= scanner.nextDouble();
			expenseAnalysis.printClaimsOverAmount(amount);
			break;
		default:
			System.out.println("Option not valid");
		}
		}
	}

}
