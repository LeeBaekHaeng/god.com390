package com.example.demo.dto;

import java.time.LocalDateTime;

import com.example.demo.entity.CmmnClCode;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

@ToString(of = { "clCode", "clCodeNm", "clCodeDc", "useAt", "frstRegistPnttm", "frstRegisterId", "lastUpdtPnttm",
		"lastUpdusrId" })

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

@Builder
public class CmmnClCodeDto {

	private String clCode;

	private String clCodeNm;

	private String clCodeDc;

	private String useAt;

	private LocalDateTime frstRegistPnttm;

	private String frstRegisterId;

	private LocalDateTime lastUpdtPnttm;

	private String lastUpdusrId;

	public CmmnClCode of() {
		return CmmnClCodeMapper.INSTANCE.dtoToEntity(this);
	}
}
