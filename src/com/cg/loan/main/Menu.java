package com.cg.loan.main;

import java.util.List;
import java.util.Scanner;

import com.cg.loan.JDBC.JDBCLoanApplication;
import com.cg.loan.dto.Customer;
import com.cg.loan.dto.LoanApplication;
import com.cg.loan.service.LoanApplicationService;

public class Menu {


		Scanner sc = new Scanner(System.in);
		LoanApplicationService loanService=new LoanApplicationService();
		String userChoice;
		
		void menu(String name, int id) {
			System.out.println("Hello "+name+" id "+id );
			System.out.println("1. APPLY FOR LOAN");
			System.out.println("2. VIEW ALL LOANS OF A CUSTOMER");
			System.out.println("3. VIEW LOAN APPLICATION BY LOAN ID");
			System.out.println("4. CHECK / CLOSE LOAN");
			System.out.println("5. EXIT");
		}

		public void LoanApplicationMenu(Customer customer) {
	
			do {
				
				menu(customer.getFirstName(),customer.getCustomerId());
				System.out.println("Enter the your Choice: ");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					JDBCLoanApplication dbconnect=new JDBCLoanApplication();
					dbconnect.connect();
					LoanApplication application= loanService.applyLoan(customer.getCustomerId());
					System.out.println("Loan Applied Successfully");
					break;
				case 2:
				
					System.out.println(loanService.viewAllLoansByCustomerId(customer.getCustomerId()));
					
					break;
				case 3:
					System.out.println("Enter LoanId to view:");
					int loanId=sc.nextInt();
					if(loanService.viewLoanApplicationById(loanId).getLoanId()==0) {
						System.out.println("Loan with ID "+loanId+" is not present");
					}
					else {
//						System.out.println(loanService.viewLoanApplicationById(loanId));
					}
					
					
					break;
				case 4:
					System.out.println("Enter LoanId to view Status:");
					loanId=sc.nextInt();
					System.out.println(loanService.closeLoan(loanId));
					break;
				case 5:
					System.out.println("Thanks for using C-Evils Bank Services");
					System.exit(0);
					break;	
				default:
					System.exit(0);
					
				}
				System.out.println("Do you want to continue (Y/N):");
				userChoice = sc.next();
			} while (userChoice.equalsIgnoreCase("Y"));
		}

	}
