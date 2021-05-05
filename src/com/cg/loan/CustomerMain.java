package com.cg.loan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import com.cg.loan.dto.Customer;
import com.cg.loan.main.Menu;
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
			System.out.println("6.Account Related Services");
			System.out.println("7.Exit");
			System.out.println("Enter Your Choice :");
			n = sc.nextInt();
			if (n == 1) {
				
				Customer customer = customerservice.addCustomer();			

				System.out.println("Customer Added Sucessfully with Id :"+customer.getCustomerId());
			}
			if(n==2) {
				System.out.println("Enter Your Customer Id : ");

				int id=sc.nextInt();		
				System.out.println("Customer Details Are");
				System.out.println(customerservice.viewCustomerById(id));

				
				if(customerservice.viewCustomerById(id)==null) {
					System.out.println("Customer with id "+id+" is not present..");
					
				}
				else {
					System.out.println("Customer Details Are");
					System.out.println(customerservice.viewCustomerById(id));
				}

				
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
			if(n==5) {
				System.out.println("Enter customer id to update: ");
				int id  = sc.nextInt();
				Customer customer = customerservice.updateCustomer(id);
				if(customer == null) {
					System.out.println("Customer is not present...");
					
				}
				else {
					System.out.println("Customer Updated Successfully...");
				}
			}
			if(n==6) {
				Menu menu = new Menu();
				menu.LoanApplicationMenu();
			}
			if(n==7) {
				System.out.println("Thank you..! visit again..");
				break;
			}
		} while (n < 7);
	}
}
