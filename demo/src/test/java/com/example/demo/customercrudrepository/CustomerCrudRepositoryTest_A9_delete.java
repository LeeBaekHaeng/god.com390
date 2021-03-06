package com.example.demo.customercrudrepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Customer;
import com.example.demo.CustomerCrudRepository;

@SpringBootTest
class CustomerCrudRepositoryTest_A9_delete {

	private static final Logger log = LoggerFactory.getLogger(CustomerCrudRepositoryTest_A9_delete.class);

	private final CustomerCrudRepository repository;

	@Autowired
	public CustomerCrudRepositoryTest_A9_delete(CustomerCrudRepository repository) {
		this.repository = repository;
	}

	@Test
	void test() {
		log.debug("CustomerCrudRepository delete 테스트");

		Customer entity = new Customer();
		entity.setId(6L);
//		entity.setId(60L);

		repository.delete(entity);

		Iterable<Customer> customers = repository.findAll();
		log.debug("customers: {}", customers);

		Optional<Customer> customer = repository.findById(entity.getId());
		log.debug("customer: {}", customer);
		log.debug("isPresent: {}", customer.isPresent());

		assertEquals(customer.isPresent(), false);
	}

}
