/*package com.demo.application.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.application.model.Customer;

public class CustomerRepositoryImpl implements CustomerRepository {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Long arg0) {
		customerRepository.delete(arg0);
	}

	@Override
	public void delete(Customer arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends Customer> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean exists(Long arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Customer> findAll() {

		return (List<Customer>) customerRepository.findAll();
	}

	@Override
	public Iterable<Customer> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findOne(Long arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Customer> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Customer> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> findByFirstName(String firstName) {
		ArrayList<Customer> customer = new ArrayList<Customer>();
		for (Customer val : customerRepository.findAll()) {
			if (val.getFirstName().equalsIgnoreCase(firstName)) {
				customer.add(val);
			}
		}
		return customer;
	}

	@Override
	public List<Customer> findByCountry(String country) {
		ArrayList<Customer> customer = new ArrayList<Customer>();
		for (Customer val : customerRepository.findAll()) {
			if (val.getCountry().equalsIgnoreCase(country)) {
				customer.add(val);
			}
		}
		return customer;
	}

	@Override
	public Customer update(Customer customer,long id) {
		
		for (Customer val : customerRepository.findAll()) {
			
			if(val.getId()==id){
			   val.setFirstName(customer.getFirstName());
			   val.setLastName(customer.getLastName());
			   val.setContact(customer.getContact());
			   val.setCountry(customer.getCountry());
			}
		}
		
		return customer;
	}

}
*/