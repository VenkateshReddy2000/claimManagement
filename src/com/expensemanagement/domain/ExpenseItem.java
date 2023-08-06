package com.expensemanagement.domain;

import java.util.Objects;

public class ExpenseItem {

	private Integer id;
	private Integer claimid;
	private ExpenseType expenseType;
	private String description;
	private Double amount;
	
	public ExpenseItem(Integer id, Integer claimid, ExpenseType expenseType, String description, Double amount) {
		super();
		this.id = id;
		this.claimid = claimid;
		this.expenseType = expenseType;
		this.description = description;
		this.amount = amount;
	}

	public Integer getId() {
		return id;
	}

	public Integer getClaimid() {
		return claimid;
	}

	public ExpenseType getExpenseType() {
		return expenseType;
	}

	public String getDescription() {
		return description;
	}

	public Double getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return "ExpenseItem [id=" + id + ", claimid=" + claimid + ", expenseType=" + expenseType + ", description="
				+ description + ", amount=" + amount + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, claimid, description, expenseType, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExpenseItem other = (ExpenseItem) obj;
		return Objects.equals(amount, other.amount) && Objects.equals(claimid, other.claimid)
				&& Objects.equals(description, other.description) && Objects.equals(expenseType, other.expenseType)
				&& Objects.equals(id, other.id);
	}
	
	
}
