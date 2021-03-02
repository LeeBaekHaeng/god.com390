package com.example.demo.service.entrprsmberservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.EntrprsMberDto;
import com.example.demo.entity.EntrprsMber;
import com.example.demo.repository.EntrprsMberRepository;
import com.example.demo.service.EntrprsMberService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class A5_delete {

	private final EntrprsMberService service;
	private final EntrprsMberRepository repository;

	@Autowired
	public A5_delete(EntrprsMberService service, EntrprsMberRepository repository) {
		this.service = service;
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

		EntrprsMberDto dto = new EntrprsMberDto();
		dto.setEntrprsMberId("00000000000000000099");

		EntrprsMberDto result = findById(dto.getEntrprsMberId());
		assertEquals(result.getEntrprsMberId(), dto.getEntrprsMberId());

		service.deleteById(dto.getEntrprsMberId());

		result = findById(dto.getEntrprsMberId());
		assertEquals(result.getEntrprsMberId(), null);
	}

	private EntrprsMberDto findById(String id) {
		EntrprsMberDto result = service.findById(id);
		log.debug("result: {}", result);
		log.debug("getMberId: {}", result.getEntrprsMberId());
		log.debug("getCmpnyNm: {}", result.getCmpnyNm());
		return result;
	}

}
