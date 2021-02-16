package com.example.demo.repository.entrprsmberrepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import com.example.demo.entity.EntrprsMber;
import com.example.demo.repository.EntrprsMberRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class A2_findAll {

	private final EntrprsMberRepository repository;

	@Autowired
	public A2_findAll(EntrprsMberRepository repository) {
		this.repository = repository;
	}

	@BeforeEach
	void setUp() throws Exception {
		for (int i = 1; i < 100; i++) {
			String entrprsMberId = String.format("%020d", i);
		// @formatter:off
				EntrprsMber entity = EntrprsMber.builder()
						.entrprsMberId(entrprsMberId)
						.cmpnyNm("test 회사명" + i)
						.zip("123456")
						.adres("test 주소" + i)
						.entrprsMiddleTelno("1234")
						.applcntNm("test 신청인명" + i)
						.entrprsMberPasswordHint("test 기업회원비밀번호힌트" + i)
						.entrprsMberPasswordCnsr("test 기업회원비밀번호정답" + i)
						.entrprsEndTelno("1234")
						.areaNo("1234")
						.applcntEmailAdres("test 신청자이메일주소" + i)
						.esntlId(entrprsMberId)
						.build();
				// @formatter:on
			log.debug("entity: {}", entity);

			repository.save(entity);
		}
	}

	@Test
	void test() {
		log.debug("test");

		EntrprsMber entity = EntrprsMber.builder().build();

		log.debug("entity: {}", entity);

		Specification<EntrprsMber> spec = null;

		Sort sort = Sort.by("entrprsMberId").descending();
		Pageable pageable = PageRequest.of(0, 10, sort);

		Page<EntrprsMber> page = repository.findAll(spec, pageable);

		log.debug("getTotalElements: {}", page.getTotalElements());

		page.get().forEach(action -> {
			log.debug("action: {}", action);
			log.debug("getEntrprsMberId: {}", action.getEntrprsMberId());
		});
	}

}
