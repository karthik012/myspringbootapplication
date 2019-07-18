package com.demo.application.services;

import com.demo.application.model.Customer;

public interface CustomerService {
	Iterable<Customer> listAllCustomers();

	Customer getCustomerById(long custId);

	Customer saveCustomer(Customer customer);

	void deleteCustomer(long custId);
}
