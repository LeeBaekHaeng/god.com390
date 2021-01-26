package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class ComTnGnrlMber {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 20)
	private String mberId;

	@Column(nullable = false, length = 200)
	private String password;

	@Column(length = 100)
	private String passwordHint;

	@Column(length = 100)
	private String passwordCnsr;

	@Column(length = 200)
	private String ihidnum;

	@Column(nullable = false, length = 50)
	private String mberNm;

	@Column(nullable = false, length = 6)
	private String zip;

	@Column(nullable = false, length = 100)
	private String adres;

	@Column(nullable = false, length = 4)
	private String areaNo;

	@Column(length = 15)
	private String mberSttus;

	@Column(length = 100)
	private String detailAdres;

}
