package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.example.demo.dto.CmmnClCodeDto;
import com.example.demo.dto.CmmnClCodeMapper;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "COMTCCMMNCLCODE")

@DynamicInsert
@DynamicUpdate

@Getter

@ToString(of = { "clCode", "clCodeNm", "clCodeDc", "useAt", "frstRegistPnttm", "frstRegisterId", "lastUpdtPnttm",
		"lastUpdusrId" })

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

@Builder
public class CmmnClCode {

	@Id
	@Column(length = 3)
	private String clCode;

	@Column(length = 60)
	private String clCodeNm;

	@Column(length = 200)
	private String clCodeDc;

	@Column(length = 1)
	private String useAt;

	private LocalDateTime frstRegistPnttm;

	@Column(length = 20)
	private String frstRegisterId;

	private LocalDateTime lastUpdtPnttm;

	@Column(length = 20)
	private String lastUpdusrId;

	@OneToMany(mappedBy = "cmmnClCode")
	private final List<CmmnCode> cmmnCodes = new ArrayList<>();

	public static CmmnClCode empty() {
		return new CmmnClCode();
	}

	public void update(String clCodeNm, String lastUpdusrId, LocalDateTime lastUpdtPnttm) {
		this.clCodeNm = clCodeNm;
		this.lastUpdusrId = lastUpdusrId;
		this.lastUpdtPnttm = lastUpdtPnttm;
	}

	public void update(String clCodeNm, LocalDateTime lastUpdtPnttm, String lastUpdusrId) {
		this.clCodeNm = clCodeNm;
		this.lastUpdtPnttm = lastUpdtPnttm;
		this.lastUpdusrId = lastUpdusrId;
	}

	public CmmnClCodeDto of() {
		return CmmnClCodeMapper.INSTANCE.entityToDto(this);
	}

}
