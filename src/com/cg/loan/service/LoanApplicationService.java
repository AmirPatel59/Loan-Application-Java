package com.cg.loan.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cg.loan.dto.LoanApplication;


public class LoanApplicationService {
	Scanner sc = new Scanner(System.in);
	List<LoanApplication> loanList = new ArrayList<>();


	public double calculateEMI(double amount, double time, double rate) {
		rate = rate /(12*100);
		time = time * 12;
		double emi = (amount * rate * Math.pow(1 + rate, time)) / (Math.pow(1 + rate, time) - 1);
		return Math.ceil(emi);
	}

	public LoanApplication applyLoan() {
		LoanApplication loan = new LoanApplication();
		System.out.println("Enter Customer ID:");
		loan.setCustomerId(sc.nextInt());
		System.out.println("1.House Loan  2.Gold Loan  3.Personal Loan");
		System.out.println("Enter the Id of loan:");
		loan.setLoanTypeId(sc.nextInt());
		System.out.println("Enter Loan Amount:");
		loan.setAmount(sc.nextDouble());
		System.out.println("Enter Loan Repay Period in years:");
		loan.setLoanRepayPeriod(sc.nextDouble());
		
		if (loan.getLoanTypeId() == 1) {
			loan.setRateOfInterest(8);
		} else if (loan.getLoanTypeId() == 2) {
			loan.setRateOfInterest(7);
		} else {
			loan.setRateOfInterest(5);
		}
		
		System.out.println("Enter Monthly Income:");
		loan.setMonthlyIncome(sc.nextDouble());
		loan.setEmi(calculateEMI(loan.getAmount(),loan.getLoanRepayPeriod(),loan.getRateOfInterest()));
		loan.setLoanId(loanList.size());
		loan.setLoanStatus("NOT APPROVED");
		loanList.add(loan);
		return loan;
	}
	
	public List<LoanApplication> viewAllLoansByCustomerId(int customerId){
		List<LoanApplication> cusLoans=new ArrayList<>();
		for(int i=0;i<loanList.size();i++) {
			if(loanList.get(i).getCustomerId()==customerId) {
				 cusLoans.add(loanList.get(i));
			}
			else {
				return null;
			}
		}
		
		return cusLoans;
		
	}
	
	public LoanApplication viewLoanApplicationById(int loanId) {
		LoanApplication loan=new LoanApplication();
		for(int i=0;i<loanList.size();i++) {
			LoanApplication loan1=loanList.get(i);
			if(loan1.getLoanId()==loanId) {
				loan=loan1;
			}
			else {
				return null;
			}
		}
		return loan;
	}
	
	public LoanApplication closeLoan(int loanId) {
		LoanApplication loan=(LoanApplication) viewLoanApplicationById(loanId);
		if(loan!=null) {
			System.out.println("Loan Amout is : "+loan.getAmount());
			System.out.println("Pay loan amount to close loan");
			System.out.println("1.Close Loan");
			System.out.println("2.Exit");
			System.out.println("Enter your Choice:");
			int choice=sc.nextInt();
			if(choice==1) {
				System.out.println("Enter the amount :");
				double amount=sc.nextDouble();
				if(loan.getAmount()==amount) {
					loan.setLoanStatus("CLOSED");
				}
				else {
					System.out.println("Enter the correct amount to close the loan");
					
				}
			}
			else if(choice==2) {
				System.exit(0);
			}
		}
		return loan;
		
	}
}


