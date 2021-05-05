package com.cg.loan;

import java.util.Scanner;

import com.cg.loan.dto.LoanIssuer;
import com.cg.loan.service.LoanIssuerService;



public class Main {
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
	
		System.out.println("welcome to C-Evils Bank");
	
		System.out.println("Enter Email Id:");
		String email=sc.next();
		System.out.println("Enter Password:");
		String password = sc.next();
		
		LoanIssuerService LIService = new LoanIssuerService();
		LIService.login(email, password);
		
	}
}
