package com.example.demo.repository.cmmncoderepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.CmmnCode;
import com.example.demo.repository.CmmnCodeRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class A1_save {

	@Autowired
	CmmnCodeRepository repository;

	@Test
	void test() {
		log.debug("test");

		// given
		LocalDateTime frstRegistPnttm = LocalDateTime.now();
		String frstRegisterId = "test 최초등록자ID";
		// @formatter:off
		CmmnCode entity = CmmnCode.builder()
				.codeId("GOD001")
				.codeIdNm("test 등록구분")
				.codeIdDc("test 게시판, 커뮤니티, 동호회 등록구분코드")
				.useAt("Y")
				.clCode("GOD")
				.frstRegistPnttm(frstRegistPnttm)
				.frstRegisterId(frstRegisterId)
				.lastUpdtPnttm(frstRegistPnttm)
				.lastUpdusrId(frstRegisterId)
				.build();
		// @formatter:on

		// when
		CmmnCode save = repository.save(entity);

		// then
		assertEquals(entity.getCodeId(), save.getCodeId());
		assertEquals(entity.getClCode(), save.getClCode());

		log.debug("save: {}", save);
		log.debug("getCodeId: {}", save.getCodeId());
		log.debug("getClCode: {}", save.getClCode());
	}

}
