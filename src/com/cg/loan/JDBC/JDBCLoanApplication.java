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
import com.cg.loan.dto.LoanType;

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

	public void applyLoan(double amount, int loan_type_id, double emi, double period, double income, String loan_status,
			int customerid) {

		try {
			Connection connection = DriverManager.getConnection(url, user, password);
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

			Connection connection = DriverManager.getConnection(url, user, password);
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

			Connection connection = DriverManager.getConnection(url, user, password);
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
//		if(loan.getLoanId()!=0) {
//			return loan;
//		}
		return loan;
	}

	public void closeLoan(int loanId, String loanStatus) {

		try {

			Connection connection = DriverManager.getConnection(url, user, password);
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

			Connection connection = DriverManager.getConnection(url, user, password);
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

			Connection connection = DriverManager.getConnection(url, user, password);
			String query = "UPDATE public.loans SET loan_status='Approved' WHERE loanid =" + lid;

			Statement statement = connection.createStatement();
			statement.executeUpdate(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}