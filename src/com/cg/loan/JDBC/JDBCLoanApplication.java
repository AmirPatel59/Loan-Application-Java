package com.cg.loan.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.cg.loan.dto.Customer;
import com.cg.loan.dto.LoanApplication;

public class JDBCLoanApplication {

	private final String url = "jdbc:postgresql://localhost/Loan";
	private final String user = "postgres";
	private final String password = "postgree";

	public void connect() {
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			if (connection != null) {
				System.out.println("Connection successful with postgresql Database...");
			} else {
				System.out.println("Connection failed...");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void applyLoan(double amount,int loan_type_id,double emi,double period, double income, double roi, String loan_status,int customerid) 
	{
		
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			String query = "insert into loans(amount,loan_type_id,emi,period,income,roi,loan_status,customerid) values('" + amount + "','"
					+ loan_type_id + "','" + emi + "','" + period + "','" + income + "','" + roi + "','"  +loan_status +"','"+customerid+"')";
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	
	
	public List<LoanApplication> viewCustomerById(int customerId) {
		List<LoanApplication> loanList=new ArrayList<>();
		LoanApplication loan=new LoanApplication();
		try {
			
			Connection connection = DriverManager.getConnection(url, user, password);
			String query = "SELECT customerid,loanid, amount, loan_type_id,  period, roi, emi, income, loan_status FROM public.loans where customerid = "+ customerId;

			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			
			while(result.next()) {
				System.out.println("Customer ID: "+result.getInt(1));
				System.out.println("Loan ID: "+result.getInt(2));
				System.out.println("Loan Amount: "+result.getDouble(3));
				System.out.println("Loan Type Id: "+result.getInt(4));
				System.out.println("Loan Repay Period: "+result.getDouble(5));
				System.out.println("Rate Of Interest: "+result.getDouble(6));
				System.out.println("Emi to be Paid: "+result.getDouble(7));
				System.out.println("Monthly Income: "+result.getDouble(8));
				System.out.println("Loan Status: "+result.getString(9));
				
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		
		return null;
	}


	public LoanApplication viewLoanApplicationById(int loanId) {
		LoanApplication loan=new LoanApplication();
		try {
			
			Connection connection = DriverManager.getConnection(url, user, password);
			String query = "SELECT customerid,loanid, amount, loan_type_id,  period, roi, emi, income, loan_status FROM public.loans where loanid = "+ loanId;

			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);

			
			while(result.next()) {
				System.out.println("Customer ID: "+result.getInt(1));
				System.out.println("Loan ID: "+result.getInt(2));
				System.out.println("Loan Amount: "+result.getDouble(3));
				System.out.println("Loan Type Id: "+result.getInt(4));
				System.out.println("Loan Repay Period in years: "+result.getDouble(5));
				System.out.println("Rate Of Interest: "+result.getDouble(6));
				System.out.println("Emi to be Paid: "+result.getDouble(7));
				System.out.println("Monthly Income: "+result.getDouble(8));
				System.out.println("Loan Status: "+result.getString(9));
				
				loan.setCustomerId(result.getInt(1));
				loan.setAmount(result.getDouble(3));
				loan.setLoanId(result.getInt(2));
				loan.setLoanTypeId(result.getInt(4));
				loan.setLoanRepayPeriod(result.getDouble(5));
				loan.setRateOfInterest(result.getDouble(6));
				loan.setEmi(result.getDouble(7));
				loan.setMonthlyIncome(result.getDouble(8));
				loan.setLoanStatus(result.getString(9));

			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
//		if(loan.getLoanId()!=0) {
//			return loan;
//		}
		return loan;
	}

	

	public void closeLoan(int loanId,String loanStatus) {
	
		try {

			Connection connection = DriverManager.getConnection(url, user, password);
			String query = "UPDATE public.loans SET loan_status='"+loanStatus+"' WHERE loanid="+loanId;

			Statement statement = connection.createStatement();
			statement.executeUpdate(query);

		} catch (SQLException e) {
			e.printStackTrace();

		}
		
	}

}
