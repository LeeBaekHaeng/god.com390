package com.example.demo.repository.emplyrinforepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.repository.EmplyrInfoRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j

@SpringBootTest

@Transactional(readOnly = true)
@Rollback(false)

class A5_delete {

	private final EmplyrInfoRepository repository;
	private final EmplyrInfoTestData emplyrInfoTestData;

	@Autowired
	public A5_delete(EmplyrInfoRepository repository, EmplyrInfoTestData emplyrInfoTestData) {
		this.repository = repository;
		this.emplyrInfoTestData = emplyrInfoTestData;
	}

	@BeforeEach
	@Transactional
	void setUp() throws Exception {
		emplyrInfoTestData.save();
	}

	@Test
	@Transactional
	void test() {
		log.debug("test");

		String id = "99";

		repository.deleteById(id);
	}

}
