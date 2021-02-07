package com.example.demo.service.comtngnrlmberservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.ComTnGnrlMber;
import com.example.demo.service.ComTnGnrlMberService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class A5_delete {

	private final ComTnGnrlMberService service;

	@Autowired
	public A5_delete(ComTnGnrlMberService service) {
		this.service = service;
	}

	@Test
	void test() {
		log.debug("test");

		service.saveAll();

		String id = "1";

		findById(id);

		service.deleteById(id);

		findById(id);
	}

	private void findById(String id) {
		ComTnGnrlMber result = service.findById(id);
		log.debug("result: {}", result);
		log.debug("getMberId: {}", result.getMberId());
		log.debug("getPassword: {}", result.getPassword());
	}

}
