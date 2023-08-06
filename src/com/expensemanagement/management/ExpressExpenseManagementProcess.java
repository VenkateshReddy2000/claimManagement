package com.expensemanagement.management;



import com.expensemanagement.domain.Employee;
import com.expensemanagement.domain.ExpenseClaim;

public class ExpressExpenseManagementProcess implements ExpenseManagementProcess {
	
	private ExpenseClaim claim;

	@Override
	public int registerExpenseClaim(ExpenseClaim claim) {
		this.claim = claim;
		return -1;
	}

	@Override
	public boolean approveClaim(int id, Employee employee) {
	
		return (claim.getTotalAmount() < 50);
	}

}
