package com.example.demo.customerjparepository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.Customer;
import com.example.demo.CustomerJpaRepository;

public class DebugUtils {

	private static final Logger log = LoggerFactory.getLogger(DebugUtils.class);

	public static void findAll(CustomerJpaRepository repository) {
		List<Customer> customers = repository.findAll();

		log.debug("customers: {}", customers);
		log.debug("size: {}", customers.size());

		for (Customer customer : customers) {
			log.debug("customer: {}", customer);
			log.debug("getId: {}", customer.getId());
			log.debug("getFirstName: {}", customer.getFirstName());
			log.debug("getLastName: {}", customer.getLastName());
		}
	}

	public static void findAll(List<Customer> customers) {
		log.debug("customers: {}", customers);
		log.debug("size: {}", customers.size());

		for (Customer customer : customers) {
			log.debug("customer: {}", customer);
			log.debug("getId: {}", customer.getId());
			log.debug("getFirstName: {}", customer.getFirstName());
			log.debug("getLastName: {}", customer.getLastName());
		}
	}

	public static void debug(Customer customer) {
		log.debug("customer: {}", customer);
		log.debug("getId: {}", customer.getId());
		log.debug("getFirstName: {}", customer.getFirstName());
		log.debug("getLastName: {}", customer.getLastName());
	}

}
