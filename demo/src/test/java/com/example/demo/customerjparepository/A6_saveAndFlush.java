package com.example.demo.customerjparepository;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Customer;
import com.example.demo.CustomerJpaRepository;

@SpringBootTest
class A6_saveAndFlush {

	private static final Logger log = LoggerFactory.getLogger(A6_saveAndFlush.class);

	private final CustomerJpaRepository repository;

	@Autowired
	public A6_saveAndFlush(CustomerJpaRepository repository) {
		this.repository = repository;
	}

	@Test
	void test() {
		log.debug("JpaRepository saveAndFlush 테스트");

		Customer entity = new Customer("백행2", "이2");

		Customer customer = repository.saveAndFlush(entity);

		DebugUtils.debug(customer);

		DebugUtils.findAll(repository.findAll());
	}

}
