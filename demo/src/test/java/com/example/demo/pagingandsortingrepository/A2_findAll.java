package com.example.demo.pagingandsortingrepository;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.example.demo.Customer;
import com.example.demo.CustomerPagingAndSortingRepository;
import com.example.demo.customerjparepository.DebugUtils;

@SpringBootTest
class A2_findAll {

	private static final Logger log = LoggerFactory.getLogger(A2_findAll.class);

	private final CustomerPagingAndSortingRepository repository;

	@Autowired
	public A2_findAll(CustomerPagingAndSortingRepository repository) {
		this.repository = repository;
	}

	@Test
	void test() {
		log.debug("PagingAndSortingRepository findAll(Pageable pageable) 테스트");

		Pageable pageable = PageRequest.of(0, 2);

		Page<Customer> page = repository.findAll(pageable);

		log.debug("getTotalPages: {}", page.getTotalPages());
		log.debug("getTotalElements: {}", page.getTotalElements());
		log.debug("getNumber: {}", page.getNumber());
		log.debug("getNumberOfElements: {}", page.getNumberOfElements());
		log.debug("getSize: {}", page.getSize());

		DebugUtils.findAll(page.getContent());
	}

}
