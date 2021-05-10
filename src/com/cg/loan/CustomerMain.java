package com.cg.loan;

import java.util.Scanner;

import com.cg.loan.JDBC.JDBC_connectivity;
import com.cg.loan.dto.Customer;
import com.cg.loan.main.Menu;
import com.cg.loan.service.CustomerService;

public class CustomerMain {
	
	void menu() {
		System.out.println("--------------------MENU----------------------------");
		System.out.println("1.ADD Customer");
		System.out.println("2.View Customer By Id");
		System.out.println("3.View All Customer");
		System.out.println("4.Delete Customer By Id");
		System.out.println("5.Update Customer By Id");			
		System.out.println("6.Login as a customer");
		System.out.println("7.Exit");
	}
	
	public static void main(String[] args) {
		CustomerMain main=new CustomerMain();
		CustomerService customerservice = new CustomerService();
		Scanner sc = new Scanner(System.in);
		int n = 0;
		do {

			main.menu();
			
			System.out.println("Enter Your Choice :");
			n = sc.nextInt();
			if (n == 1) {
				JDBC_connectivity jd = new JDBC_connectivity();
				jd.connect();
				Customer customer = customerservice.addCustomer();

				System.out.println("Customer Added Sucessfully with Id :" + customer.getCustomerId());
			}
			if (n == 2) {
				System.out.println("Enter Your Customer Id : ");

				int id = sc.nextInt();

				if (customerservice.viewCustomerById(id) == null) {
					System.out.println("Customer with id " + id + " is not present..");

				} else {
					System.out.println("Customer Details Are");
					System.out.println(customerservice.viewCustomerById(id));
				}

			}
			if (n == 3) {
				System.out.println("Customers Are:");
				System.out.println(customerservice.viewAllCustomer());
			}
			if (n == 4) {
				System.out.println("Enter Your Customer Id : ");
				int id = sc.nextInt();
				customerservice.deleteCustomerById(id);
			}
			if (n == 5) {
				System.out.println("Enter customer id to update: ");
				int id = sc.nextInt();
				Customer customer = customerservice.updateCustomer(id);
				System.out.println("Customer Updated Successfully...");

			}
			if (n == 6) {
				System.out.println("Login");
				System.out.println("Enter Email id:");
				String email = sc.next();
				System.out.println("Enter Password:");
				String password = sc.next();

				Customer customer = customerservice.login(email, password);

				if (customer.getEmail() == null) {
					System.out.println("Invalid credintials....");
				} else {
					System.out.println("Login successful...");
					Menu menu = new Menu();
					menu.LoanApplicationMenu(customer);
				}

			}

			if (n == 7) {
				System.out.println("Thank you..! visit again..");
				break;
			}
		} while (n < 8);
	}
}
