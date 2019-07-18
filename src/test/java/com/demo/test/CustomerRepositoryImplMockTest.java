package com.demo.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.demo.application.model.Customer;
import com.demo.application.repo.CustomerRepository;
import com.demo.application.services.CustomerServiceImpl;

public class CustomerRepositoryImplMockTest {

	private CustomerServiceImpl customerServiceImpl;
	@Mock
	private CustomerRepository customerRepository;
	@Mock
	private Customer customer;

	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		customerServiceImpl = new CustomerServiceImpl();
		customerServiceImpl.setCustomerRepository(customerRepository);
	}

	@Test
	public void shouldCalllistAllCustomersCustomerRepository_whenlistAllCustomersIsCalled() throws Exception {
		// Arrange
		Iterable<Customer> cust = new ArrayList<>();
		when(customerRepository.findAll()).thenReturn(cust);
		// Act
		Iterable<Customer> recvCust = customerServiceImpl.listAllCustomers();
		// Assert
		assertThat(recvCust, is(equalTo(cust)));
	}

	@Test
	public void shouldReturnCustomer_whenGetCustomerByIdIsCalled() throws Exception {
		// Arrange
		when(customerRepository.findOne((long) 2)).thenReturn(customer);
		// Act
		Customer retrievedCustomer = customerServiceImpl.getCustomerById(2l);
		// Assert
		assertThat(retrievedCustomer, is(equalTo(customer)));

	}

	@Test
	public void shouldReturnCustomer_whenSaveCustomerIsCalled() throws Exception {
		// Arrange
		when(customerRepository.save(customer)).thenReturn(customer);
		// Act
		Customer savedCustomer = customerServiceImpl.saveCustomer(customer);
		// Assert
		assertThat(savedCustomer, is(equalTo(customer)));
	}

	@Test
	public void shouldCallDeleteMethodOfCustomerRepository_whenDeleteCustomerIsCalled() throws Exception {
		// Arrange
		doNothing().when(customerRepository).delete((long) 1);
		CustomerRepository my = Mockito.mock(CustomerRepository.class);
		// Act
		customerServiceImpl.deleteCustomer(1l);
		// Assert
		verify(customerRepository, times(1)).delete(1l);
	}
}