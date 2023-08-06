package com.expensemanagement.ui;

import java.time.LocalDate;

public interface ExpenseAnalysis {

	public void printOutstandingClaims();
	public void printPaidClaims(LocalDate from,LocalDate to);
	public void printClaimsOverAmount(Double amount);
	
}
