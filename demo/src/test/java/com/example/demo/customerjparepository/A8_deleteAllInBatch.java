package com.example.demo.customerjparepository;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.CustomerJpaRepository;

@SpringBootTest
class A8_deleteAllInBatch {

	private static final Logger log = LoggerFactory.getLogger(A8_deleteAllInBatch.class);

	private final CustomerJpaRepository repository;

	@Autowired
	public A8_deleteAllInBatch(CustomerJpaRepository repository) {
		this.repository = repository;
	}

	@Test
	void test() {
		log.debug("JpaRepository deleteAllInBatch 테스트");

		repository.deleteAllInBatch();

		DebugUtils.findAll(repository.findAll());
	}

}
