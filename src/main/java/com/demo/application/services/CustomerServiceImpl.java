package com.demo.application.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.application.model.Customer;
import com.demo.application.repo.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private CustomerRepository customerRepository;

	@Autowired
	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public Iterable<Customer> listAllCustomers() {
		logger.debug("listAllCustomers called");
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(long custId) {
		logger.debug("getCustomerById called");
		return customerRepository.findOne(custId);
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		logger.debug("saveCustomer called");
		return customerRepository.save(customer);
	}

	@Override
	public void deleteCustomer(long custId) {
		logger.debug("deleteCustomer called");
		customerRepository.delete(custId);
	}
}
