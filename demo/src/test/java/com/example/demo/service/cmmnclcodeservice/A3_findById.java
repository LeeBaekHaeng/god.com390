package com.example.demo.service.cmmnclcodeservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.CmmnClCodeDto;
import com.example.demo.repository.cmmnclcoderepository.CmmnClCodeTestData;
import com.example.demo.service.CmmnClCodeService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
@Transactional
class A3_findById {

	@Autowired
	CmmnClCodeTestData testData;

	@Autowired
	CmmnClCodeService service;

	@BeforeEach
	void setUp() throws Exception {
		testData.saveAll();
	}

	@Test
	void test() {
		log.debug("test");

		// given
		String id = "A99";

		// when
		CmmnClCodeDto result = service.findById(id);

		// then
		assertEquals(result.getClCode(), id);

		log.debug("result: {}", result);
		log.debug("getClCode: {}", result.getClCode());
	}

}
