package com.example.demo.service.cmmnclcodeservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

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
//@Rollback(false)
class A4_update {

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
		// @formatter:off
		CmmnClCodeDto dto = CmmnClCodeDto.builder()
				.clCode("A99")
				.clCodeNm("test 분류코드명 수정")
				.lastUpdtPnttm(LocalDateTime.now())
				.lastUpdusrId("test 최종수정자ID 수정")
				.build();
		// @formatter:on

		// when
		CmmnClCodeDto update = service.update(dto);

		// then
		assertEquals(update.getClCode(), dto.getClCode());
		assertEquals(update.getClCodeNm(), dto.getClCodeNm());
		assertEquals(update.getLastUpdtPnttm(), dto.getLastUpdtPnttm());
		assertEquals(update.getLastUpdusrId(), dto.getLastUpdusrId());

		log.debug("update: {}", update);
		log.debug("getClCode: {}", update.getClCode());
		log.debug("getClCodeNm: {}", update.getClCodeNm());
		log.debug("getLastUpdtPnttm: {}", update.getLastUpdtPnttm());
		log.debug("getLastUpdusrId: {}", update.getLastUpdusrId());
	}

}
