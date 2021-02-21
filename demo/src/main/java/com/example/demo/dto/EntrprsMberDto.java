package com.example.demo.dto;

import java.time.LocalDateTime;

import com.example.demo.entity.EntrprsMber;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor

@Builder
public class EntrprsMberDto {

	private String entrprsMberId;

	private String entrprsSeCode;

	private String bizrno;

	private String jurirno;

	private String cmpnyNm;

	private String cxfc;

	private String zip;

	private String adres;

	private String entrprsMiddleTelno;

	private String fxnum;

	private String indutyCode;

	private String applcntNm;

	private String applcntIhidnum;

	private LocalDateTime sbscrbDe;

	private String entrprsMberSttus;

	private String entrprsMberPassword;

	private String entrprsMberPasswordHint;

	private String entrprsMberPasswordCnsr;

	private String groupId;

	private String detailAdres;

	private String entrprsEndTelno;

	private String areaNo;

	private String applcntEmailAdres;

	private String esntlId;

	private String lockAt;

	private Integer lockCnt;

	private LocalDateTime lockLastPnttm;

	public EntrprsMber of() {
		return EntrprsMberMapper.INSTANCE.dtoToEntity(this);
	}

}
