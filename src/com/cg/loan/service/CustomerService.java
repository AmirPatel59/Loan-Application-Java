package com.cg.loan.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import com.cg.loan.dto.Customer;

public class CustomerService {

	List<Customer> list = new ArrayList<Customer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 0;
		do {

			System.out.println("--------------------MENU----------------------------");
			System.out.println("1.ADD Customer");
			System.out.println("2.View Customer");
			System.out.println("3.View All Customer");
			System.out.println("4.View Customer By Id");
			System.out.println("5.Exit");
			System.out.println("Enter Your Choice :");
			n = sc.nextInt();
			if (n == 1) {
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
				Customer Cust=new Customer(firstName, lastName, password, email, gender, age, mobileNumber);
				CustomerService customerservice=new CustomerService();
				customerservice.list.add(Cust);
				System.out.println("Customer Added Sucessfully with Id :"+id);
			}
			if(n==3) {
				CustomerService customerservice=new CustomerService();
				Stream<Customer> stream=customerservice.list.stream();
				stream.forEach(customer->System.out.println(customer));
			}
		} while (n < 5);
	}
}
