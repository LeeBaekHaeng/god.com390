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
		Optional<Customer> result = repository.findById(6L);

		log.debug("resultCustomer: {}", result);
		log.debug("empty: {}", result.empty());
		if (result.isPresent()) {
			log.debug("get: {}", result.get());
			log.debug("getId: {}", result.get().getId());
			log.debug("getFirstName: {}", result.get().getFirstName());
			log.debug("getLastName: {}", result.get().getLastName());
		}
	}

}
