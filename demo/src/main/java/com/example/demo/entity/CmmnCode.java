package com.example.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "COMTCCMMNCODE")

@DynamicInsert
@DynamicUpdate

@Getter

@ToString(of = { "codeId", "codeIdNm", "codeIdDc", "useAt", "frstRegistPnttm", "frstRegisterId", "lastUpdtPnttm",
		"lastUpdusrId" })

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

@Builder
public class CmmnCode {

	@Id
	@Column(length = 6)
	private String codeId;

	@Column(length = 60)
	private String codeIdNm;

	@Column(length = 200)
	private String codeIdDc;

	@Column(length = 1)
	private String useAt;

//	@Column(length = 3)
//	private String clCode;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CL_CODE", foreignKey = @ForeignKey(name = "COMTCCMMNCODE_FK1"))
	private CmmnClCode cmmnClCode;

	private LocalDateTime frstRegistPnttm;

	@Column(length = 20)
	private String frstRegisterId;

	private LocalDateTime lastUpdtPnttm;

	@Column(length = 20)
	private String lastUpdusrId;

	public static CmmnCode empty() {
		return new CmmnCode();
	}

}
