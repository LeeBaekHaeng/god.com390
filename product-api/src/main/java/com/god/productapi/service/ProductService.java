package com.god.productapi.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.god.productapi.dto.ProductDto;
import com.god.productapi.entity.Product;
import com.god.productapi.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository repository;

	public ProductDto post(ProductDto dto) {
		ModelMapper modelMapper = new ModelMapper();
		Product entity = modelMapper.map(dto, Product.class);
		Product save = repository.save(entity);
		ProductDto result = modelMapper.map(save, ProductDto.class);
		return result;
	}

	public List<ProductDto> get(ProductDto dto, Pageable pageable) {
		ModelMapper modelMapper = new ModelMapper();

		Product entity = modelMapper.map(dto, Product.class);

		Example<Product> example = Example.of(entity);

		Page<Product> page = repository.findAll(example, pageable);

		List<ProductDto> results = new ArrayList<>();
		page.getContent().forEach(action -> {
			ProductDto result = modelMapper.map(action, ProductDto.class);
			results.add(result);
		});

		return results;
	}

	public ProductDto get2(ProductDto dto) {
		ModelMapper modelMapper = new ModelMapper();
		Product product = repository.findById(dto.getId()).get();
		ProductDto result = modelMapper.map(product, ProductDto.class);
		return result;
	}

}
