package com.cg.loan.service;

import java.util.List;
import java.util.Scanner;

import com.cg.loan.JDBC.JDBCLoanApplication;
import com.cg.loan.JDBC.JDBCLoanType;
import com.cg.loan.dto.LoanApplication;
import com.cg.loan.dto.LoanType;


public class LoanApplicationService {
	Scanner sc = new Scanner(System.in);
	JDBCLoanApplication dbconnect=new JDBCLoanApplication();
	public double calculateEMI(double amount, double time, double rate) {
		rate = rate /(12*100);
		time = time * 12;
		double emi = (amount * rate * Math.pow(1 + rate, time)) / (Math.pow(1 + rate, time) - 1);
		return Math.ceil(emi);
	}

	public LoanApplication applyLoan(int cid) {
		LoanApplication loan = new LoanApplication();
		LoanType loanType=new LoanType();
		loan.setCustomerId(cid);
		System.out.println("1.Home Loan  2.Gold Loan  3.Personal Loan  4.Vehicle Loan");
		
		int loantypeid=1;
	    while(loantypeid<5) {
	    	System.out.println("Enter the Id of loan:");
	    	loantypeid=sc.nextInt();
		if (loantypeid == 1) {
			JDBCLoanType jd=new JDBCLoanType();
			loanType=jd.getLoanType("Home-Loan");
			loan.setLoanTypeId(1);
			break;
		} else if (loantypeid == 2) {	
			JDBCLoanType jd=new JDBCLoanType();
			loanType=jd.getLoanType("Gold-Loan");
			loan.setLoanTypeId(2);
			break;
		} else if(loantypeid == 3){
			JDBCLoanType jd=new JDBCLoanType();
			loanType=jd.getLoanType("Personal-Loan");
			loan.setLoanTypeId(3);
			break;
		}
		else if(loantypeid == 4) {
			JDBCLoanType jd=new JDBCLoanType();
		    loanType=jd.getLoanType("Vehicle-Loan");
			loan.setLoanTypeId(4);
			break;
		}
		else {
			System.out.println("You Entered wrong Number");
		}
	}
		System.out.println("Enter Loan Amount:");
		loan.setAmount(sc.nextDouble());
		System.out.println("Enter Loan Repay Period in years:");
		loan.setLoanRepayPeriod(sc.nextDouble());
		System.out.println("Enter Monthly Income:");
		loan.setMonthlyIncome(sc.nextDouble());
		loan.setEmi(calculateEMI(loan.getAmount(),loan.getLoanRepayPeriod(),loanType.getRateOfInterest()));
		loan.setLoanStatus("NOT APPROVED");
	//	loan.setCustomerId(cid);
		dbconnect.applyLoan(loan.getAmount(), loan.getLoanTypeId(), loan.getEmi(),loan.getLoanRepayPeriod(), loan.getMonthlyIncome(), loan.getLoanStatus(),loan.getCustomerId());
		return loan;
	}
	
	
	
	public List<LoanApplication> viewAllLoansByCustomerId(int customerId){
		List<LoanApplication> cusLoans=dbconnect.viewCustomerById(customerId);
		return cusLoans;
		
	}
	public List<LoanApplication> viewAllLoans(){
		List<LoanApplication> cusLoans=dbconnect.viewAllLoans();
		return cusLoans;
		
	}
	
	public LoanApplication viewLoanApplicationById(int loanId) {
		LoanApplication loan=dbconnect.viewLoanApplicationById(loanId);
		return loan;
		
	}
	
	public LoanApplication closeLoan(int loanId) {
		LoanApplication loan=viewLoanApplicationById(loanId);
		System.out.println(loan.getAmount());
		
		if(loan!=null) {
			System.out.println("Loan Amount is : "+loan.getAmount());
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
					dbconnect.closeLoan(loanId,loan.getLoanStatus());
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
