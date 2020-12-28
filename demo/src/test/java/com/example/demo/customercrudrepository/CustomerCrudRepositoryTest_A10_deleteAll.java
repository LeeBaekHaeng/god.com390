package com.example.demo.customercrudrepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Customer;
import com.example.demo.CustomerCrudRepository;

@SpringBootTest
class CustomerCrudRepositoryTest_A10_deleteAll {

	private static final Logger log = LoggerFactory.getLogger(CustomerCrudRepositoryTest_A10_deleteAll.class);

	private final CustomerCrudRepository repository;

	@Autowired
	public CustomerCrudRepositoryTest_A10_deleteAll(CustomerCrudRepository repository) {
		this.repository = repository;
	}

	@Test
	void test() {
		log.debug("CustomerCrudRepository deleteAll 테스트");

		List<Customer> entities = new ArrayList<>();

		Customer entity = new Customer();
		entity.setId(1L);
		entities.add(entity);

		entity = new Customer();
		entity.setId(6L);
		entities.add(entity);

		repository.deleteAll(entities);

		Iterable<Customer> customers = repository.findAll();
		log.debug("customers: {}", customers);

		Optional<Customer> customer = repository.findById(entities.get(0).getId());
		log.debug("customer: {}", customer);
		log.debug("isPresent: {}", customer.isPresent());
		assertEquals(customer.isPresent(), false);

		customer = repository.findById(entities.get(1).getId());
		log.debug("customer: {}", customer);
		log.debug("isPresent: {}", customer.isPresent());
		assertEquals(customer.isPresent(), false);
	}

}
