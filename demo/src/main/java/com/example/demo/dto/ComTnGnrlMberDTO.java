package com.example.demo.dto;

import java.time.LocalDateTime;

import com.example.demo.entity.ComTnGnrlMber;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

@ToString(of = { "mberId", "password" })

@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor

@Builder
public class ComTnGnrlMberDTO {

	private String mberId;

	private String password;

	private String passwordHint;

	private String passwordCnsr;

	private String ihidnum;

	private String mberNm;

	private String zip;

	private String adres;

	private String areaNo;

	private String mberSttus;

	private String detailAdres;

	private String endTelno;

	private String mbtlnum;

	private String groupId;

	private String mberFxnum;

	private String mberEmailAdres;

	private String middleTelno;

	private LocalDateTime sbscrbDe;

	private String sexdstnCode;

	private String esntlId;

	private String lockAt;

	private Long lockCnt;

	private LocalDateTime lockLastPnttm;

//	public ComTnGnrlMberDTO of(ComTnGnrlMber entity) {
//		return ComTnGnrlMberMapper.INSTANCE.entityToDto(entity);
//	}

	public ComTnGnrlMber of(ComTnGnrlMberDTO dto) {
		return ComTnGnrlMberMapper.INSTANCE.dtoToEntity(dto);
	}

	public ComTnGnrlMber of() {
		return ComTnGnrlMberMapper.INSTANCE.dtoToEntity(this);
	}

}
