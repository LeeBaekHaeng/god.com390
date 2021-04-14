package com.example.demo.repository.cmmncoderepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
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
class A5_delete {

	@Autowired
	CmmnCodeTestData testData;

	@Autowired
	CmmnCodeRepository repository;

	@BeforeEach
	void setUp() throws Exception {
		testData.saveAll();
	}

	@Test
	@Transactional
	void test() {
		log.debug("test");

		// given
		String id = "GOD001";

		// when
		repository.deleteById(id);

		CmmnCode find = repository.findById(id).orElseGet(CmmnCode::empty);

		// then
		assertEquals(find.getCodeId(), null);

		log.debug("find={}", find);
		log.debug("getCodeId={}", find.getCodeId());
	}

}
