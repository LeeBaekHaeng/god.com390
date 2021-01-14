package com.example.demo.querybyexampleexecutor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;
import java.util.List;

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
class A2_findAll {

	private static final Logger log = LoggerFactory.getLogger(A2_findAll.class);

	private final CustomerJpaRepository repository;

	@Autowired
	public A2_findAll(CustomerJpaRepository repository) {
		this.repository = repository;
	}

	@Test
	void test() {
		log.debug("QueryByExampleExecutor findAll(Example<S> example) 테스트");

		Customer customer = new Customer();
		customer.setId(6L);
		customer.setFirstName("백행");
		customer.setLastName("이");

		Example<Customer> example = Example.of(customer);

		Iterable<Customer> results = repository.findAll(example);

		DebugUtils.debug(results);

		log.debug("hashCode: {}", results.hashCode());
		log.debug("hashCode: {}", results.iterator().hashCode());
		log.debug("hasNext: {}", results.iterator().hasNext());

		assertEquals(results.iterator().next().getId(), customer.getId());
		assertEquals(results.iterator().next().getFirstName(), customer.getFirstName());
		assertEquals(results.iterator().next().getLastName(), customer.getLastName());
	}

	@Test
	void test2() {
		log.debug("QueryByExampleExecutor findAll(Example<S> example) 테스트");

		Customer customer = new Customer();
		customer.setId(60L);
		customer.setFirstName("백행");
		customer.setLastName("이");

		Example<Customer> example = Example.of(customer);

		Iterable<Customer> results = repository.findAll(example);

		DebugUtils.debug(results);

		log.debug("hashCode: {}", results.hashCode());
		log.debug("hashCode: {}", results.iterator().hashCode());
		log.debug("hasNext: {}", results.iterator().hasNext());

		assertEquals(results.iterator().hasNext(), false);
	}

	@Test
	void test3() {
		log.debug("QueryByExampleExecutor findAll(Example<S> example) 테스트");

		Customer customer = new Customer();
		customer.setId(6L);
		customer.setFirstName("백행");
		customer.setLastName("이");

		Example<Customer> example = Example.of(customer);

		Collection<Customer> results = repository.findAll(example);

		DebugUtils.debug(results);

		assertEquals(results.size(), 1);
	}

	@Test
	void test4() {
		log.debug("QueryByExampleExecutor findAll(Example<S> example) 테스트");

		Customer customer = new Customer();
		customer.setId(6L);
		customer.setFirstName("백행");
		customer.setLastName("이");

		Example<Customer> example = Example.of(customer);

		List<Customer> results = repository.findAll(example);

		DebugUtils.debug(results);

		assertEquals(results.size(), 1);
	}

}
