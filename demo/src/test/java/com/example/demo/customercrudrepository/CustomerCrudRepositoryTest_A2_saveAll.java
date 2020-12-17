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
class CustomerCrudRepositoryTest_A2_saveAll {

	private static final Logger log = LoggerFactory.getLogger(CustomerCrudRepositoryTest_A2_saveAll.class);

	private final CustomerCrudRepository customerCrudRepository;

	@Autowired
	public CustomerCrudRepositoryTest_A2_saveAll(CustomerCrudRepository customerCrudRepository) {
		this.customerCrudRepository = customerCrudRepository;
	}

	@Test
	void test() {
		List<Customer> entities = new ArrayList<>();

		Customer entity = new Customer("백행", "이");
		entities.add(entity);
		log.info("entity: {}", entity);

		entity = new Customer("세은", "이");
		entities.add(entity);
		log.info("entity: {}", entity);

		entity = new Customer("건후", "이");
		entities.add(entity);
		log.info("entity: {}", entity);

		log.info("entities: {}", entities);

		Iterable<Customer> saveAll = customerCrudRepository.saveAll(entities);

		log.info("saveAll: {}", saveAll);

		for (Customer save : saveAll) {
			log.info("save: {}", save);
		}

		Iterable<Customer> findAll = customerCrudRepository.findAll();
		log.info("findAll: {}", findAll);

		for (Customer find : findAll) {
			log.info("find: {}", find);
		}
	}

}
