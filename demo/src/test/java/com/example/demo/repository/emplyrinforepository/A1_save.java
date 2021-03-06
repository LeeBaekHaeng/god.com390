package com.example.demo.repository.emplyrinforepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.EmplyrInfo;
import com.example.demo.repository.EmplyrInfoRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class A1_save {

	private final EmplyrInfoRepository repository;

	@Autowired
	public A1_save(EmplyrInfoRepository repository) {
		this.repository = repository;
	}

	@Test
	void test() {
		log.debug("test");

		// @formatter:off
		EmplyrInfo entity = EmplyrInfo.builder()
				.emplyrId("1")
				.areaNo("1234")
				.emplyrSttusCode("P")
//				.adres("test 주소")
//				.entrprsMiddleTelno("1234")
//				.applcntNm("test 신청인명")
//				.EmplyrInfoPasswordHint("test 기업회원비밀번호힌트")
//				.EmplyrInfoPasswordCnsr("test 기업회원비밀번호정답")
//				.entrprsEndTelno("1234")
//				.areaNo("1234")
//				.applcntEmailAdres("test 신청자이메일주소")
//				.esntlId("1")
				.build();
		// @formatter:on
		log.debug("entity: {}", entity);

		EmplyrInfo save = repository.save(entity);

		log.debug("save: {}", save);
		log.debug("getEmplyrId: {}", save.getEmplyrId());
		log.debug("getEsntlId: {}", save.getEsntlId());

		assertEquals(entity.getEmplyrId(), save.getEmplyrId());
		assertEquals(entity.getEsntlId(), save.getEsntlId());
	}

}
