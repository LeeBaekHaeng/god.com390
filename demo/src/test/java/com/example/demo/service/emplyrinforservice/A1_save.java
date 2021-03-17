package com.example.demo.service.emplyrinforservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.EmplyrInfoDto;
import com.example.demo.service.EmplyrInfoService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class A1_save {

	@Autowired
	EmplyrInfoService service;

	@Test
	void test() {
		EmplyrInfoDto dto = new EmplyrInfoDto();

		EmplyrInfoDto save = service.save(dto);

		log.debug("save={}", save);
	}

}
