package com.example.demo.pagingandsortingrepository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import com.example.demo.Customer;
import com.example.demo.CustomerJpaRepository;
import com.example.demo.customerjparepository.DebugUtils;

@SpringBootTest
class A1_findAll {

	private static final Logger log = LoggerFactory.getLogger(A1_findAll.class);

	private final CustomerJpaRepository repository;

	@Autowired
	public A1_findAll(CustomerJpaRepository repository) {
		this.repository = repository;
	}

	@Test
	void test() {
		log.debug("PagingAndSortingRepository findAll(Sort sort) 테스트");

		Sort sort = Sort.by("firstName").ascending().and(Sort.by("lastName").descending());

		List<Customer> customers = repository.findAll(sort);

		DebugUtils.findAll(customers);
	}

}
