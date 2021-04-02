package com.example.demo.repository.cmmnclcoderepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.CmmnClCode;
import com.example.demo.repository.CmmnClCodeRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j

@SpringBootTest

@Transactional

class A5_delete {

	@Autowired
	CmmnClCodeTestData testData;

	@Autowired
	CmmnClCodeRepository repository;

	@BeforeEach
	void setUp() throws Exception {
		testData.saveAll();
	}

	@Test
	void test() {
		log.debug("test");

		// given
		String id = "A99";

		// when
		repository.deleteById(id);

//		CmmnClCode one = repository.getOne(id);
		CmmnClCode one = repository.findById(id).orElseGet(CmmnClCode::empty);

		// then
		assertEquals(one.getClCode(), null);

		log.debug("one={}", one);
		log.debug("getClCode={}", one.getClCode());
	}

}
