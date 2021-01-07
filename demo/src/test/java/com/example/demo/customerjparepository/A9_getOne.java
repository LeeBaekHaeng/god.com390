package com.example.demo.customerjparepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Customer;
import com.example.demo.CustomerJpaRepository;

@SpringBootTest
class A9_getOne {

	private static final Logger log = LoggerFactory.getLogger(A9_getOne.class);

	private final CustomerJpaRepository repository;

	@Autowired
	public A9_getOne(CustomerJpaRepository repository) {
		this.repository = repository;
	}

	@Test
	@Transactional
	void test() {
		log.debug("JpaRepository getOne 테스트");

		Long id = 6L;

		Customer customer = repository.getOne(id);

		log.debug("customer: {}", customer);

		DebugUtils.debug(customer);

		assertEquals(customer.getId(), id);
	}

}
