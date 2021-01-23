package com.god.productapi.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDto {

	private Long id;

	private String displayProductName;

	private Double salePrice;

}
