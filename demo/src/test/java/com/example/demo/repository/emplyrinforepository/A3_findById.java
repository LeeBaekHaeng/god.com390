package com.example.demo.repository.emplyrinforepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.EmplyrInfo;
import com.example.demo.repository.EmplyrInfoRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class A3_findById {

	private final EmplyrInfoRepository repository;
	private final EmplyrInfoTestData emplyrInfoTestData;

	@Autowired
	public A3_findById(EmplyrInfoRepository repository, EmplyrInfoTestData emplyrInfoTestData) {
		this.repository = repository;
		this.emplyrInfoTestData = emplyrInfoTestData;
	}

	@BeforeEach
	void setUp() throws Exception {
		emplyrInfoTestData.save();
	}

	@Test
	void test() {
		log.debug("test");

		String id = "99";

//		EmplyrInfo result = repository.findById(id).orElseGet(EmplyrInfo::new);
		EmplyrInfo result = repository.findById(id).orElseGet(EmplyrInfo::empty);

		log.debug("result: {}", result);
		log.debug("getEmplyrInfoId: {}", result.getEmplyrId());

		assertEquals(result.getEmplyrId(), id);
	}

}
