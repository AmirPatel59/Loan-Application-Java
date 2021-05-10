package com.cg.loan.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cg.loan.JDBC.JDBC_connectivity;
import com.cg.loan.dto.Customer;

public class CustomerService {
	List<Customer> list = new ArrayList<Customer>();
	Scanner sc = new Scanner(System.in);

	public Customer addCustomer() {
		System.out.println("Enter your Customer Id");
		int id = sc.nextInt();
		System.out.println("Enter  Customer First Name");
		String firstName = sc.next();
		System.out.println("Enter  Customer Last Name");
		String lastName = sc.next();
		System.out.println("Enter  Customer Password");
		String password = sc.next();
		System.out.println("Enter  Customer Email");
		String email = sc.next();
		System.out.println("Enter  Customer Gender");
		String gender = sc.next();
		System.out.println("Enter  Customer Age");
		int age = sc.nextInt();
		System.out.println("Enter  Customer Mobile Number");
		long mobileNumber = sc.nextLong();
		Customer customer = new Customer(id, firstName, lastName, password, email, gender, age, mobileNumber);
		JDBC_connectivity jdb = new JDBC_connectivity();
		jdb.addCustomer(id, firstName, lastName, email, password, age, gender, mobileNumber);
		return customer;
	}

	public Customer viewCustomerById(int id) {

		JDBC_connectivity jd = new JDBC_connectivity();
		Customer customer = jd.viewCustomerById(id);

		return customer;

	}

	public List<Customer> viewAllCustomer() {
		JDBC_connectivity jd = new JDBC_connectivity();
		List<Customer> list = jd.viewAllCustomer();
		return list;
	}

	public void deleteCustomerById(int id) {
		Customer customer = new Customer();
		JDBC_connectivity jd = new JDBC_connectivity();
		customer = viewCustomerById(id);
		if (customer == null) {
			System.out.println("Customer not found..");
		} else {

			jd.deleteCustomer(id);
			System.out.println("Customer deleted successfully...");
		}

	}

	public Customer updateCustomer(int id) {

		Customer customer = viewCustomerById(id);
		if (customer == null) {
			System.out.println("Customer is not present with id:" + id);
		} else {
			System.out.println("Enter  Customer First Name");
			String firstName = sc.next();
			System.out.println("Enter  Customer Last Name");
			String lastName = sc.next();
			System.out.println("Enter  Customer Password");
			String password = sc.next();
			System.out.println("Enter  Customer Email");
			String email = sc.next();
			System.out.println("Enter  Customer Gender");
			String gender = sc.next();
			System.out.println("Enter  Customer Age");
			int age = sc.nextInt();
			System.out.println("Enter  Customer Mobile Number");
			long mobileNumber = sc.nextLong();
			Customer customer1 = new Customer(id, firstName, lastName, password, email, gender, age, mobileNumber);
			JDBC_connectivity jd = new JDBC_connectivity();
			jd.updateCustomer(id, firstName, lastName, password, email, gender, age, mobileNumber);
			System.out.println("customer updated sucessfull!!! ");
		}
		return null;
	}

	public Customer login(String email, String password) {
		JDBC_connectivity jdbc = new JDBC_connectivity();
		Customer customer = jdbc.login(email, password);
		return customer;
	}
}
