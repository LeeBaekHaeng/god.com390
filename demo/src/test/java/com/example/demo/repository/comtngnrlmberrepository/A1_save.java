package com.example.demo.repository.comtngnrlmberrepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.ComTnGnrlMber;
import com.example.demo.repository.ComTnGnrlMberRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
//@RequiredArgsConstructor
class A1_save {

	private final ComTnGnrlMberRepository repository;

	@Autowired
	public A1_save(ComTnGnrlMberRepository repository) {
		this.repository = repository;
	}

	@Test
	void test() {
		log.debug("test");

		ComTnGnrlMber entity = new ComTnGnrlMber();
		entity.setMberId("1");
		entity.setPassword("test 비밀번호");
		entity.setPasswordHint("test 비밀번호힌트");
		entity.setPasswordCnsr("test 비밀번호정답");
		entity.setIhidnum("test 주민등록번호");
		entity.setMberNm("test 회원명");
		entity.setZip("123456");
		entity.setAdres("test 주소");
		entity.setAreaNo("1234");

//		entity.setMberSttus("test 회원상태");
//		COM013
//		entity.setMberSttus("A"); // 회원 가입 신청 상태
//		entity.setMberSttus("P"); // 회원 가입 삭제 상태
		entity.setMberSttus("D"); // 회원 가입 신청 상태

		entity.setDetailAdres("test 상세주소");
		entity.setEndTelno("3456");
		entity.setMbtlnum("test 이동전화번호");
		entity.setGroupId("GROUP_00000000000000");
		entity.setMberFxnum("test 회원팩스번호");
		entity.setMberEmailAdres("test 회원이메일주소");
		entity.setMiddleTelno("2345");
		entity.setSbscrbDe(LocalDateTime.now());

		entity.setSexdstnCode("M"); // 남자
//		entity.setSexdstnCode("F"); // 여자

		entity.setEsntlId("test 고유ID");
//		entity.setEsntlId(UUID.randomUUID().toString());

//		entity.setLockAt("Y");
		entity.setLockAt("N");

		entity.setLockCnt(0L);
		entity.setLockLastPnttm(LocalDateTime.now());

		log.debug("entity: {}", entity);

		ComTnGnrlMber save = repository.save(entity);

		log.debug("save: {}", save);
		log.debug("getMberId: {}", save.getMberId());
		log.debug("getPassword: {}", save.getPassword());
		log.debug("getPasswordHint: {}", save.getPasswordHint());
		log.debug("getPasswordCnsr: {}", save.getPasswordCnsr());
		log.debug("getIhidnum: {}", save.getIhidnum());
		log.debug("getMberNm: {}", save.getMberNm());
		log.debug("getZip: {}", save.getZip());
		log.debug("getAdres: {}", save.getAdres());
		log.debug("getAreaNo: {}", save.getAreaNo());
		log.debug("getMberSttus: {}", save.getMberSttus());
		log.debug("getDetailAdres: {}", save.getDetailAdres());
		log.debug("getEndTelno: {}", save.getEndTelno());
		log.debug("getMbtlnum: {}", save.getMbtlnum());
		log.debug("getGroupId: {}", save.getGroupId());
		log.debug("getMberFxnum: {}", save.getMberFxnum());
		log.debug("getMberEmailAdres: {}", save.getMberEmailAdres());
		log.debug("getMiddleTelno: {}", save.getMiddleTelno());
		log.debug("getSbscrbDe: {}", save.getSbscrbDe());
		log.debug("getSexdstnCode: {}", save.getSexdstnCode());
		log.debug("getEsntlId: {}", save.getEsntlId());
		log.debug("getLockAt: {}", save.getLockAt());
		log.debug("getLockCnt: {}", save.getLockCnt());
		log.debug("getLockLastPnttm: {}", save.getLockLastPnttm());

		assertEquals(entity.getMberId(), save.getMberId());
		assertEquals(entity.getPassword(), save.getPassword());
		assertEquals(entity.getPasswordHint(), save.getPasswordHint());
		assertEquals(entity.getPasswordCnsr(), save.getPasswordCnsr());
		assertEquals(entity.getIhidnum(), save.getIhidnum());
		assertEquals(entity.getMberNm(), save.getMberNm());
		assertEquals(entity.getZip(), save.getZip());
		assertEquals(entity.getAdres(), save.getAdres());
		assertEquals(entity.getAreaNo(), save.getAreaNo());
		assertEquals(entity.getMberSttus(), save.getMberSttus());
		assertEquals(entity.getDetailAdres(), save.getDetailAdres());
		assertEquals(entity.getEndTelno(), save.getEndTelno());
		assertEquals(entity.getMbtlnum(), save.getMbtlnum());
		assertEquals(entity.getGroupId(), save.getGroupId());
		assertEquals(entity.getMberFxnum(), save.getMberFxnum());
		assertEquals(entity.getMberEmailAdres(), save.getMberEmailAdres());
		assertEquals(entity.getMiddleTelno(), save.getMiddleTelno());
		assertEquals(entity.getSbscrbDe(), save.getSbscrbDe());
		assertEquals(entity.getSexdstnCode(), save.getSexdstnCode());
		assertEquals(entity.getEsntlId(), save.getEsntlId());
		assertEquals(entity.getLockAt(), save.getLockAt());
		assertEquals(entity.getLockCnt(), save.getLockCnt());
		assertEquals(entity.getLockLastPnttm(), save.getLockLastPnttm());
	}

}
