package com.expensemanagement.management;

import com.expensemanagement.domain.Employee;
import com.expensemanagement.domain.ExpenseClaim;

public interface ExpenseManagementProcess {

	public int registerExpenseClaim(ExpenseClaim claim);
	public boolean approveClaim(int id,Employee employee);
}
