package com.demo.test;
 
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.application.springapplication;
import com.demo.application.model.Customer;
import com.demo.application.repo.CustomerRepository;
 
@RunWith(SpringRunner.class)
@SpringBootTest(classes = springapplication.class)
@DataJpaTest
public class CRUDTest {
 
	@Autowired
	private TestEntityManager entityManager;
 
	@Autowired
	CustomerRepository repository;
 
	@Test
	public void postCustomerTest() {
		Customer customer = repository.save(new Customer("anil","raj","USA",12345));
		assertThat(customer).hasFieldOrPropertyWithValue("firstName", "anil");
		assertThat(customer).hasFieldOrPropertyWithValue("lastName", "raj");
		assertThat(customer).hasFieldOrPropertyWithValue("country", "USA");
		assertThat(customer).hasFieldOrPropertyWithValue("contact", 12345L);
	}
 
	@Test
	public void findallTest() {
		Customer customer1 = new Customer("sen", "steve", "USA",12334);
		entityManager.persist(customer1);
 
		Iterable<Customer> customers = repository.findAll();
 
		assertThat(customers).hasSize(1).contains(customer1);
	}
 
	@Test
	public void findCustomerByIdTest() {
		Customer customer1 = new Customer("anil", "raj" , "India", 74682);
		entityManager.persist(customer1);
 
		Customer customer2 = new Customer("sam", "jhon", "USA" , 45572);
		entityManager.persist(customer2);
 
		Customer foundCustomer = repository.findOne(customer2.getId());
 
		assertThat(foundCustomer).isEqualTo(customer2);
	}
 

	@Test
	public void deleteCustomerTest() {
		entityManager.persist(new Customer("anil", "raj" , "India", 74682));
		entityManager.persist(new Customer("sam", "jhon", "USA" , 45572));
 
		repository.deleteAll();
 
		assertThat(repository.findAll()).isEmpty();
	}
}