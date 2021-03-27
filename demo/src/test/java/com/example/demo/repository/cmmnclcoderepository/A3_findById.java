package com.example.demo.repository.cmmnclcoderepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.CmmnClCode;
import com.example.demo.repository.CmmnClCodeRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class A3_findById {

	@Autowired
	CmmnClCodeRepository repository;

	@Test
	void test() {
		log.debug("test");

		String id = "1";

		CmmnClCode result = repository.findById(id).orElseGet(CmmnClCode::empty);

		log.debug("result: {}", result);
		log.debug("getClCode: {}", result.getClCode());

		assertEquals(result.getClCode(), null);
	}

}
