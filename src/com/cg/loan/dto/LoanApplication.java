package com.cg.loan.dto;

public class LoanApplication {
	private int loanId;
	private double amount;
	private int loanTypeId;
	private double emi;
	private double loanRepayPeriod;
	private double monthlyIncome;
	private double rateOfInterest;
	private String loanStatus;
	private int customerId;
	
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
	public double getLoanRepayPeriod() {
		return loanRepayPeriod;
	}
	public void setLoanRepayPeriod(double loanRepayPeriod) {
		this.loanRepayPeriod = loanRepayPeriod;
	}
	public double getMonthlyIncome() {
		return monthlyIncome;
	}
	public void setMonthlyIncome(double monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}
	public double getRateOfInterest() {
		return rateOfInterest;
	}
	public void setRateOfInterest(double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}
	public String getLoanStatus() {
		return loanStatus;
	}
	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public LoanApplication() {
		super();
		
	}
	
	public LoanApplication(double amount, int loanTypeId, double emi, double loanRepayPeriod, double monthlyIncome,
			double rateOfInterest, String loanStatus, int customerId) {
		super();
		this.amount = amount;
		this.loanTypeId = loanTypeId;
		this.emi = emi;
		this.loanRepayPeriod = loanRepayPeriod;
		this.monthlyIncome = monthlyIncome;
		this.rateOfInterest = rateOfInterest;
		this.loanStatus = loanStatus;
		this.customerId = customerId;
	}
	
	public LoanApplication(int loanId, double amount, int loanTypeId, double emi, double loanRepayPeriod,
			double monthlyIncome, double rateOfInterest, String loanStatus, int customerId) {
		super();
		this.loanId = loanId;
		this.amount = amount;
		this.loanTypeId = loanTypeId;
		this.emi = emi;
		this.loanRepayPeriod = loanRepayPeriod;
		this.monthlyIncome = monthlyIncome;
		this.rateOfInterest = rateOfInterest;
		this.loanStatus = loanStatus;
		this.customerId = customerId;
	}
	public LoanApplication(int loanId, double amount, String loanStatus) {
		super();
		this.loanId = loanId;
		this.amount = amount;
		this.loanStatus = loanStatus;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + customerId;
		temp = Double.doubleToLongBits(emi);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + loanId;
		temp = Double.doubleToLongBits(loanRepayPeriod);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((loanStatus == null) ? 0 : loanStatus.hashCode());
		result = prime * result + loanTypeId;
		temp = Double.doubleToLongBits(monthlyIncome);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(rateOfInterest);
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
		if (customerId != other.customerId)
			return false;
		if (Double.doubleToLongBits(emi) != Double.doubleToLongBits(other.emi))
			return false;
		if (loanId != other.loanId)
			return false;
		if (Double.doubleToLongBits(loanRepayPeriod) != Double.doubleToLongBits(other.loanRepayPeriod))
			return false;
		if (loanStatus == null) {
			if (other.loanStatus != null)
				return false;
		} else if (!loanStatus.equals(other.loanStatus))
			return false;
		if (loanTypeId != other.loanTypeId)
			return false;
		if (Double.doubleToLongBits(monthlyIncome) != Double.doubleToLongBits(other.monthlyIncome))
			return false;
		if (Double.doubleToLongBits(rateOfInterest) != Double.doubleToLongBits(other.rateOfInterest))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "LoanApplication [loanId=" + loanId + ", amount=" + amount + ", loanTypeId=" + loanTypeId + ", emi="
				+ emi + ", loanRepayPeriod=" + loanRepayPeriod + ", monthlyIncome=" + monthlyIncome
				+ ", rateOfInterest=" + rateOfInterest + ", loanStatus=" + loanStatus + ", customerId=" + customerId
				+ "]";
	}
	
	
	
	
	
	
	}
