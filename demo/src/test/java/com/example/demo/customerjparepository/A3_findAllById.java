package com.example.demo.customerjparepository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Customer;
import com.example.demo.CustomerJpaRepository;

@SpringBootTest
class A3_findAllById {

	private static final Logger log = LoggerFactory.getLogger(A3_findAllById.class);

	private final CustomerJpaRepository repository;

	@Autowired
	public A3_findAllById(CustomerJpaRepository repository) {
		this.repository = repository;
	}

	@Test
	void test() {
		log.debug("JpaRepository List<T> findAllById(Iterable<ID> ids); 테스트");

		List<Long> ids = new ArrayList<>();
		ids.add(1L);
		ids.add(6l);

		List<Customer> customers = repository.findAllById(ids);

		DebugUtils.findAll(customers);
	}

}
