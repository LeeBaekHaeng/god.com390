package com.example.demo.querybyexampleexecutor;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

import com.example.demo.Customer;
import com.example.demo.CustomerJpaRepository;
import com.example.demo.customerjparepository.DebugUtils;

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
		log.debug("QueryByExampleExecutor findOne(Example<S> example) 테스트");

		Customer customer = new Customer();
		customer.setId(6L);

		Example<Customer> example = Example.of(customer);

		Optional<Customer> result = repository.findOne(example);

		DebugUtils.debug(result.get());
	}

	@Test
	void test2() {
		log.debug("QueryByExampleExecutor findOne(Example<S> example) 테스트");

		Customer customer = new Customer();
		customer.setId(7L);

		Example<Customer> example = Example.of(customer);

		Optional<Customer> result = repository.findOne(example);

		boolean isPresent = result.isPresent();
		log.debug("isPresent: {}", isPresent);

		if (!isPresent) {
			return;
		}

		DebugUtils.debug(result.get());
	}

}
