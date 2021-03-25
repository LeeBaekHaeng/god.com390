package com.example.demo.repository.cmmnclcoderepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import com.example.demo.domain.CmmnClCodeSpecs;
import com.example.demo.entity.CmmnClCode;
import com.example.demo.repository.CmmnClCodeRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class A2_findAll {

	@Autowired
	CmmnClCodeRepository repository;

	@Test
	void test() {
		log.debug("test");

		// given
		// @formatter:off
		CmmnClCode entity = CmmnClCode.builder()
				.clCode("test 분류코드")
				.clCodeNm("test 분류코드명")
				.build();
		// @formatter:on

		log.debug("entity: {}", entity);

		// findAll
		Specification<CmmnClCode> spec = CmmnClCodeSpecs.where(entity);

		Sort sort = Sort.by("frstRegistPnttm").descending();
		sort = sort.and(Sort.by("clCode").descending());
		Pageable pageable = PageRequest.of(0, 10, sort);

		// when
		Page<CmmnClCode> page = repository.findAll(spec, pageable);

		// then
		log.debug("getTotalElements: {}", page.getTotalElements());

		page.get().forEach(action -> {
			log.debug("action: {}", action);
			log.debug("getClCode: {}", action.getClCode());
		});
	}

}
