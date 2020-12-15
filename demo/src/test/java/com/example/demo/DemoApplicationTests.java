package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@SpringBootTest
class DemoApplicationTests {

	private static final Logger log = LoggerFactory.getLogger(DemoApplicationTests.class);

	@Autowired
	private CustomerRepository customerRepository;

	@Test
	void contextLoads() {
		Pageable pageable = PageRequest.of(0, 20);

		Page<Customer> page = customerRepository.findAll(pageable);

		log.info("page: {}", page);
		log.info("getTotalPages: {}", page.getTotalPages());
		log.info("getTotalElements: {}", page.getTotalElements());

		List<Customer> customers = page.getContent();

		for (Customer customer : customers) {
			log.info("customer: {}", customer);
			log.info("getId: {}", customer.getId());
			log.info("getFirstName: {}", customer.getFirstName());
			log.info("getLastName: {}", customer.getLastName());
		}
	}

}
