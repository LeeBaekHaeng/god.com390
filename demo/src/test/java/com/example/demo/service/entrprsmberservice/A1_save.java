package com.example.demo.service.entrprsmberservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.EntrprsMberDto;
import com.example.demo.service.EntrprsMberService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
//@RequiredArgsConstructor
class A1_save {

	private final EntrprsMberService service;

	@Autowired
	public A1_save(EntrprsMberService service) {
		this.service = service;
	}

	@Test
	void test() {
		log.debug("test");

		// @formatter:off
		EntrprsMberDto dto = EntrprsMberDto.builder()
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
		log.debug("dto: {}", dto);

		EntrprsMberDto save = service.save(dto);

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

		assertEquals(dto.getEntrprsMberId(), save.getEntrprsMberId());
		assertEquals(dto.getCmpnyNm(), save.getCmpnyNm());
		assertEquals(dto.getZip(), save.getZip());
		assertEquals(dto.getAdres(), save.getAdres());
		assertEquals(dto.getEntrprsMiddleTelno(), save.getEntrprsMiddleTelno());
		assertEquals(dto.getApplcntNm(), save.getApplcntNm());
		assertEquals(dto.getEntrprsMberPasswordHint(), save.getEntrprsMberPasswordHint());
		assertEquals(dto.getEntrprsMberPasswordCnsr(), save.getEntrprsMberPasswordCnsr());
		assertEquals(dto.getEntrprsEndTelno(), save.getEntrprsEndTelno());
		assertEquals(dto.getAreaNo(), save.getAreaNo());
		assertEquals(dto.getApplcntEmailAdres(), save.getApplcntEmailAdres());
		assertEquals(dto.getEsntlId(), save.getEsntlId());
	}

}
