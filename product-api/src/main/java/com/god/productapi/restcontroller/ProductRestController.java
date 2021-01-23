package com.god.productapi.restcontroller;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.god.productapi.dto.ProductDto;
import com.god.productapi.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/products")
@RequiredArgsConstructor
public class ProductRestController {

	private final ProductService service;

	@PostMapping
	public ProductDto post(@RequestBody ProductDto dto) {
		return service.post(dto);
	}

	@GetMapping
	public List<ProductDto> get(ProductDto dto, Pageable pageable) {
		return service.get(dto, pageable);
	}

	@GetMapping("/{id}")
	public ProductDto get2(@PathVariable Long id, ProductDto dto) {
		return service.get2(dto);
	}

}
