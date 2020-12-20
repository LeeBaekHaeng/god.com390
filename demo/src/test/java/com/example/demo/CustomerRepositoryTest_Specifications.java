package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomerRepositoryTest_Specifications {

	private static final Logger log = LoggerFactory.getLogger(CustomerRepositoryTest_Specifications.class);

	private final CustomerRepository repository;

	@Autowired
	public CustomerRepositoryTest_Specifications(CustomerRepository repository) {
		this.repository = repository;
	}

	@Test
	void test() {
		Customer customer = new Customer();
		customer.setFirstName("백행");
		customer.setLastName("이");

		List<Customer> customers = repository
				.findAll(CustomerSpecs.isLongTermCustomer(customer).and(CustomerSpecs.hasSalesOfMoreThan(customer)));
		log.debug("customers: {}", customers);

		customers = repository.findAll(CustomerSpecs.spec(customer));
		log.debug("customers: {}", customers);

		customers = repository.findAll(CustomerSpecs.spec2(customer));
		log.debug("customers: {}", customers);
	}

}
