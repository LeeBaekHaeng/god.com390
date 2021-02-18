package com.example.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "COMTNENTRPRSMBER")
@DynamicInsert
@DynamicUpdate

@Getter
//@Setter
@ToString

@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor

@Builder
public class EntrprsMber {

	@Id
//	@GeneratedValue
	@Column(length = 20)
	private String entrprsMberId;

	@Column(length = 8)
	private String entrprsSeCode;

	@Column(length = 10)
	private String bizrno;

	@Column(length = 13)
	private String jurirno;

	@Column(nullable = false, length = 60)
	private String cmpnyNm;

	@Column(length = 50)
	private String cxfc;

	@Column(nullable = false, length = 6)
	private String zip;

	@Column(nullable = false, length = 100)
	private String adres;

	@Column(nullable = false, length = 4)
	private String entrprsMiddleTelno;

	@Column(length = 20)
	private String fxnum;

	@Column(length = 1)
	private String indutyCode;

	@Column(nullable = false, length = 50)
	private String applcntNm;

	@Column(length = 200)
	private String applcntIhidnum;

	private LocalDateTime sbscrbDe;

	@Column(length = 15)
	private String entrprsMberSttus;

	@Column(length = 200)
	private String entrprsMberPassword;

	@Column(nullable = false, length = 100)
	private String entrprsMberPasswordHint;

	@Column(nullable = false, length = 100)
	private String entrprsMberPasswordCnsr;

	@Column(length = 20)
	private String groupId;

	@Column(length = 100)
	private String detailAdres;

	@Column(nullable = false, length = 4)
	private String entrprsEndTelno;

	@Column(nullable = false, length = 4)
	private String areaNo;

	@Column(nullable = false, length = 50)
	private String applcntEmailAdres;

	@Column(nullable = false, length = 20)
	private String esntlId;

	@Column(length = 1)
	private String lockAt;

	private Integer lockCnt;

	private LocalDateTime lockLastPnttm;

	public void set(String cmpnyNm) {
		this.cmpnyNm = cmpnyNm;
	}

}
