package com.cg.loan.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.cg.loan.dto.Customer;
import com.cg.loan.service.CustomerService;

public class CustomerServiceTest {

	CustomerService custService = new CustomerService();
	Customer customer = new Customer();

	@Test
	public void testAddCustomerForValidInput() {
		customer = custService.addCustomer();
		assertEquals(customer.getAge(), 22);
	}

	@Test
	public void testAddCustomerForNotValid() {
		customer = custService.addCustomer();
		assertNotEquals(customer.getAge(), 22);
	}

	@Test
	public void testViewCustomerForValidId() {
		customer = custService.viewCustomerById(102);
//assertEquals(customer.getFirstName(),"Aniket");
		assertNotNull(customer);
	}

	@Test
	public void testViewCustomerNotValidId() {
		customer = custService.viewCustomerById(155);
		assertNull(customer);
	}

//	@Test
//	public void testViewAllCustomers() {
//		List<Customer> cusList = new ArrayList<>();
//		cusList = custService.viewAllCustomer();
//		assertEquals(cusList.size(), 4);
//	}


}
