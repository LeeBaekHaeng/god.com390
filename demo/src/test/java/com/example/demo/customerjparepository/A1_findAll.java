package com.example.demo.customerjparepository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Customer;
import com.example.demo.CustomerJpaRepository;

@SpringBootTest
class A1_findAll {

	private static final Logger log = LoggerFactory.getLogger(A1_findAll.class);

	private final CustomerJpaRepository repository;

	@Autowired
	public A1_findAll(CustomerJpaRepository repository) {
		this.repository = repository;
	}

	@Test
	void test() {
		log.debug("JpaRepository List<T> findAll(); 테스트");

		List<Customer> customers = repository.findAll();

		log.debug("customers: {}", customers);

		DebugUtils.findAll(repository);
	}

}
