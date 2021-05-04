package com.cg.loan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import com.cg.loan.dto.Customer;
import com.cg.loan.service.CustomerService;

public class CustomerMain {


	public static void main(String[] args) {
		CustomerService customerservice=new CustomerService();
		Scanner sc = new Scanner(System.in);
		int n = 0;
		do {
			System.out.println("--------------------MENU----------------------------");
			System.out.println("1.ADD Customer");
			System.out.println("2.View Customer By Id");
			System.out.println("3.View All Customer");
			System.out.println("4.Delete Customer By Id");
			System.out.println("5.Update Customer By Id");
			System.out.println("6.Exit");
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
				Customer Cust=new Customer(id,firstName, lastName, password, email, gender, age, mobileNumber);
				customerservice.addCustomer(Cust);			
				System.out.println("Customer Added Sucessfully with Id :"+id);
			}
			if(n==2) {
				System.out.println("Enter Your Customer Id : ");
				int id=sc.nextInt();
				
				
				System.out.println("Customer Details Are");
				System.out.println(customerservice.viewCustomerById(id));
				
			}
			if(n==3) {
				System.out.println("Customers Are:");
				System.out.println(customerservice.viewAllCustomer());
			}
			if(n==4) {
				System.out.println("Enter Your Customer Id : ");
				int id=sc.nextInt();
				customerservice.deleteCustomerById(id);
			}
		} while (n < 5);
	}
}
