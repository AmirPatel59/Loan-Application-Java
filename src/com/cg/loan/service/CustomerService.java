package com.cg.loan.service;

import java.util.ArrayList;
import java.util.List;

import com.cg.loan.dto.Customer;

public class CustomerService {
	List<Customer> list = new ArrayList<Customer>();

	public Customer addCustomer(Customer customer) {
		list.add(customer);
		return customer;
	}

	public Customer viewCustomerById(int id) {
		Customer customer = new Customer();
		
		for (int i = 0; i < list.size(); i++) {
			Customer customer1 = list.get(i);
//			System.out.println(customer1);
			if (customer1.getCustomerId() == id) {
				customer = customer1;
			} else {
				return null;
			}
		}

		return customer;
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
}
