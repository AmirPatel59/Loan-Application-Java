package com.cg.loan.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
		Customer customer=new Customer(id,firstName, lastName, password, email, gender, age, mobileNumber);
		list.add(customer);
		return customer;
	}

	public Customer viewCustomerById(int id) {
//		Customer customer = new Customer();
		
		for (int i = 0; i < list.size(); i++) {
			Customer customer1 = list.get(i);
//			System.out.println(customer1);
			if(customer1.getCustomerId() == id) {
//				customer = customer1;
				return customer1;
			} 
			
		}
		return null;
		
	}

	public List<Customer> viewAllCustomer() {
		return list;
	}
	public void deleteCustomerById(int id) {
		Customer customer=new Customer();
		customer=viewCustomerById(id);
		if(customer==null) {
			System.out.println("Customer is not there");
		}
		else {
			list.remove(customer);
			System.out.println("Deleted Succesfully");
		}
		
		
	}

	public Customer updateCustomer(int id) { 
		Customer customer = viewCustomerById(id);
		if(customer == null) {
			return null;
		}
		else {
			int index = list.indexOf(customer);
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
			Customer customer1=new Customer(id,firstName, lastName, password, email, gender, age, mobileNumber);
			list.set(index, customer1);
			return customer1;
		}
	}
}
