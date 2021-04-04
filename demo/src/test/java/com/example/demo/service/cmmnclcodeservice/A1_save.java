package com.example.demo.service.cmmnclcodeservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.CmmnClCodeDto;
import com.example.demo.service.CmmnClCodeService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class A1_save {

	@Autowired
	CmmnClCodeService service;

	@Test
	void test() {
		// given
		LocalDateTime frstRegistPnttm = LocalDateTime.now();
		String frstRegisterId = "test 최초등록자ID";
		// @formatter:off
		CmmnClCodeDto dto = CmmnClCodeDto.builder()
				.clCode("GOD")
				.clCodeNm("test 분류코드명")
				.clCodeDc("test 분류코드설명")
				.useAt("Y")
				.frstRegistPnttm(frstRegistPnttm)
				.frstRegisterId(frstRegisterId)
				.lastUpdtPnttm(frstRegistPnttm)
				.lastUpdusrId(frstRegisterId)
				.build();
		// @formatter:on

		// when
		CmmnClCodeDto save = service.save(dto);

		// then
		assertEquals(save.getClCode(), dto.getClCode());

		log.debug("save={}", save);
		log.debug("getClCode={}", save.getClCode());

		log.debug("dto={}", dto);
		log.debug("getClCode={}", dto.getClCode());
	}

}
