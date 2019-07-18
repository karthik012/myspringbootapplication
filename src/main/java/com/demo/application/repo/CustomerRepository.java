package com.demo.application.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.demo.application.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
	List<Customer> findByLastName(String lastName);
	
	List<Customer> findByFirstName(String firstName);
	
	List<Customer> findByCountry(String country);
	
	//Customer update(Customer customer,long id);
	
}