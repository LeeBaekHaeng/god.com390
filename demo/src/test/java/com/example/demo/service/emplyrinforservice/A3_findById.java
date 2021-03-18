package com.example.demo.service.emplyrinforservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.EmplyrInfoDto;
import com.example.demo.repository.emplyrinforepository.EmplyrInfoTestData;
import com.example.demo.service.EmplyrInfoService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class A3_findById {

	@Autowired
	EmplyrInfoTestData testData;

	@Autowired
	EmplyrInfoService service;

	@BeforeEach
	@Transactional
	void setUp() throws Exception {
		testData.save();
	}

	@Test
	void test() {
		log.debug("test");

		String id = "99";

		EmplyrInfoDto result = service.findById(id);

		log.debug("result: {}", result);
		log.debug("getEmplyrId: {}", result.getEmplyrId());

		assertEquals(result.getEmplyrId(), id);
	}

}
