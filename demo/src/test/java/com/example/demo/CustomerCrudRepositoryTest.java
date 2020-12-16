package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomerCrudRepositoryTest {

	private static final Logger log = LoggerFactory.getLogger(CustomerCrudRepositoryTest.class);

	private final CustomerCrudRepository customerCrudRepository;

	@Autowired
	public CustomerCrudRepositoryTest(CustomerCrudRepository customerCrudRepository) {
		this.customerCrudRepository = customerCrudRepository;
	}

	@Test
	void test() {
		Customer entity = new Customer();

		log.info("entity: {}", entity);

		Customer save = customerCrudRepository.save(entity);

		log.info("save: {}", save);

		assertEquals(save, entity);
		assertEquals(save.getId(), entity.getId());
	}

	@Test
	void test2() {
		Customer entity = new Customer("백행", "이");

		log.info("entity: {}", entity);

		Customer save = customerCrudRepository.save(entity);

//		entity.setFirstName("백행 수정");
		save.setFirstName("백행 수정");

		log.info("save: {}", save);

		assertEquals(save, entity);
		assertEquals(save.getId(), entity.getId());
	}

	@Test
	void test3() {
		Customer customer = new Customer("백행", "이");

		log.info("customer: {}", customer);

		customerCrudRepository.save(customer);

		customer.setFirstName("백행 수정");

		log.info("customer: {}", customer);
	}

}
