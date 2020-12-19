package com.example.demo.customercrudrepository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Customer;
import com.example.demo.CustomerCrudRepository;

@SpringBootTest
class CustomerCrudRepositoryTest_A3_findById {

	private static final Logger log = LoggerFactory.getLogger(CustomerCrudRepositoryTest_A3_findById.class);

	private final CustomerCrudRepository repository;

	@Autowired
	public CustomerCrudRepositoryTest_A3_findById(CustomerCrudRepository repository) {
		this.repository = repository;
	}

	@Test
	void test() {
		Optional<Customer> result = repository.findById(16L);

		log.info("resultCustomer: {}", result);
		log.info("empty: {}", result.empty());
		if (result.isPresent()) {
			log.info("get: {}", result.get());
			log.info("getId: {}", result.get().getId());
			log.info("getFirstName: {}", result.get().getFirstName());
			log.info("getLastName: {}", result.get().getLastName());
		}
	}

}
