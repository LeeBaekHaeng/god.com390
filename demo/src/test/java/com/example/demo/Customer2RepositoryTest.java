package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class Customer2RepositoryTest {

	private final Customer2Repository repository;

	@Autowired
	public Customer2RepositoryTest(Customer2Repository repository) {
		this.repository = repository;
	}

	@Test
	void test() {
		Customer2 entity = new Customer2();

		Customer2 save = repository.save(entity);

		log.debug("save: {}", save);
		log.debug("getCreatedBy: {}", save.getCreatedBy());
		log.debug("getCreatedDate: {}", save.getCreatedDate());
		log.debug("getLastModifiedBy: {}", save.getLastModifiedBy());
		log.debug("getLastModifiedDate: {}", save.getLastModifiedDate());
	}

}
