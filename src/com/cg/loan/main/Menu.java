package com.cg.loan.main;

import java.util.List;
import java.util.Scanner;

import com.cg.loan.dto.LoanApplication;
import com.cg.loan.service.LoanApplicationService;

public class Menu {


		Scanner sc = new Scanner(System.in);
		LoanApplicationService loanService=new LoanApplicationService();
		String userChoice;
		
		void menu() {
			System.out.println("1. APPLY FOR LOAN");
			System.out.println("2. VIEW ALL LOANS OF A CUSTOMER");
			System.out.println("3. VIEW LOAN APPLICATION BY LOAN ID");
			System.out.println("4. CHECK / CLOSE LOAN");
			System.out.println("5. EXIT");
		}

		public void LoanApplicationMenu() {
	
			do {
				
				menu();
				System.out.println("Enter the your Choice: ");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					loanService.applyLoan();
					System.out.println("Loan Applied Successfully");
					break;
				case 2:
					System.out.println("Enter Customer ID to view all Loans:");
					int customerId=sc.nextInt();
					List<LoanApplication> loans=loanService.viewAllLoansByCustomerId(customerId);
					for(LoanApplication l:loans) {
						System.out.println(l);
					}
					break;
				case 3:
					System.out.println("Enter LoanId to view:");
					int loanId=sc.nextInt();
					System.out.println(loanService.viewLoanApplicationById(loanId));
					
					break;
				case 4:
					System.out.println("Enter LoanId to view:");
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


