package com.example.demo.repository.entrprsmberrepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.EntrprsMber;
import com.example.demo.repository.EntrprsMberRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
//@RequiredArgsConstructor
class A1_save {

	private final EntrprsMberRepository repository;

	@Autowired
	public A1_save(EntrprsMberRepository repository) {
		this.repository = repository;
	}

	@Test
	void test() {
		log.debug("test");

		// @formatter:off
		EntrprsMber entity = EntrprsMber.builder()
				.entrprsMberId("1")
				.cmpnyNm("test 회사명")
				.zip("123456")
				.adres("test 주소")
				.entrprsMiddleTelno("1234")
				.applcntNm("test 신청인명")
				.entrprsMberPasswordHint("test 기업회원비밀번호힌트")
				.entrprsMberPasswordCnsr("test 기업회원비밀번호정답")
				.entrprsEndTelno("1234")
				.areaNo("1234")
				.applcntEmailAdres("test 신청자이메일주소")
				.esntlId("1")
				.build();
		// @formatter:on
		log.debug("entity: {}", entity);

		EntrprsMber save = repository.save(entity);

		log.debug("save: {}", save);
		log.debug("getEntrprsMberId: {}", save.getEntrprsMberId());
		log.debug("getCmpnyNm: {}", save.getCmpnyNm());
		log.debug("getZip: {}", save.getZip());
		log.debug("getAdres: {}", save.getAdres());
		log.debug("getEntrprsMiddleTelno: {}", save.getEntrprsMiddleTelno());
		log.debug("getApplcntNm: {}", save.getApplcntNm());
		log.debug("getEntrprsMberPasswordHint: {}", save.getEntrprsMberPasswordHint());
		log.debug("getEntrprsMberPasswordCnsr: {}", save.getEntrprsMberPasswordCnsr());
		log.debug("getEntrprsEndTelno: {}", save.getEntrprsEndTelno());
		log.debug("getAreaNo: {}", save.getAreaNo());
		log.debug("getApplcntEmailAdres: {}", save.getApplcntEmailAdres());
		log.debug("getEsntlId: {}", save.getEsntlId());

		assertEquals(entity.getEntrprsMberId(), save.getEntrprsMberId());
		assertEquals(entity.getCmpnyNm(), save.getCmpnyNm());
		assertEquals(entity.getZip(), save.getZip());
		assertEquals(entity.getAdres(), save.getAdres());
		assertEquals(entity.getEntrprsMiddleTelno(), save.getEntrprsMiddleTelno());
		assertEquals(entity.getApplcntNm(), save.getApplcntNm());
		assertEquals(entity.getEntrprsMberPasswordHint(), save.getEntrprsMberPasswordHint());
		assertEquals(entity.getEntrprsMberPasswordCnsr(), save.getEntrprsMberPasswordCnsr());
		assertEquals(entity.getEntrprsEndTelno(), save.getEntrprsEndTelno());
		assertEquals(entity.getAreaNo(), save.getAreaNo());
		assertEquals(entity.getApplcntEmailAdres(), save.getApplcntEmailAdres());
		assertEquals(entity.getEsntlId(), save.getEsntlId());
	}

}
