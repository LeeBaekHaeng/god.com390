package com.example.demo.repository.comtngnrlmberrepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.ComTnGnrlMber;
import com.example.demo.repository.ComTnGnrlMberRepository;
import com.example.demo.service.ComTnGnrlMberService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class A5_delete {

	private final ComTnGnrlMberRepository repository;
	private final ComTnGnrlMberService service;

	@Autowired
	public A5_delete(ComTnGnrlMberRepository repository, ComTnGnrlMberService service) {
		this.repository = repository;
		this.service = service;
	}

	@Test
	void test() {
		log.debug("test");

		service.saveAll();

		String id = "1";

		repository.deleteById(id);

		ComTnGnrlMber result = repository.findById(id).orElse(new ComTnGnrlMber());
		log.debug("result: {}", result);
		log.debug("getMberId: {}", result.getMberId());
		log.debug("getPassword: {}", result.getPassword());
	}

}
