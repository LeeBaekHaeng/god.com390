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
class A7_deleteInBatch {

	private static final Logger log = LoggerFactory.getLogger(A7_deleteInBatch.class);

	private final CustomerJpaRepository repository;

	@Autowired
	public A7_deleteInBatch(CustomerJpaRepository repository) {
		this.repository = repository;
	}

	@Test
	void test() {
		log.debug("JpaRepository deleteInBatch 테스트");

		List<Customer> entities = new ArrayList<>();

		for (long i = 1; i < 7; i++) {
			Customer entity = new Customer();
			entity.setId(i);
			entities.add(entity);
		}

		repository.deleteInBatch(entities);

		DebugUtils.findAll(repository.findAll());
	}

}
