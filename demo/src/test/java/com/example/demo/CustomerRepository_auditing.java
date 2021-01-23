package com.example.demo;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomerRepository_auditing {

	private static final Logger log = LoggerFactory.getLogger(CustomerRepository_auditing.class);

	private final CustomerRepository repository;

	@Autowired
	public CustomerRepository_auditing(CustomerRepository repository) {
		this.repository = repository;
	}

	@Test
	void test() {
		Customer entity = new Customer();

		Customer save = repository.save(entity);

		log.debug("save: {}", save);
		log.debug("getCreatedBy: {}", save.getCreatedBy());
		log.debug("getCreatedDate: {}", save.getCreatedDate());
		log.debug("getLastModifiedBy: {}", save.getLastModifiedBy());
		log.debug("getLastModifiedDate: {}", save.getLastModifiedDate());
	}

}
