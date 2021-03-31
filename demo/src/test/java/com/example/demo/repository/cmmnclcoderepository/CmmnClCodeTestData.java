package com.example.demo.repository.cmmnclcoderepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.CmmnClCode;
import com.example.demo.repository.CmmnClCodeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
//@Transactional(readOnly = true)
public class CmmnClCodeTestData {

	private final CmmnClCodeRepository repository;

//	@Transactional
	public void saveAll() {
		List<CmmnClCode> entities = new ArrayList<>();

		LocalDateTime frstRegistPnttm = LocalDateTime.now();
		String frstRegisterId = "test 최초등록자ID";

		for (int i = 1; i < 100; i++) {
			String clCode = String.format("%02d", i);
			// @formatter:off
			CmmnClCode entity = CmmnClCode.builder()
					.clCode("A" + clCode)
					.clCodeNm("test 분류코드명" + i)
					.clCodeDc("test 분류코드설명" + i)
					.useAt("Y")
					.frstRegistPnttm(frstRegistPnttm)
					.frstRegisterId(frstRegisterId)
					.lastUpdtPnttm(frstRegistPnttm)
					.lastUpdusrId(frstRegisterId)
					.build();
			// @formatter:on
			entities.add(entity);
		}

		repository.saveAll(entities);
	}

}
