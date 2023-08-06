package com.expensemanagement.management;

import java.time.LocalDate;

import com.expensemanagement.domain.Employees;
import com.expensemanagement.ui.ExpenseAnalysis;

public class ExpenseAnalysisImpl implements ExpenseAnalysis {

	private Employees employees;

	public ExpenseAnalysisImpl(Employees employee) {
		this.employees = employee;
	}




	@Override
	public void printOutstandingClaims() {
		employees.getEmployeeList().stream().forEach(
				employee -> {
					employee.getClaims().values().stream()
					.filter(claim->!claim.getApproved())
					.forEach(claim->System.out.println(claim));
				}
		);

	}

	@Override
	public void printPaidClaims(LocalDate from, LocalDate to) {
		employees.getEmployeeList().stream().forEach(
				employee -> {
					employee.getClaims().values().stream()
					.filter(claim -> claim.getPaid())
					.filter(claim ->claim.getDataOfClaim().isAfter(from) && claim.getDataOfClaim().isBefore(to))
					.forEach(claim->System.out.println(claim));
				}
		);

	}

	@Override
	public void printClaimsOverAmount(Double amount) {
		employees.getEmployeeList().stream().forEach(
				employee -> {
					employee.getClaims().values().stream()
					.filter(claim-> claim.getTotalAmount() >=amount)
					.forEach(claim->System.out.println(claim));
				}
		);

	}

}
