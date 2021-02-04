package com.example.demo.service.comtngnrlmberservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.ComTnGnrlMber;
import com.example.demo.service.ComTnGnrlMberService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class A3_findById {

	private final ComTnGnrlMberService service;

	@Autowired
	public A3_findById(ComTnGnrlMberService service) {
		this.service = service;
	}

	@Test
	void test() {
		log.debug("test");

		service.saveAll();

		String id = "1";

		ComTnGnrlMber result = service.findById(id);

		log.debug("result: {}", result);
		log.debug("getMberId: {}", result.getMberId());

		assertEquals(result.getMberId(), id);
	}

}
