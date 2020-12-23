package com.example.demo.customercrudrepository;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.CustomerCrudRepository;

@SpringBootTest
class CustomerCrudRepositoryTest_A7_count {

	private static final Logger log = LoggerFactory.getLogger(CustomerCrudRepositoryTest_A7_count.class);

	private final CustomerCrudRepository repository;

	@Autowired
	public CustomerCrudRepositoryTest_A7_count(CustomerCrudRepository repository) {
		this.repository = repository;
	}

	@Test
	void test() {
		long count = repository.count();
		log.debug("count: {}", count);
	}

}
