package com.cg.loan.dto;

public class LoanType {

	private int loanTypeId;
	private String loanName;
	private float rateOfInterest;

	public int getLoanTypeId() {
		return loanTypeId;
	}

	public void setLoanTypeId(int loanTypeId) {
		this.loanTypeId = loanTypeId;
	}

	public String getLoanName() {
		return loanName;
	}

	public void setLoanName(String loanName) {
		this.loanName = loanName;
	}

	public float getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(float rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public LoanType(int loanTypeId, String loanName, float rateOfInterest) {
		super();
		this.loanTypeId = loanTypeId;
		this.loanName = loanName;
		this.rateOfInterest = rateOfInterest;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((loanName == null) ? 0 : loanName.hashCode());
		result = prime * result + loanTypeId;
		result = prime * result + Float.floatToIntBits(rateOfInterest);
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
		LoanType other = (LoanType) obj;
		if (loanName == null) {
			if (other.loanName != null)
				return false;
		} else if (!loanName.equals(other.loanName))
			return false;
		if (loanTypeId != other.loanTypeId)
			return false;
		if (Float.floatToIntBits(rateOfInterest) != Float.floatToIntBits(other.rateOfInterest))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LoanType [loanTypeId=" + loanTypeId + ", loanName=" + loanName + ", rateOfInterest=" + rateOfInterest
				+ "]";
	}

}
