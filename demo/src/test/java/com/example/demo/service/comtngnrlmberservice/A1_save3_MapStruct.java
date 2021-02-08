package com.example.demo.service.comtngnrlmberservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.ComTnGnrlMberDTO;
import com.example.demo.service.ComTnGnrlMberService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class A1_save3_MapStruct {

	private final ComTnGnrlMberService service;

	@Autowired
	public A1_save3_MapStruct(ComTnGnrlMberService repository) {
		this.service = repository;
	}

	@Test
	void test() {
		log.debug("test");

		// @formatter:off
		ComTnGnrlMberDTO dto = ComTnGnrlMberDTO.builder()

				.mberId("1").password("test 비밀번호").passwordHint("test 비밀번호힌트").passwordCnsr("test 비밀번호정답")
				.ihidnum("test 주민등록번호").mberNm("test 회원명").zip("123456").adres("test 주소").areaNo("1234")

//				.mberSttus("test 회원상태");
//				COM013
//				.mberSttus("A") // 회원 가입 신청 상태
//				.mberSttus("P") // 회원 가입 삭제 상태
				.mberSttus("D") // 회원 가입 신청 상태

				.detailAdres("test 상세주소").endTelno("3456").mbtlnum("test 이동전화번호").groupId("GROUP_00000000000000")
				.mberFxnum("test 회원팩스번호").mberEmailAdres("test 회원이메일주소").middleTelno("2345")
				.sbscrbDe(LocalDateTime.now())

				.sexdstnCode("M") // 남자
//				.sexdstnCode("F") // 여자

				.esntlId("test 고유ID")
//				.esntlId(UUID.randomUUID().toString())

//				.LockAt("Y")
				.lockAt("N")

				.lockCnt(0L).lockLastPnttm(LocalDateTime.now())

				.build();
		// @formatter:on

//		ComTnGnrlMberDTO dto = new ComTnGnrlMberDTO();
//		dto.setMberId("1");
//		dto.setPassword("test 비밀번호");
//		dto.setPasswordHint("test 비밀번호힌트");
//		dto.setPasswordCnsr("test 비밀번호정답");
//		dto.setIhidnum("test 주민등록번호");
//		dto.setMberNm("test 회원명");
//		dto.setZip("123456");
//		dto.setAdres("test 주소");
//		dto.setAreaNo("1234");
//
////		entity.setMberSttus("test 회원상태");
////		COM013
////		entity.setMberSttus("A"); // 회원 가입 신청 상태
////		entity.setMberSttus("P"); // 회원 가입 삭제 상태
//		dto.setMberSttus("D"); // 회원 가입 신청 상태
//
//		dto.setDetailAdres("test 상세주소");
//		dto.setEndTelno("3456");
//		dto.setMbtlnum("test 이동전화번호");
//		dto.setGroupId("GROUP_00000000000000");
//		dto.setMberFxnum("test 회원팩스번호");
//		dto.setMberEmailAdres("test 회원이메일주소");
//		dto.setMiddleTelno("2345");
//		dto.setSbscrbDe(LocalDateTime.now());
//
//		dto.setSexdstnCode("M"); // 남자
////		entity.setSexdstnCode("F"); // 여자
//
//		dto.setEsntlId("test 고유ID");
////		entity.setEsntlId(UUID.randomUUID().toString());
//
////		entity.setLockAt("Y");
//		dto.setLockAt("N");
//
//		dto.setLockCnt(0L);
//		dto.setLockLastPnttm(LocalDateTime.now());

		log.debug("dto: {}", dto);

		ComTnGnrlMberDTO save = service.save3(dto);

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

		assertEquals(dto.getMberId(), save.getMberId());
		assertEquals(dto.getPassword(), save.getPassword());
		assertEquals(dto.getPasswordHint(), save.getPasswordHint());
		assertEquals(dto.getPasswordCnsr(), save.getPasswordCnsr());
		assertEquals(dto.getIhidnum(), save.getIhidnum());
		assertEquals(dto.getMberNm(), save.getMberNm());
		assertEquals(dto.getZip(), save.getZip());
		assertEquals(dto.getAdres(), save.getAdres());
		assertEquals(dto.getAreaNo(), save.getAreaNo());
		assertEquals(dto.getMberSttus(), save.getMberSttus());
		assertEquals(dto.getDetailAdres(), save.getDetailAdres());
		assertEquals(dto.getEndTelno(), save.getEndTelno());
		assertEquals(dto.getMbtlnum(), save.getMbtlnum());
		assertEquals(dto.getGroupId(), save.getGroupId());
		assertEquals(dto.getMberFxnum(), save.getMberFxnum());
		assertEquals(dto.getMberEmailAdres(), save.getMberEmailAdres());
		assertEquals(dto.getMiddleTelno(), save.getMiddleTelno());
		assertEquals(dto.getSbscrbDe(), save.getSbscrbDe());
		assertEquals(dto.getSexdstnCode(), save.getSexdstnCode());
		assertEquals(dto.getEsntlId(), save.getEsntlId());
		assertEquals(dto.getLockAt(), save.getLockAt());
		assertEquals(dto.getLockCnt(), save.getLockCnt());
		assertEquals(dto.getLockLastPnttm(), save.getLockLastPnttm());
	}

}
