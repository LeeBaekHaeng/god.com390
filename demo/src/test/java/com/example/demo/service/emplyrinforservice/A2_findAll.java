package com.example.demo.service.emplyrinforservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.EmplyrInfoDto;
import com.example.demo.repository.emplyrinforepository.EmplyrInfoTestData;
import com.example.demo.service.EmplyrInfoService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j

@Transactional(readOnly = true)

class A2_findAll {

	@Autowired
	EmplyrInfoTestData testData;

	@Autowired
	EmplyrInfoService service;

	@BeforeEach
	@Transactional
	void setUp() throws Exception {
		testData.save();
	}

	@Test
	@Transactional
	void test() {
		log.debug("test");

		EmplyrInfoDto dto = new EmplyrInfoDto();
//		dto.setEmplyrId("");
//		dto.setOrgnztId("");
		dto.setUserNm("test 사용자명");

		Sort sort = Sort.by("emplyrId").descending();
		sort = sort.and(Sort.by("sbscrbDe").descending());
		Pageable pageable = PageRequest.of(0, 10, sort);

		Page<EmplyrInfoDto> page = service.findAll(dto, pageable);

		log.debug("getTotalElements: {}", page.getTotalElements());

		page.get().forEach(action -> {
			log.debug("action: {}", action);
			log.debug("getEmplyrId: {}", action.getEmplyrId());
		});
	}

}
