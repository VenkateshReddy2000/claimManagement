package com.expensemanagement.management;

import java.util.ArrayList;
import java.util.List;

import com.expensemanagement.domain.Employee;
import com.expensemanagement.domain.ExpenseClaim;
import com.expensemanagement.domain.StaffEmployee;

public class RegularExpenseManagementProcess implements ExpenseManagementProcess {
	
	List<ExpenseClaim> claims = new ArrayList<>();
	
	

	@Override
	public int registerExpenseClaim(ExpenseClaim claim) {
		claims.add(claim);
		return claims.size() -1;
	}

	@Override
	public boolean approveClaim(int id, Employee employee) {
		ExpenseClaim claim  = claims.get(id);
		if(claim.getTotalAmount() < 100) {
			return true;
		}
		if (employee instanceof StaffEmployee) {
			return true;
		}
		return false;
	}

}
