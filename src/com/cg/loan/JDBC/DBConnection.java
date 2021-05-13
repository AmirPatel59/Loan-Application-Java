package com.cg.loan.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private final String url = "jdbc:postgresql://localhost/Loan";
	private final String user = "postgres";
	private final String password = "postgree";

	public Connection connect() {
		Connection connection=null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			if (connection != null) {
				System.out.println("Connection successful with postgresql Database...");
			} else {
				System.out.println("Connection failed...");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

}
