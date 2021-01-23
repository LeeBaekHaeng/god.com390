package com.god.productapi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Product {

	@Id
	@GeneratedValue
	private Long id;

	private String displayProductName;

	private Double salePrice;

}
