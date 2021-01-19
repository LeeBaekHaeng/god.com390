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
class A5_count {

	private static final Logger log = LoggerFactory.getLogger(A5_count.class);

	private final CustomerJpaRepository repository;

	@Autowired
	public A5_count(CustomerJpaRepository repository) {
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

		long count = repository.count(example);

		log.debug("count: {}", count);
	}

}
