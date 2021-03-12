package com.example.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "COMTNEMPLYRINFO")

@DynamicInsert
@DynamicUpdate

@Getter

//@Setter

@ToString(of = { "emplyrId" })

//@NoArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@RequiredArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)

@Builder
public class EmplyrInfo {

	@Id
//	@GeneratedValue
	@Column(length = 20)
	private String emplyrId;

	@Column(length = 20)
	private String orgnztId;

	@Column(nullable = false, length = 60)
	private String userNm;

	@Column(nullable = false, length = 200)
	private String password;

	@Column(length = 20)
	private String emplNo;

	@Column(length = 200)
	private String ihidnum;

	@Column(length = 1)
	private String sexdstnCode;

	@Column(length = 20)
	private String brthdy;

	@Column(length = 20)
	private String fxnum;

	@Column(nullable = false, length = 100)
	private String houseAdres;

	@Column(nullable = false, length = 100)
	private String passwordHint;

	@Column(nullable = false, length = 100)
	private String passwordCnsr;

	@Column(nullable = false, length = 4)
	private String houseEndTelno;

	@Column(nullable = false, length = 4)
	private String areaNo;

	@Column(length = 100)
	private String detailAdres;

	@Column(nullable = false, length = 6)
	private String zip;

	@Column(length = 20)
	private String offmTelno;

	@Column(length = 20)
	private String mbtlnum;

	@Column(length = 50)
	private String emailAdres;

	@Column(length = 60)
	private String ofcpsNm;

	@Column(nullable = false, length = 4)
	private String houseMiddleTelno;

	@Column(length = 20)
	private String groupId;

	@Column(length = 8)
	private String pstinstCode;

	@Column(nullable = false, length = 1)
	private String emplyrSttusCode;

	@Column(nullable = false, length = 20)
	private String esntlId;

	@Column(length = 100)
	private String crtfcDnValue;

	private LocalDateTime sbscrbDe;

	@Column(length = 1)
	private String lockAt;

	private Integer lockCnt;

	private LocalDateTime lockLastPnttm;

	public static EmplyrInfo empty() {
		return new EmplyrInfo();
//		return EmplyrInfo.builder().areaNo("0000").build();
	}

	public void update(String areaNo, String userNm) {
		this.areaNo = areaNo;
		this.userNm = userNm;
	}

}
