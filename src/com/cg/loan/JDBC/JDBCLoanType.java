package com.cg.loan.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cg.loan.dto.LoanType;

public class JDBCLoanType {
	DBConnection con=new DBConnection();
	Connection connection=con.connect();

	public LoanType getLoanType(String type) {

		LoanType ltype = new LoanType();
		try {

			Statement statement = connection.createStatement();
			String query = "SELECT loan_type_id, loan_name, roi\r\n" + "	FROM public.loan_type where loan_name='"
					+ type + "'";
			ResultSet result = statement.executeQuery(query);
			while (result.next()) {
				ltype.setLoanTypeId(result.getInt(1));
				ltype.setLoanName(result.getString(2));
				ltype.setRateOfInterest(result.getDouble(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ltype;
	}

	public LoanType getLoanTypeId(int int1) {
		LoanType ltype = new LoanType();
		try {

			Statement statement = connection.createStatement();
			String query = "SELECT loan_type_id, loan_name, roi\r\n" + "	FROM public.loan_type where loan_type_id='"
					+ int1 + "'";
			ResultSet result = statement.executeQuery(query);
			while (result.next()) {
				ltype.setLoanTypeId(result.getInt(1));
				ltype.setLoanName(result.getString(2));
				ltype.setRateOfInterest(result.getDouble(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ltype;
	}
}
