package com.example.demo.customercrudrepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.CustomerCrudRepository;

@SpringBootTest
class CustomerCrudRepositoryTest_A4_existsById {

	private static final Logger log = LoggerFactory.getLogger(CustomerCrudRepositoryTest_A4_existsById.class);

	private final CustomerCrudRepository repository;

	@Autowired
	public CustomerCrudRepositoryTest_A4_existsById(CustomerCrudRepository repository) {
		this.repository = repository;
	}

	@Test
	void test() {
		boolean result = repository.existsById(6L);
		log.debug("result: {}", result);
		assertEquals(result, true);
	}

	@Test
	void test2() {
		boolean result = repository.existsById(7L);
		log.debug("result: {}", result);
		assertEquals(result, false);
	}

}
