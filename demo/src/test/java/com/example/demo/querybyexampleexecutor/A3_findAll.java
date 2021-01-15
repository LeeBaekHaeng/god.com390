package com.example.demo.querybyexampleexecutor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;

import com.example.demo.Customer;
import com.example.demo.CustomerJpaRepository;
import com.example.demo.customerjparepository.DebugUtils;

@SpringBootTest
class A3_findAll {

	private static final Logger log = LoggerFactory.getLogger(A3_findAll.class);

	private final CustomerJpaRepository repository;

	@Autowired
	public A3_findAll(CustomerJpaRepository repository) {
		this.repository = repository;
	}

	@Test
	void test() {
		log.debug("QueryByExampleExecutor findAll(Example<S> example, Sort sort) 테스트");

		Customer customer = new Customer();
		customer.setId(6L);
		customer.setFirstName("백행");
		customer.setLastName("이");

		Example<Customer> example = Example.of(customer);
		Sort sort = Sort.by("firstName").ascending().and(Sort.by("lastName").descending());

		Iterable<Customer> results = repository.findAll(example, sort);

		DebugUtils.debug(results);

		log.debug("hashCode: {}", results.hashCode());
		log.debug("hashCode: {}", results.iterator().hashCode());
		log.debug("hasNext: {}", results.iterator().hasNext());

		assertEquals(results.iterator().next().getId(), customer.getId());
		assertEquals(results.iterator().next().getFirstName(), customer.getFirstName());
		assertEquals(results.iterator().next().getLastName(), customer.getLastName());
	}

}
