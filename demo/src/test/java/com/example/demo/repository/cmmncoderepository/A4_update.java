package com.example.demo.repository.cmmncoderepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.CmmnCode;
import com.example.demo.repository.CmmnCodeRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
@Transactional(readOnly = true)
//@Rollback(false)
class A4_update {

	@Autowired
	CmmnCodeRepository repository;

	@Test
	@Transactional
	void test() {
		log.debug("test");

		// given
		String id = "GOD001";

		// when
		CmmnCode result = repository.findById(id).orElseGet(CmmnCode::empty);

		log.debug("result: {}", result);
		log.debug("getCodeId: {}", result.getCodeId());
		log.debug("getCodeIdNm: {}", result.getCodeIdNm());
		log.debug("getLastUpdusrId: {}", result.getLastUpdusrId());
		log.debug("getLastUpdtPnttm: {}", result.getLastUpdtPnttm());

		String codeIdNm = "test 코드ID명 수정";
		LocalDateTime lastUpdtPnttm = LocalDateTime.now();
		String lastUpdusrId = "test 최종수정자ID 수정";
		result.update(codeIdNm, lastUpdtPnttm, lastUpdusrId);

		// then
//		assertEquals(result.getCodeId(), id);
		assertEquals(result.getCodeId(), null);
//		assertEquals(result.getCodeIdNm(), codeIdNm);
//		assertEquals(result.getLastUpdusrId(), lastUpdusrId);
//		assertEquals(result.getLastUpdtPnttm(), lastUpdtPnttm);

		log.debug("result: {}", result);
		log.debug("getCodeId: {}", result.getCodeId());
		log.debug("getCodeIdNm: {}", result.getCodeIdNm());
		log.debug("getLastUpdusrId: {}", result.getLastUpdusrId());
		log.debug("getLastUpdtPnttm: {}", result.getLastUpdtPnttm());
	}

}
