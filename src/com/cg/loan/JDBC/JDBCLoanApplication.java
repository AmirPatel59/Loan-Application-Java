package com.cg.loan.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.cg.loan.dto.LoanApplication;
import com.cg.loan.dto.LoanType;

public class JDBCLoanApplication {

	DBConnection con=new DBConnection();
	Connection connection=con.connect();

	public void applyLoan(double amount, int loan_type_id, double emi, double period, double income, String loan_status,
			int customerid) {

		try {
			
			String query = "insert into loans(amount,loan_type_id,emi,period,income,loan_status,customerid) values('"
					+ amount + "','" + loan_type_id + "','" + emi + "','" + period + "','" + income + "','"
					+ loan_status + "','" + customerid + "')";
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public List<LoanApplication> viewCustomerById(int customerId) {
		List<LoanApplication> loanList = new ArrayList<>();
		LoanApplication loan = new LoanApplication();
		try {

			
			String query = "SELECT loanid, amount, loan_type_id,  period, emi, income, loan_status FROM public.loans where customerid = "
					+ customerId;

			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);

			while (result.next()) {

				System.out.println("Loan ID: " + result.getInt(1));
				System.out.println("Loan Amount: " + result.getDouble(2));
				JDBCLoanType jdbc = new JDBCLoanType();
				LoanType ltype = jdbc.getLoanTypeId(result.getInt(3));
				System.out.println("Loan Type: " + ltype.getLoanName());
				System.out.println("Rate of Interest: " + ltype.getRateOfInterest());
				System.out.println("Loan Repay Period: " + result.getDouble(4));
				System.out.println("Emi to be Paid: " + result.getDouble(5));
				System.out.println("Monthly Income: " + result.getDouble(6));
				System.out.println("Loan Status: " + result.getString(7));
				System.out.println("");

			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return null;
	}

	public LoanApplication viewLoanApplicationById(int loanId) {
		LoanApplication loan = new LoanApplication();
		try {

		
			String query = "SELECT loanid, amount, loan_type_id, period, emi, income, loan_status FROM public.loans where loanid = "
					+ loanId;

			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);

			while (result.next()) {
				System.out.println("Loan ID: " + result.getInt(1));
				System.out.println("Loan Amount: " + result.getDouble(2));
				JDBCLoanType jdbc = new JDBCLoanType();
				LoanType ltype = jdbc.getLoanTypeId(result.getInt(3));
				System.out.println("Loan Type: " + ltype.getLoanName());
				System.out.println("Rate of Interest: " + ltype.getRateOfInterest());
				System.out.println("Loan Repay Period: " + result.getDouble(4));
				System.out.println("Emi to be Paid: " + result.getDouble(5));
				System.out.println("Monthly Income: " + result.getDouble(6));
				System.out.println("Loan Status: " + result.getString(7));

				loan.setLoanId(result.getInt(1));
				loan.setAmount(result.getDouble(2));
				loan.setLoanTypeId(result.getInt(3));
				loan.setLoanRepayPeriod(result.getDouble(4));
				loan.setEmi(result.getDouble(5));
				loan.setMonthlyIncome(result.getDouble(6));
				loan.setLoanStatus(result.getString(7));

			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		if(loan.getLoanId()==0) {
			return null;
		}
//		if(loan==null) {
//			return null;
//		}
		return loan;
	}

	public void closeLoan(int loanId, String loanStatus) {

		try {

		
			String query = "UPDATE public.loans SET loan_status='" + loanStatus + "' WHERE loanid=" + loanId;

			Statement statement = connection.createStatement();
			statement.executeUpdate(query);

		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	public List<LoanApplication> viewAllLoans() {
		List<LoanApplication> loanList = new ArrayList<>();
		LoanApplication loan = new LoanApplication();
		try {

			
			String query = "SELECT loanid, amount, loan_type_id,  period, emi, income, loan_status, customerid FROM public.loans";

			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);

			while (result.next()) {

				System.out.println("Customer Id: " + result.getInt(8));
				System.out.println("Loan ID: " + result.getInt(1));
				System.out.println("Loan Amount: " + result.getDouble(2));
				JDBCLoanType jdbc = new JDBCLoanType();
				LoanType ltype = jdbc.getLoanTypeId(result.getInt(3));
				System.out.println("Loan Type: " + ltype.getLoanName());
				System.out.println("Rate of Interest: " + ltype.getRateOfInterest());
				System.out.println("Loan Repay Period: " + result.getDouble(4));
				System.out.println("Emi to be Paid: " + result.getDouble(5));
				System.out.println("Monthly Income: " + result.getDouble(6));
				System.out.println("Loan Status: " + result.getString(7));
				System.out.println("");

			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return null;
	}

	public void updateLoanStatus(int lid) {
		LoanApplication loan = new LoanApplication();
		try {


			String query = "UPDATE public.loans SET loan_status='Approved' WHERE loanid =" + lid;

			Statement statement = connection.createStatement();
			statement.executeUpdate(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void updateLoanStatusByIssuer(int lid, String status) {
		LoanApplication loan = new LoanApplication();
		try {


			String query = "UPDATE public.loans SET loan_status='"+status+"' WHERE loanId =" + lid;

			Statement statement = connection.createStatement();
			statement.executeUpdate(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}