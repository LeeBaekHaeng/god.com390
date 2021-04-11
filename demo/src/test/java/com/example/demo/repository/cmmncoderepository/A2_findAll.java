package com.example.demo.repository.cmmncoderepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.CmmnCodeSpecs;
import com.example.demo.entity.CmmnCode;
import com.example.demo.repository.CmmnCodeRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
@Transactional(readOnly = true)
class A2_findAll {

	@Autowired
	CmmnCodeRepository repository;

	@Test
	void test() {
		log.debug("test");

		// given
		CmmnCode entity = CmmnCode.builder().codeId("GOD001").build();

		Specification<CmmnCode> spec = CmmnCodeSpecs.where(entity);

		Sort sort = Sort.by("frstRegistPnttm").descending();
		Pageable pageable = PageRequest.of(0, 10, sort);

		// when
		Page<CmmnCode> page = repository.findAll(spec, pageable);

		// then
		assertEquals(page.getTotalElements(), 0);

		log.debug("getTotalElements: {}", page.getTotalElements());

		page.get().forEach(action -> {
			log.debug("action: {}", action);
			log.debug("getCodeId: {}", action.getCodeId());
		});
	}

}
