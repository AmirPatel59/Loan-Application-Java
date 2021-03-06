package com.cg.loan.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cg.loan.dto.Customer;

public class JDBC_connectivity {

//	private final String url = "jdbc:postgresql://localhost/Loan";
//	private final String user = "postgres";
//	private final String password = "postgree";
//
//	public void connect() {
//		try {
//			Connection connection = DriverManager.getConnection(url, user, password);
//			if (connection != null) {
//				System.out.println("Connection successful with postgresql Database...");
//			} else {
//				System.out.println("Connection failed...");
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
	DBConnection con=new DBConnection();
	
	Connection connection=con.connect();

	public void addCustomer( String firstname, String lastname, String email, String password1, int age,
			String gender, long mobileno) {
		try {
			
		
			String query = "INSERT INTO public.customer( first_name, last_name, email, password, age, gender, mobile_number) VALUES "
					+ "('" + firstname + "','" + lastname + "','" + email + "','" + password1 + "'," + age
					+ ",'" + gender + "'," + mobileno + ")";

			Statement statement = connection.createStatement();
			statement.executeUpdate(query);

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}
	
	public Customer viewCustomerById(int id) {
		Customer customer = new Customer();
		try {
			
			
			String query = "SELECT customer_id, first_name, last_name, email, password, age, gender, mobile_number\r\n"
					+ "	FROM public.customer where customer_id = "+id;

			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			
			while(result.next()) {
				customer.setFirstName(result.getString(2));
				customer.setLastName(result.getString(3));
				customer.setEmail(result.getString(4));
				customer.setPassword(result.getString(5));
				customer.setAge(result.getInt(6));
				customer.setGender(result.getString(7));
				customer.setMobileNumber(result.getLong(8));
				customer.setCustomerId(result.getInt(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		if(customer.getFirstName() != null) {
			return customer;
		}
		return null;
	}


	public List<Customer> viewAllCustomer() {
		List<Customer> list = new ArrayList<>();
		Customer customer  = new Customer();
		try {

			
			String query = "SELECT customer_id, first_name, last_name, email, password, age, gender, mobile_number FROM public.customer";

			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			

			while(result.next()) {
				System.out.println("Customer ID is:"+result.getInt(1));
				System.out.println("First name:"+result.getString(2));
				System.out.println("Last name:"+result.getString(3));
				System.out.println("email id :"+result.getString(4));
				System.out.println("Password :"+result.getString(5));
				System.out.println("Age :"+result.getInt(6));
				System.out.println("Gender :"+result.getString(7));
				System.out.println("Mobile No :"+result.getLong(8)); 
				System.out.println("");
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return null;
	}

	public void deleteCustomer(int id) {
		int cid=0;
		try {

			
			String query = "DELETE FROM public.customer\r\n"
					+ "	WHERE customer_id="+id;

			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateCustomer(int id, String firstName, String lastName, String password2, String email, String gender,
			int age, long mobileNumber) {
	
		try {

			Connection connection=con.connect();
			String query = "UPDATE public.customer SET customer_id="+id+", first_name='"+firstName+"', last_name='"+lastName+"', email='"+email+"', password='"+password2+"', gender='"+gender+"', age="+age+", mobile_number="+mobileNumber+" WHERE customer_id="+id;

			Statement statement = connection.createStatement();
			statement.executeUpdate(query);

		} catch (SQLException e) {
			e.printStackTrace();

		}
		
	}

	public Customer login(String email, String password2) {
		Customer customer = new Customer();
		try {

	
			String query = "SELECT customer_id, first_name, last_name, email, password, age, gender, mobile_number\r\n"
					 +"	FROM public.customer where email='"+email+"' and password = '"+password2+"'";

			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			while(result.next()) {
				customer.setCustomerId(result.getInt(1));
				customer.setFirstName(result.getString(2));
				customer.setLastName(result.getString(3));
				customer.setEmail(result.getString(4));
				customer.setPassword(result.getString(5));
				customer.setAge(result.getInt(6));
				customer.setGender(result.getString(7));
				customer.setMobileNumber(result.getLong(8));
				
			}
			

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return customer;
	}

}
