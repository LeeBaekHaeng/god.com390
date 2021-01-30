package com.example.demo.repository.comtngnrlmberrepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.ComTnGnrlMber;
import com.example.demo.repository.ComTnGnrlMberRepository;
import com.example.demo.service.ComTnGnrlMberService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class A3_findById {

	private final ComTnGnrlMberRepository repository;
	private final ComTnGnrlMberService service;

	@Autowired
	public A3_findById(ComTnGnrlMberRepository repository, ComTnGnrlMberService service) {
		this.repository = repository;
		this.service = service;
	}

	@Test
	void test() {
		log.debug("test");

		service.saveAll();

		String id = "1";

		Optional<ComTnGnrlMber> result = repository.findById(id);

		log.debug("result: {}", result);
		log.debug("get: {}", result.get());
		log.debug("getMberId: {}", result.get().getMberId());

		assertEquals(result.get().getMberId(), id);
	}

}
