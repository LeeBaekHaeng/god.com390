package com.example.demo.repository.emplyrinforepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.EmplyrInfo;
import com.example.demo.repository.EmplyrInfoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmplyrInfoTestData {

	private final EmplyrInfoRepository repository;

	public void save() {
		List<EmplyrInfo> entities = new ArrayList<>();

		for (int i = 1; i < 100; i++) {
			String emplyrId = String.valueOf(i);
			// @formatter:off
			EmplyrInfo entity = EmplyrInfo.builder()
					.emplyrId(emplyrId)
					.areaNo("1234")
					.emplyrSttusCode("P")
					.esntlId(emplyrId)
					.houseAdres("test 주택주소" + emplyrId)
					.houseEndTelno("1234")
					.houseMiddleTelno("1234")
					.password("rhdxhd12")
					.passwordCnsr("test 비밀번호정답" + emplyrId)
					.passwordHint("test 비밀번호힌트" + emplyrId)
					.userNm("test 사용자명" + emplyrId)
					.zip("123456")
					.build();
			// @formatter:on
			entities.add(entity);
		}

		repository.saveAll(entities);
	}

}
