package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EntrprsMberDto;
import com.example.demo.entity.EntrprsMber;
import com.example.demo.repository.EntrprsMberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service

@RequiredArgsConstructor
@Slf4j
public class EntrprsMberService {

	private final EntrprsMberRepository repository;

	public EntrprsMberDto save(EntrprsMberDto dto) {
		log.debug("dto: {}", dto);
		return repository.save(dto.of()).of();
	}

	public Page<EntrprsMberDto> findAll(Specification<EntrprsMber> spec, Pageable pageable) {
		Page<EntrprsMber> page = repository.findAll(spec, pageable);
		List<EntrprsMberDto> content = page.get().map(mapper -> mapper.of()).collect(Collectors.toList());
		return new PageImpl<>(content, pageable, page.getTotalElements());
	}

}
