package com.example.demo.repository.cmmncoderepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.CmmnClCode;
import com.example.demo.entity.CmmnCode;
import com.example.demo.repository.CmmnClCodeRepository;
import com.example.demo.repository.CmmnCodeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CmmnCodeTestData {

	private final CmmnClCodeRepository cmmnClCodeRepository;
	private final CmmnCodeRepository repository;

	@Transactional
	public void saveAll() {
		CmmnClCode cmmnClCode = CmmnClCode.builder().clCode("GOD").clCodeNm("test 갓").build();
		cmmnClCodeRepository.save(cmmnClCode);

		List<CmmnCode> entities = new ArrayList<>();

		for (int i = 1; i < 100; i++) {
			String iString = String.format("%03d", i);
			LocalDateTime frstRegistPnttm = LocalDateTime.now();
			String frstRegisterId = "test 최초등록자ID";
			// @formatter:off
			CmmnCode entity = CmmnCode.builder()
					.codeId("GOD" + iString)
					.codeIdNm("test 등록구분" + iString)
					.codeIdDc("test 게시판, 커뮤니티, 동호회 등록구분코드" + iString)
					.useAt("Y")
//					.clCode("GOD")
					.cmmnClCode(cmmnClCode)
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
