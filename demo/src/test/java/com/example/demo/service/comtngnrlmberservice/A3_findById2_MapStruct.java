package com.example.demo.service.comtngnrlmberservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.ComTnGnrlMberDTO;
import com.example.demo.log.ComTnGnrlMberDTOLog;
import com.example.demo.service.ComTnGnrlMberService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class A3_findById2_MapStruct {

	private final ComTnGnrlMberService service;

	@Autowired
	public A3_findById2_MapStruct(ComTnGnrlMberService service) {
		this.service = service;
	}

	@Test
	void test() {
		log.debug("test");

		service.saveAll();

		String id = "1";

		ComTnGnrlMberDTO result = service.findById2(id);

		log.debug("result: {}", result);
		log.debug("getMberId: {}", result.getMberId());

		ComTnGnrlMberDTOLog.debug(result);

		assertEquals(result.getMberId(), id);
	}

}
