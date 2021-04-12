package com.example.demo.repository.cmmncoderepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.CmmnCode;
import com.example.demo.repository.CmmnCodeRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
//@ActiveProfiles({ "local-h2" })
@Transactional(readOnly = true)
class A3_findById {

	@Autowired
	CmmnCodeRepository repository;

	@Test
	void test() {
		log.debug("test");

		// given
		String id = "GOD";
//		String id = "AAA";
//		String id = "AAB";

		// when
		CmmnCode result = repository.findById(id).orElseGet(CmmnCode::empty);

		// then
//		assertEquals(result.getClCode(), null);

		log.debug("result: {}", result);
		log.debug("getCodeId: {}", result.getCodeId());

		log.debug("getCmmnClCode: {}", result.getCmmnClCode());
		if (result.getCmmnClCode() != null) {
			log.debug("getClCode: {}", result.getCmmnClCode().getClCode());
			log.debug("getClCodeNm: {}", result.getCmmnClCode().getClCodeNm());
		}
	}

}
