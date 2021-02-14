package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
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

	@Column(length = 60, nullable = false)
	private String cmpnyNm;

	@Column(length = 50)
	private String cxfc;

	@Column(length = 6, nullable = false)
	private String zip;

	@Column(length = 100, nullable = false)
	private String adres;

	@Column(length = 4, nullable = false)
	private String entrprsMiddleTelno;

}
