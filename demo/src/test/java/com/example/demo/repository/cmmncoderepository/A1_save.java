package com.example.demo.repository.cmmncoderepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.CmmnClCode;
import com.example.demo.entity.CmmnCode;
import com.example.demo.repository.CmmnClCodeRepository;
import com.example.demo.repository.CmmnCodeRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
class A1_save {

	@Autowired
	CmmnClCodeRepository cmmnClCodeRepository;

	@Autowired
	CmmnCodeRepository repository;

	@Test
	void test() {
		log.debug("test");

		// given
		CmmnClCode cmmnClCode = CmmnClCode.builder().clCode("GOD").clCodeNm("test 갓").build();
		cmmnClCodeRepository.save(cmmnClCode);

		LocalDateTime frstRegistPnttm = LocalDateTime.now();
		String frstRegisterId = "test 최초등록자ID";
		// @formatter:off
		CmmnCode entity = CmmnCode.builder()
				.codeId("GOD001")
				.codeIdNm("test 등록구분")
				.codeIdDc("test 게시판, 커뮤니티, 동호회 등록구분코드")
				.useAt("Y")
//				.clCode("GOD")
				.cmmnClCode(cmmnClCode)
				.frstRegistPnttm(frstRegistPnttm)
				.frstRegisterId(frstRegisterId)
				.lastUpdtPnttm(frstRegistPnttm)
				.lastUpdusrId(frstRegisterId)
				.build();
		// @formatter:on

		// when
		CmmnCode save = repository.save(entity);
		CmmnCode find = repository.findById(save.getCodeId()).orElseGet(CmmnCode::empty);

		// then
		assertEquals(entity.getCodeId(), save.getCodeId());
//		assertEquals(entity.getClCode(), save.getClCode());
//		assertEquals(entity.getCmmnClCode(), save.getCmmnClCode());
//		assertEquals(entity.getCmmnClCode().getClCode(), save.getCmmnClCode().getClCode());
//		assertEquals(entity.getCmmnClCode().getClCodeNm(), save.getCmmnClCode().getClCodeNm());

		log.debug("save: {}", save);
		log.debug("getCodeId: {}", save.getCodeId());
//		log.debug("getClCode: {}", save.getClCode());
//		log.debug("getCmmnClCode: {}", save.getCmmnClCode());
//		log.debug("getClCode: {}", save.getCmmnClCode().getClCode());
//		log.debug("getClCodeNm: {}", save.getCmmnClCode().getClCodeNm());

		log.debug("find: {}", find);
//		log.debug("getCodeId: {}", find.getCodeId());
////		log.debug("getClCode: {}", find.getClCode());
//		log.debug("getCmmnClCode: {}", find.getCmmnClCode());
		log.debug("getClCode: {}", find.getCmmnClCode().getClCode());
//		log.debug("getClCodeNm: {}", find.getCmmnClCode().getClCodeNm());
	}

}
