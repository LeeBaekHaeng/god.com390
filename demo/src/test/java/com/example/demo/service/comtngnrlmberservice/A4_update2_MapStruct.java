package com.example.demo.service.comtngnrlmberservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.ComTnGnrlMberDTO;
import com.example.demo.service.ComTnGnrlMberService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class A4_update2_MapStruct {

	private final ComTnGnrlMberService service;

	@Autowired
	public A4_update2_MapStruct(ComTnGnrlMberService service) {
		this.service = service;
	}

	@Test
	void test() {
		log.debug("test");

		service.saveAll();

		ComTnGnrlMberDTO dto = new ComTnGnrlMberDTO();
		dto.setMberId("99");
		dto.setPassword("수정");

		ComTnGnrlMberDTO update = service.update2(dto);

		log.debug("update: {}", update);
		log.debug("getMberId: {}", update.getMberId());
		log.debug("getPassword: {}", update.getPassword());

		assertEquals(update.getMberId(), dto.getMberId());
		assertEquals(update.getPassword(), dto.getPassword());
	}

}
