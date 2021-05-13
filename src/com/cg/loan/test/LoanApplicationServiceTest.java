package com.cg.loan.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cg.loan.dto.LoanApplication;
import com.cg.loan.service.LoanApplicationService;

public class LoanApplicationServiceTest {

	 LoanApplicationService loanService= new LoanApplicationService();
	 
	    LoanApplication loanApplication = new LoanApplication();

	 

	    @Test
	    public void testAddLoanApplicationforValidId() {
	    loanApplication=loanService.applyLoan(104);
	    assertNotNull(loanApplication);
	    }
	    
	    @Test
	    public void testViewLoanforValidLoanId() 
	    {
	        loanApplication=loanService.viewLoanApplicationById(16);
	        assertNotNull(loanApplication) ;
	    }
	    
	    @Test
	    public void testViewLoanforInValidLoanId() 
	    {
	        loanApplication=loanService.viewLoanApplicationById(12);
	        assertNull(loanApplication);
	        
	    }
	    
	 

}
