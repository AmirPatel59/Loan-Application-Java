package com.cg.loan.dto;

public class LoanIssuer {
	private String email;
	private String password;
	private LoanApplication loanApplication;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LoanApplication getLoanApplication() {
		return loanApplication;
	}

	public void setLoanApplication(LoanApplication loanApplication) {
		this.loanApplication = loanApplication;
	}

	public LoanIssuer(String email, String password, LoanApplication loanApplication) {
		super();
		this.email = email;
		this.password = password;
		this.loanApplication = loanApplication;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((loanApplication == null) ? 0 : loanApplication.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		LoanIssuer other = (LoanIssuer) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (loanApplication == null) {
			if (other.loanApplication != null)
				return false;
		} else if (!loanApplication.equals(other.loanApplication))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LoanIssuer [email=" + email + ", password=" + password + ", loanApplication=" + loanApplication + "]";
	}

}
