package com.expensemanagement.ui;

import java.time.LocalDate;
import java.util.Scanner;

import com.expensemanagement.domain.Department;
import com.expensemanagement.domain.Employee;
import com.expensemanagement.domain.ExpenseClaim;
import com.expensemanagement.domain.ExpenseItem;
import com.expensemanagement.domain.ExpenseType;
import com.expensemanagement.domain.StaffEmployee;
import com.expensemanagement.exceptions.InvalidEmployeeIdException;
import com.expensemanagement.exceptions.NameTooShortException;
import com.expensemanagement.utility.EmployeeUtilities;

public class UIFunctions {

	public Employee registerNewEmployee() {

		Scanner scanner= new Scanner(System.in);
		Employee employee = new Employee();

		EmployeeUtilities employeeUtilities = new EmployeeUtilities();

		Boolean IdIsValid = false;
		while(!IdIsValid) {
			System.out.println("Enter the id");
			String inputId = scanner.nextLine();		
			try {
				Integer id = employeeUtilities.validateEmployeeId(inputId);
				employee.setId(id);
				IdIsValid = true;
			} catch (InvalidEmployeeIdException e) {
				System.out.println("The id you entered was Invalid - try Again");
			}
		}

		System.out.println("Enter the title");
		String title = scanner.nextLine();
		employee.setTitle(title);

		Boolean nameIsValid = false;
		while(!nameIsValid) {

			System.out.println("Enter the firstname");
			String firstname = scanner.nextLine();
			employee.setFirstName(firstname);

			System.out.println("Enter the surname");
			String surname = scanner.nextLine();
			employee.setSurName(surname);

			try {
				employeeUtilities.validateEmployeeName(firstname, surname);
				nameIsValid = true;
			} catch (NameTooShortException e) {
				System.out.println("The name you entered was not valid - try Again");
			}
		}


		System.out.println("Enter the job title");
		String jobTitle = scanner.nextLine();
		employee.setJobTitle(jobTitle);

		Boolean departmentIsValid = false;
		while(!departmentIsValid) {
			System.out.println("Enter the department");
			String department = scanner.nextLine();
			try {
				Department d = Department.valueOf(department.toUpperCase());
				employee.setDepartment(d);
				departmentIsValid = true;
			}catch(IllegalArgumentException e){
				System.out.println("The department yo entered was not valis -try again");
			}
		}
         
		System.out.println("is this a staff member Y/N");
		String isAStaffMember = scanner.nextLine();
		if(isAStaffMember.toUpperCase().equals("Y")) {
			StaffEmployee staff = new StaffEmployee(employee);
			
			System.out.println("Enter the username");
			String userName = scanner.nextLine();
			staff.setUsername(userName);
			
			System.out.println("Enter the password");
			String passWord = scanner.nextLine();
			staff.setPassword(passWord);
			
			return staff;
		}
		     else {
		return (employee);
		}

	}

 public ExpenseClaim registerNewExpenseClaim() {
	 Scanner scanner= new Scanner(System.in);
		EmployeeUtilities employeeUtilities = new EmployeeUtilities();
		
		System.out.println("Enter the claim id");
		int claimId = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Enter the employee id");
		int employeeId = scanner.nextInt();
		scanner.nextLine();
		
		LocalDate dateOfClaim = LocalDate.now();
		
		
		
		ExpenseClaim claim = new ExpenseClaim(claimId,employeeId,dateOfClaim);
		
		boolean finished= false;
		while(!finished) {
			System.out.println("Enter expense item id");
			int eiId = scanner.nextInt();
			scanner.nextLine();
			
			Boolean expenseIsValid = false;
			
			ExpenseType eiType = null;
			
			while(!expenseIsValid) {
				System.out.println("Enter the expense type ");
				String expenseType = scanner.nextLine();
				try {
					eiType = ExpenseType.valueOf(expenseType.toUpperCase());
					
					expenseIsValid = true;
				}catch(IllegalArgumentException e){
					System.out.println("The ExpenseType you entered was not valid -try again");
				}
			}
			System.out.println("Enter the description");
			String description= scanner.nextLine();
			
			System.out.println("Enter the Amount");
			double amount= scanner.nextDouble();
			scanner.nextLine();
			
			ExpenseItem ei = new ExpenseItem(eiId,claimId,eiType,description,amount);
			claim.addExpenseItem(ei);
			
			System.out.println("Enter another expense item? Y/N");
			String anyMore = scanner.nextLine();
			
			if(!anyMore.toUpperCase().equals("Y")) {
				finished=true;
			}
			
		}

        return claim;
 }

}
