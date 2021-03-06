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
class A4_update {

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

		EmplyrInfoDto dto = new EmplyrInfoDto();
		dto.setEmplyrId("99");
		dto.setUserNm("test 사용자명 수정");

		EmplyrInfoDto update = service.update(dto);

		log.debug("update: {}", update);
		log.debug("getEmplyrId: {}", update.getEmplyrId());
		log.debug("getUserNm: {}", update.getUserNm());

		assertEquals(update.getEmplyrId(), dto.getEmplyrId());
		assertEquals(update.getUserNm(), dto.getUserNm());
	}

}
