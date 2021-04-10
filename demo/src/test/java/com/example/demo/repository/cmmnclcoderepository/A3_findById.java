package com.example.demo.repository.cmmnclcoderepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.CmmnClCode;
import com.example.demo.repository.CmmnClCodeRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
@ActiveProfiles({ "local-h2" })
@Transactional(readOnly = true)
class A3_findById {

	@Autowired
	CmmnClCodeRepository repository;

	@Test
	void test() {
		log.debug("test");

		// given
		String id = "GOD";
//		String id = "AAA";
//		String id = "AAB";

		// when
		CmmnClCode result = repository.findById(id).orElseGet(CmmnClCode::empty);

		// then
//		assertEquals(result.getClCode(), null);

		log.debug("result: {}", result);
		log.debug("getClCode: {}", result.getClCode());
//		log.debug("getCmmnCodes: {}", result.getCmmnCodes());
//		log.debug("getCodeId: {}", result.getCmmnCodes().get(0).getCodeId());
//		log.debug("getCmmnClCode: {}", result.getCmmnCodes().get(0).getCmmnClCode());
//		log.debug("getClCode: {}", result.getCmmnCodes().get(0).getCmmnClCode().getClCode());

		result.getCmmnCodes().forEach(action -> {
			log.debug("getCodeId: {}", action.getCodeId());
			log.debug("getCmmnClCode: {}", action.getCmmnClCode());
			log.debug("getClCode: {}", action.getCmmnClCode().getClCode());
		});
	}

}
