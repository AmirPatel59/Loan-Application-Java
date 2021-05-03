package com.cg.loan.dto;

public class LoanApplication {
	private int loanId;
	private double amount;
	private int loanTypeId;
	private double emi;
	private int loanRepayPeriod;
	private double monthlyIncome;

	private enum loanStatus {
		PENDING, NOTAPPROVED, APPROVED, CLOSED;
	}

	private Customer customer;

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getLoanTypeId() {
		return loanTypeId;
	}

	public void setLoanTypeId(int loanTypeId) {
		this.loanTypeId = loanTypeId;
	}

	public double getEmi() {
		return emi;
	}

	public void setEmi(double emi) {
		this.emi = emi;
	}

	public int getLoanRepayPeriod() {
		return loanRepayPeriod;
	}

	public void setLoanRepayPeriod(int loanRepayPeriod) {
		this.loanRepayPeriod = loanRepayPeriod;
	}

	public double getMonthlyIncome() {
		return monthlyIncome;
	}

	public void setMonthlyIncome(double monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public LoanApplication(int loanId, double amount, int loanTypeId, double emi, int loanRepayPeriod,
			double monthlyIncome, Customer customer) {
		super();
		this.loanId = loanId;
		this.amount = amount;
		this.loanTypeId = loanTypeId;
		this.emi = emi;
		this.loanRepayPeriod = loanRepayPeriod;
		this.monthlyIncome = monthlyIncome;
		this.customer = customer;
	}

	public LoanApplication(double amount, int loanTypeId, double emi, int loanRepayPeriod, double monthlyIncome,
			Customer customer) {
		super();
		this.amount = amount;
		this.loanTypeId = loanTypeId;
		this.emi = emi;
		this.loanRepayPeriod = loanRepayPeriod;
		this.monthlyIncome = monthlyIncome;
		this.customer = customer;
	}

	public LoanApplication() {
		super();

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		temp = Double.doubleToLongBits(emi);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + loanId;
		result = prime * result + loanRepayPeriod;
		result = prime * result + loanTypeId;
		temp = Double.doubleToLongBits(monthlyIncome);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoanApplication other = (LoanApplication) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (Double.doubleToLongBits(emi) != Double.doubleToLongBits(other.emi))
			return false;
		if (loanId != other.loanId)
			return false;
		if (loanRepayPeriod != other.loanRepayPeriod)
			return false;
		if (loanTypeId != other.loanTypeId)
			return false;
		if (Double.doubleToLongBits(monthlyIncome) != Double.doubleToLongBits(other.monthlyIncome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LoanApplication [loanId=" + loanId + ", amount=" + amount + ", loanTypeId=" + loanTypeId + ", emi="
				+ emi + ", loanRepayPeriod=" + loanRepayPeriod + ", monthlyIncome=" + monthlyIncome + ", customer="
				+ customer + "]";
	}

}
