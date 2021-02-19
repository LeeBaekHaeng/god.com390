package com.example.demo.repository.entrprsmberrepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.EntrprsMber;
import com.example.demo.repository.EntrprsMberRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class A5_delete {

	private final EntrprsMberRepository repository;

	@Autowired
	public A5_delete(EntrprsMberRepository repository) {
		this.repository = repository;
	}

	@BeforeEach
	void setUp() throws Exception {
		List<EntrprsMber> entities = new ArrayList<>();

		for (int i = 1; i < 2; i++) {
			String entrprsMberId = String.format("%020d", i);
			// @formatter:off
			EntrprsMber entity = EntrprsMber.builder().entrprsMberId(entrprsMberId).cmpnyNm("test 회사명" + i)
					.zip("123456").adres("test 주소" + i).entrprsMiddleTelno("1234").applcntNm("test 신청인명" + i)
					.entrprsMberPasswordHint("test 기업회원비밀번호힌트" + i).entrprsMberPasswordCnsr("test 기업회원비밀번호정답" + i)
					.entrprsEndTelno("1234").areaNo("1234").applcntEmailAdres("test 신청자이메일주소" + i)
					.esntlId(entrprsMberId).build();
			// @formatter:on
			log.debug("entity: {}", entity);
			log.debug("getEntrprsMberId: {}", entity.getEntrprsMberId());
			log.debug("getCmpnyNm: {}", entity.getCmpnyNm());

			entities.add(entity);
		}

		repository.saveAll(entities);
//		repository.flush();
	}

	@Test
	void test() {
		log.debug("test");

		String id = "00000000000000000001";
//		String id = "00000000000000000099";

		repository.deleteById(id);

		EntrprsMber result = repository.findById(id).orElse(new EntrprsMber());
		log.debug("result: {}", result);
		log.debug("getEntrprsMberId: {}", result.getEntrprsMberId());

		assertEquals(result.getEntrprsMberId(), null);
	}

}
