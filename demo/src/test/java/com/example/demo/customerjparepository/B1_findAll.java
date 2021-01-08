package com.example.demo.customerjparepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

import com.example.demo.Customer;
import com.example.demo.CustomerJpaRepository;

@SpringBootTest
class B1_findAll {

	private static final Logger log = LoggerFactory.getLogger(B1_findAll.class);

	private final CustomerJpaRepository repository;

	@Autowired
	public B1_findAll(CustomerJpaRepository repository) {
		this.repository = repository;
	}

	@Test
	void test() {
		log.debug("JpaRepository findAll 테스트");

		Customer customer = new Customer();
		log.debug("customer: {}", customer);

		Example<Customer> example = Example.of(customer);

		List<Customer> customers = repository.findAll(example);

		DebugUtils.findAll(customers);

		assertEquals(customers.size(), 6);
	}

	@Test
	void test2() {
		log.debug("JpaRepository findAll 테스트");

		Customer customer = new Customer();
		customer.setId(6L);
		log.debug("customer: {}", customer);

		Example<Customer> example = Example.of(customer);

		List<Customer> customers = repository.findAll(example);

		DebugUtils.findAll(customers);

		assertEquals(customers.size(), 1);
		assertEquals(customers.get(0).getId(), customer.getId());
	}

	@Test
	void test3() {
		log.debug("JpaRepository findAll 테스트");

		Customer customer = new Customer();
		customer.setFirstName("백행");
		log.debug("customer: {}", customer);

		Example<Customer> example = Example.of(customer);

		List<Customer> customers = repository.findAll(example);

		DebugUtils.findAll(customers);

		assertEquals(customers.size(), 1);
		assertEquals(customers.get(0).getFirstName(), customer.getFirstName());
	}

	@Test
	void test4() {
		log.debug("JpaRepository findAll 테스트");

		Customer customer = new Customer();
		customer.setLastName("이");
		log.debug("customer: {}", customer);

		Example<Customer> example = Example.of(customer);

		List<Customer> customers = repository.findAll(example);

		DebugUtils.findAll(customers);

		assertEquals(customers.size(), 1);
		assertEquals(customers.get(0).getLastName(), customer.getLastName());
	}

}
