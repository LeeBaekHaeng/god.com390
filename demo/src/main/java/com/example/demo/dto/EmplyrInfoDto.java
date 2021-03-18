package com.example.demo.dto;

import java.time.LocalDateTime;

import com.example.demo.entity.EmplyrInfo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

@ToString(of = { "emplyrId", "orgnztId" })

public class EmplyrInfoDto {

	private String emplyrId;

	private String orgnztId;

	private String userNm;

	private String password;

	private String emplNo;

	private String ihidnum;

	private String sexdstnCode;

	private String brthdy;

	private String fxnum;

	private String houseAdres;

	private String passwordHint;

	private String passwordCnsr;

	private String houseEndTelno;

	private String areaNo;

	private String detailAdres;

	private String zip;

	private String offmTelno;

	private String mbtlnum;

	private String emailAdres;

	private String ofcpsNm;

	private String houseMiddleTelno;

	private String groupId;

	private String pstinstCode;

	private String emplyrSttusCode;

	private String esntlId;

	private String crtfcDnValue;

	private LocalDateTime sbscrbDe;

	private String lockAt;

	private Integer lockCnt;

	private LocalDateTime lockLastPnttm;

	public EmplyrInfo of() {
		return EmplyrInfoMapper.INSTANCE.dtoToEntity(this);
	}

}
