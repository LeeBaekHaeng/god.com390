package com.example.demo.customerjparepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;

import com.example.demo.Customer;
import com.example.demo.CustomerJpaRepository;

@SpringBootTest
class B2_findAll {

	private static final Logger log = LoggerFactory.getLogger(B2_findAll.class);

	private final CustomerJpaRepository repository;

	@Autowired
	public B2_findAll(CustomerJpaRepository repository) {
		this.repository = repository;
	}

	@Test
	void test() {
		log.debug("JpaRepository findAll 테스트");

		Customer customer = new Customer();
		log.debug("customer: {}", customer);

		Example<Customer> example = Example.of(customer);

		Sort sort = Sort.by("firstName").ascending().and(Sort.by("lastName").descending());

		List<Customer> customers = repository.findAll(example, sort);

		DebugUtils.findAll(customers);

		assertEquals(customers.size(), 6);
	}

}
