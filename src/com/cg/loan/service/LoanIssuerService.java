package com.cg.loan.service;

import java.util.Scanner;
import com.cg.loan.JDBC.JDBCLoanApplication;

public class LoanIssuerService {

	final String email = "aniketamage@gmail.com";
	final String password = "Aniket@1900";

	public void login(String cemail, String cpassword) {
		Scanner sc = new Scanner(System.in);
		if (cemail.equals(email) && cpassword.equals(password)) {

			int n = 0;
			System.out.println("Login Successful..");
			do {
				System.out.println("--------------------MENU----------------------------");
				System.out.println("1.View All Applications");
				System.out.println("2.View Application loan Id");
				System.out.println("3.Set loan Status");
				System.out.println("4.Logout");
				System.out.println("Enter Your Choice :");
				n = sc.nextInt();

				if (n == 1) {

					LoanApplicationService lservice = new LoanApplicationService();
					lservice.viewAllLoans();
				}

				else if (n == 2) {
					System.out.println("Enter loan Application Id:");
					int lid = sc.nextInt();
					LoanApplicationService lseService = new LoanApplicationService();
					lseService.viewLoanApplicationById(lid);
				} else if (n == 3) {
					System.out.println("Enter loan Application Id:");
					int lid = sc.nextInt();
					System.out.println("Set the Loan Status:");
					String status=sc.next();
					JDBCLoanApplication jdbc = new JDBCLoanApplication();
					jdbc.updateLoanStatusByIssuer(lid, status);
					System.out.println("Loan Approved successfully...");
				} else if (n == 4) {
					System.out.println("Logout Successful...");
					break;
				}
			} while (n < 5);
		} else {
			System.out.println("Invalid Credintial...");
		}
	}

}
