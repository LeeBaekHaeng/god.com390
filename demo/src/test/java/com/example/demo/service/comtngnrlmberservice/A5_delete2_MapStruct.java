package com.example.demo.service.comtngnrlmberservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.ComTnGnrlMberDTO;
import com.example.demo.entity.ComTnGnrlMber;
import com.example.demo.service.ComTnGnrlMberService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class A5_delete2_MapStruct {

	private final ComTnGnrlMberService service;

	@Autowired
	public A5_delete2_MapStruct(ComTnGnrlMberService service) {
		this.service = service;
	}

	@Test
	void test() {
		log.debug("test");

		service.saveAll();

		ComTnGnrlMberDTO dto = new ComTnGnrlMberDTO();
		dto.setMberId("1");

		ComTnGnrlMber result = findById(dto.getMberId());
		assertEquals(result.getMberId(), dto.getMberId());

		service.deleteById(dto.getMberId());

		result = findById(dto.getMberId());
		assertEquals(result.getMberId(), null);
	}

	private ComTnGnrlMber findById(String id) {
		ComTnGnrlMber result = service.findById(id);
		log.debug("result: {}", result);
		log.debug("getMberId: {}", result.getMberId());
		log.debug("getPassword: {}", result.getPassword());
		return result;
	}

}
