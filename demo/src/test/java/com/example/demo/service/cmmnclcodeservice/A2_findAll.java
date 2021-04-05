package com.example.demo.service.cmmnclcodeservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.CmmnClCodeDto;
import com.example.demo.repository.cmmnclcoderepository.CmmnClCodeTestData;
import com.example.demo.service.CmmnClCodeService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j

@Transactional

class A2_findAll {

	@Autowired
	CmmnClCodeTestData testData;

	@Autowired
	CmmnClCodeService service;

	@BeforeEach
	void setUp() throws Exception {
		testData.saveAll();
	}

	@Test
	void test() {
		log.debug("test");

		// given
		// @formatter:off
		CmmnClCodeDto dto = CmmnClCodeDto.builder()
				.clCode("A99")
				.build();
		// @formatter:on

		Sort sort = Sort.by("frstRegistPnttm").descending();
		Pageable pageable = PageRequest.of(0, 10, sort);

		// when
		Page<CmmnClCodeDto> page = service.findAll(dto, pageable);

		// then
		assertEquals(page.getContent().get(0).getClCode(), dto.getClCode());
		assertEquals(page.getTotalElements(), 1);

		log.debug("getTotalElements: {}", page.getTotalElements());

		page.get().forEach(action -> {
			log.debug("action: {}", action);
			log.debug("getClCode: {}", action.getClCode());
		});
	}

}
