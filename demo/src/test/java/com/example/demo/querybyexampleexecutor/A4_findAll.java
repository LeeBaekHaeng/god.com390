package com.example.demo.querybyexampleexecutor;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.example.demo.Customer;
import com.example.demo.CustomerJpaRepository;

@SpringBootTest
class A4_findAll {

	private static final Logger log = LoggerFactory.getLogger(A4_findAll.class);

	private final CustomerJpaRepository repository;

	@Autowired
	public A4_findAll(CustomerJpaRepository repository) {
		this.repository = repository;
	}

	@Test
	void test() {
		log.debug("QueryByExampleExecutor findAll(Example<S> example, Pageable pageable) 테스트");

		Customer customer = new Customer();
		customer.setId(6L);
		customer.setFirstName("백행");
		customer.setLastName("이");

		Example<Customer> example = Example.of(customer);
		Pageable pageable = PageRequest.of(0, 10);

		Page<Customer> page = repository.findAll(example, pageable);

		log.debug("page: {}", page);
		log.debug("getContent: {}", page.getContent());
		log.debug("getTotalElements: {}", page.getTotalElements());
	}

}
