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
class A4_update {

	private final ComTnGnrlMberRepository repository;
	private final ComTnGnrlMberService service;

	@Autowired
	public A4_update(ComTnGnrlMberRepository repository, ComTnGnrlMberService service) {
		this.repository = repository;
		this.service = service;
	}

	@Test
	void test() {
		log.debug("test");

		service.saveAll();

		String id = "1";

		Optional<ComTnGnrlMber> result = repository.findById(id);

		if (!result.isPresent()) {
			return;
		}

		log.debug("result: {}", result);
		log.debug("get: {}", result.get());
		log.debug("getMberId: {}", result.get().getMberId());
		log.debug("getPassword: {}", result.get().getPassword());

		assertEquals(result.get().getMberId(), id);

		result.get().setPassword("수정");
		log.debug("getPassword: {}", result.get().getPassword());
		repository.save(result.get());

		ComTnGnrlMber result2 = repository.findById(id).orElse(new ComTnGnrlMber());
		log.debug("result2: {}", result2);
		log.debug("getPassword: {}", result2.getPassword());
	}

}
