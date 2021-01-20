package com.example.demo.querybyexampleexecutor;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

import com.example.demo.Customer;
import com.example.demo.CustomerJpaRepository;

@SpringBootTest
class A6_exists {

	private static final Logger log = LoggerFactory.getLogger(A6_exists.class);

	private final CustomerJpaRepository repository;

	@Autowired
	public A6_exists(CustomerJpaRepository repository) {
		this.repository = repository;
	}

	@Test
	void test() {
		log.debug("test 테스트");

		Customer customer = new Customer();
		customer.setId(6L);
		customer.setFirstName("백행");
		customer.setLastName("이");

		Example<Customer> example = Example.of(customer);

		boolean exists = repository.exists(example);

		log.debug("exists: {}", exists);
	}

}
