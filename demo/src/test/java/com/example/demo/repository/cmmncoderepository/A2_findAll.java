package com.example.demo.repository.cmmncoderepository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.CmmnCode;
import com.example.demo.repository.CmmnCodeRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class A2_findAll {

	@Autowired
	CmmnCodeRepository repository;

	@Test
	void test() {
		log.debug("test");

		// given

		// when
		List<CmmnCode> results = repository.findAll();

		// then
		results.forEach(result -> {
			log.debug("getCmmnClCode={}", result.getCmmnClCode());
			log.debug("getClCode={}", result.getCmmnClCode().getClCode());
		});

		log.debug("results={}", results);
	}

}
