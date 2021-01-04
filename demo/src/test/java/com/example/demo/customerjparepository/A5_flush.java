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
class A5_flush {

	private static final Logger log = LoggerFactory.getLogger(A5_flush.class);

	private final CustomerJpaRepository repository;

	@Autowired
	public A5_flush(CustomerJpaRepository repository) {
		this.repository = repository;
	}

	@Test
	void test() {
		log.debug("JpaRepository flush 테스트");

		List<Customer> entities = new ArrayList<>();

		for (int i = 2; i < 3; i++) {
			Customer entity = new Customer("백행" + i, "이" + i);
			entities.add(entity);
		}

		List<Customer> customers = repository.saveAll(entities);
		repository.flush();

		DebugUtils.findAll(customers);

		DebugUtils.findAll(repository.findAll());
	}

}
