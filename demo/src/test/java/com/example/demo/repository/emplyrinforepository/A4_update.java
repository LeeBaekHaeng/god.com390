package com.example.demo.repository.emplyrinforepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.EmplyrInfo;
import com.example.demo.repository.EmplyrInfoRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
class A4_update {

	private final EmplyrInfoRepository repository;
	private final EmplyrInfoTestData emplyrInfoTestData;

	@Autowired
	public A4_update(EmplyrInfoRepository repository, EmplyrInfoTestData emplyrInfoTestData) {
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
		log.debug("getAreaNo: {}", result.getAreaNo());
		log.debug("getUserNm: {}", result.getUserNm());

		String areaNo = "0000";
		String userNm = "test 사용자명99 update";
		result.update(areaNo, userNm);

		log.debug("getAreaNo: {}", result.getAreaNo());
		log.debug("getUserNm: {}", result.getUserNm());

		assertEquals(result.getEmplyrId(), id);
		assertEquals(areaNo, result.getAreaNo());
		assertEquals(userNm, result.getUserNm());
	}

	@Test
	void test2() {
		log.debug("test2");

		String id = "99-";

//		EmplyrInfo result = repository.findById(id).orElseGet(EmplyrInfo::new);
		EmplyrInfo result = repository.findById(id).orElseGet(EmplyrInfo::empty);

		log.debug("result: {}", result);
		log.debug("getEmplyrInfoId: {}", result.getEmplyrId());
		log.debug("getAreaNo: {}", result.getAreaNo());
		log.debug("getUserNm: {}", result.getUserNm());
	}

}
