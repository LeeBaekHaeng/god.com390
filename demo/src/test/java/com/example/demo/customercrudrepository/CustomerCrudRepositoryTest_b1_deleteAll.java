package com.example.demo.customercrudrepository;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Customer;
import com.example.demo.CustomerCrudRepository;

@SpringBootTest
class CustomerCrudRepositoryTest_b1_deleteAll {

	private static final Logger log = LoggerFactory.getLogger(CustomerCrudRepositoryTest_b1_deleteAll.class);

	private final CustomerCrudRepository repository;

	@Autowired
	public CustomerCrudRepositoryTest_b1_deleteAll(CustomerCrudRepository repository) {
		this.repository = repository;
	}

	@Test
	void test() {
		log.debug("CustomerCrudRepository deleteAll 테스트");

		repository.deleteAll();

		Iterable<Customer> customers = repository.findAll();
		log.debug("customers: {}", customers);
	}

}
