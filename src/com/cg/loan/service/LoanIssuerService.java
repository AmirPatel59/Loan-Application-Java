package com.cg.loan.service;

public class LoanIssuerService {
	
	final String email ="aniketamage@gmail.com";
	final String password ="Aniket@1900";
	
	public void login(String cemail, String cpassword) {
		if(cemail.equals(email) && cpassword.equals(password)) {
			System.out.println("Login Successful..");
		}
		else {
			System.out.println("Invalid Credintial...");
		}
	}

}
