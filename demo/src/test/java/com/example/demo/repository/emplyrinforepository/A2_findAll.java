package com.example.demo.repository.emplyrinforepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import com.example.demo.domain.EmplyrInfoSpecs;
import com.example.demo.entity.EmplyrInfo;
import com.example.demo.repository.EmplyrInfoRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class A2_findAll {

	private final EmplyrInfoRepository repository;
	private final EmplyrInfoTestData emplyrInfoTestData;

	@Autowired
	public A2_findAll(EmplyrInfoRepository repository, EmplyrInfoTestData emplyrInfoTestData) {
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

		// @formatter:off
		EmplyrInfo entity = EmplyrInfo.builder()
				.userNm("test")
				.build();
		// @formatter:on

		log.debug("entity: {}", entity);

		Specification<EmplyrInfo> spec = EmplyrInfoSpecs.where(entity);

		Sort sort = Sort.by("emplyrId").descending();
		Pageable pageable = PageRequest.of(0, 10, sort);

		Page<EmplyrInfo> page = repository.findAll(spec, pageable);

		log.debug("getTotalElements: {}", page.getTotalElements());

		page.get().forEach(action -> {
			log.debug("action: {}", action);
			log.debug("getEmplyrId: {}", action.getEmplyrId());
		});
	}

}
