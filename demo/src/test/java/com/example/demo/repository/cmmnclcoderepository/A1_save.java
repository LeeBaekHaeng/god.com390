package com.example.demo.repository.cmmnclcoderepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.CmmnClCode;
import com.example.demo.repository.CmmnClCodeRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class A1_save {

	@Autowired
	CmmnClCodeRepository repository;

	@Test
	void test() {
		log.debug("test");

		// given
		LocalDateTime frstRegistPnttm = LocalDateTime.now();
		String frstRegisterId = "test 최초등록자ID";
// @formatter:off
		CmmnClCode entity = CmmnClCode.builder()
				.clCode("GOD")
				.clCodeNm("test 분류코드명")
				.clCodeDc("test 분류코드설명")
				.useAt("Y")
				.frstRegistPnttm(frstRegistPnttm)
				.frstRegisterId(frstRegisterId)
				.lastUpdtPnttm(frstRegistPnttm)
				.lastUpdusrId(frstRegisterId)
				.build();
// @formatter:on

		// when
		CmmnClCode save = repository.save(entity);

		// then
		assertEquals(entity.getClCode(), save.getClCode());

		log.debug("save: {}", save);
		log.debug("getClCode: {}", save.getClCode());
	}

}
