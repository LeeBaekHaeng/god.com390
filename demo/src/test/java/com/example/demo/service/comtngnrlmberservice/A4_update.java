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
class A4_update {

	private final ComTnGnrlMberService service;

	@Autowired
	public A4_update(ComTnGnrlMberService service) {
		this.service = service;
	}

	@Test
	void test() {
		log.debug("test");

		service.saveAll();

		ComTnGnrlMber entity = new ComTnGnrlMber();
		entity.setMberId("99");
		entity.setPassword("수정");

		ComTnGnrlMber update = service.update(entity);

		log.debug("update: {}", update);
		log.debug("getMberId: {}", update.getMberId());
		log.debug("getPassword: {}", update.getPassword());

		assertEquals(update.getMberId(), entity.getMberId());
		assertEquals(update.getPassword(), entity.getPassword());
	}

}
