package com.example.demo.repository.cmmnclcoderepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.CmmnClCode;
import com.example.demo.repository.CmmnClCodeRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
class A4_update {

	@Autowired
	CmmnClCodeRepository repository;

	@Test
	void test() {
		log.debug("test");

		// given
		String id = "99";

		// when
		CmmnClCode result = repository.findById(id).orElseGet(CmmnClCode::empty);

		log.debug("result: {}", result);
		log.debug("getClCode: {}", result.getClCode());
		log.debug("getClCodeNm: {}", result.getClCodeNm());
		log.debug("getLastUpdusrId: {}", result.getLastUpdusrId());
		log.debug("getLastUpdtPnttm: {}", result.getLastUpdtPnttm());

		String clCodeNm = "0000";
		String lastUpdusrId = "test 사용자명99 update";
		LocalDateTime lastUpdtPnttm = LocalDateTime.now();
		result.update(clCodeNm, lastUpdusrId, lastUpdtPnttm);

		// then
		assertEquals(result.getClCode(), id);
		assertEquals(result.getClCodeNm(), clCodeNm);
		assertEquals(result.getLastUpdusrId(), lastUpdusrId);
		assertEquals(result.getLastUpdtPnttm(), lastUpdtPnttm);

		log.debug("result: {}", result);
		log.debug("getClCode: {}", result.getClCode());
		log.debug("getClCodeNm: {}", result.getClCodeNm());
		log.debug("getLastUpdusrId: {}", result.getLastUpdusrId());
		log.debug("getLastUpdtPnttm: {}", result.getLastUpdtPnttm());
	}

}
