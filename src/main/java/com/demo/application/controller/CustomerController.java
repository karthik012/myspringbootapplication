package com.demo.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.application.message.Response;
import com.demo.application.model.Customer;
import com.demo.application.repo.CustomerRepository;

@RestController
public class CustomerController {

	@Autowired
	CustomerRepository repository;

	// Create an record - POST

	@RequestMapping(value = "/postcustomer", method = RequestMethod.POST)
	public Response postCustomer(@RequestBody Customer customer) {

		repository.save(new Customer(customer.getFirstName(), customer.getLastName(), customer.getCountry(),
				customer.getContact()));
		
		return new Response("Done",customer);
	}

	// Read every record - GET

	@RequestMapping(value = "/findall", method = RequestMethod.GET)
	public Response findAll() {

		Iterable<Customer> customers = repository.findAll();

		return new Response("Done", customers);
	}

	// Read a particular record by id - GET

	@RequestMapping(value = "/customer/{custid}", method = RequestMethod.GET)
	public Response findCustomerById(@PathVariable long custid) {

		Customer customer = repository.findOne(custid);

		return new Response("Done", customer);
	}

	@RequestMapping(value = "/findbyfirstname", method = RequestMethod.POST)
	public Response findbyFirstname(@RequestBody String firstName) {

		List<Customer> customers = repository.findByFirstName(firstName);

		return new Response("Done", customers);
	}

	// Update
	@RequestMapping(value = { "/updatecustomer" }, method = RequestMethod.PUT)
	public Response updateCustomer(@RequestBody Customer customer) {
		Customer customerDb = repository.findOne(customer.getId());
		customerDb.setFirstName(customer.getFirstName());
		customerDb.setLastName(customer.getLastName());
		customerDb.setContact(customer.getContact());
		customerDb.setCountry(customer.getCountry());
		repository.save(customerDb);
		return new Response("Updated the customer :", customer.getId());

	}

	// Delete
	@RequestMapping(value = "/customer/{custid}", method = RequestMethod.DELETE)
	public Response deleteCustomer(@PathVariable long custid) {
		repository.delete(custid);
		return new Response("deleted the customer", custid);
	}

	/*
	 * // Read a particular record by firstname
	 * 
	 * @RequestMapping(value = "/findbyfirstname", method = RequestMethod.GET)
	 * public Response findbyFirstname(@RequestParam("firstName") String
	 * firstName) {
	 * 
	 * List<Customer> customers = repository.findByFirstName(firstName);
	 * 
	 * return new Response("Done", customers); }
	 */
}
