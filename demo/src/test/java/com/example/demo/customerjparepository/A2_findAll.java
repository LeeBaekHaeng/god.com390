package com.example.demo.customerjparepository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import com.example.demo.Customer;
import com.example.demo.CustomerJpaRepository;

@SpringBootTest
class A2_findAll {

	private static final Logger log = LoggerFactory.getLogger(A2_findAll.class);

	private final CustomerJpaRepository repository;

	@Autowired
	public A2_findAll(CustomerJpaRepository repository) {
		this.repository = repository;
	}

	@Test
	void test() {
		log.debug("JpaRepository List<T> findAll(Sort sort); 테스트");

//		https://docs.spring.io/spring-data/jpa/docs/2.4.2/reference/html/#repositories.paging-and-sorting

		Sort sort = Sort.by("firstName").ascending().and(Sort.by("lastName").descending());

		List<Customer> customers = repository.findAll(sort);

		DebugUtils.findAll(customers);
	}

	@Test
	void test2() {
		log.debug("JpaRepository List<T> findAll(Sort sort); 테스트");

		String[] properties = { "firstName", "lastName" };
		Sort sort = Sort.by(properties);

		List<Customer> customers = repository.findAll(sort);

		DebugUtils.findAll(customers);
	}

}
