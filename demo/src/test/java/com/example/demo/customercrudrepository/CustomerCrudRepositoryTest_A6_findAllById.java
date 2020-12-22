package com.example.demo.customercrudrepository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Customer;
import com.example.demo.CustomerCrudRepository;

@SpringBootTest
class CustomerCrudRepositoryTest_A6_findAllById {

	private static final Logger log = LoggerFactory.getLogger(CustomerCrudRepositoryTest_A6_findAllById.class);

	private final CustomerCrudRepository repository;

	@Autowired
	public CustomerCrudRepositoryTest_A6_findAllById(CustomerCrudRepository repository) {
		this.repository = repository;
	}

	@Test
	void test() {
		List<Long> ids = new ArrayList<>();
		ids.add(1L);
		ids.add(6L);
		log.debug("ids: {}", ids);

		Iterable<Customer> customers = repository.findAllById(ids);
		log.debug("customers: {}", customers);

		customers.forEach(customer -> {
			log.debug("customer: {}", customer);
			log.debug("getId: {}", customer.getId());
			log.debug("getFirstName: {}", customer.getFirstName());
			log.debug("getLastName: {}", customer.getLastName());
		});
	}

}
