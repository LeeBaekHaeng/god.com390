package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.CmmnClCodeSpecs;
import com.example.demo.dto.CmmnClCodeDto;
import com.example.demo.entity.CmmnClCode;
import com.example.demo.repository.CmmnClCodeRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional(readOnly = true)

@RequiredArgsConstructor
@Slf4j
public class CmmnClCodeService {

	private final CmmnClCodeRepository repository;

	@Transactional
	public CmmnClCodeDto save(CmmnClCodeDto dto) {
		log.debug("dto: {}", dto);
		return repository.save(dto.of()).of();
	}

	public Page<CmmnClCodeDto> findAll(CmmnClCodeDto dto, Pageable pageable) {
		Specification<CmmnClCode> spec = CmmnClCodeSpecs.where(dto.of());
		Page<CmmnClCode> page = repository.findAll(spec, pageable);
		List<CmmnClCodeDto> content = page.get().map(mapper -> mapper.of()).collect(Collectors.toList());
		return new PageImpl<>(content, pageable, page.getTotalElements());
	}

	public CmmnClCodeDto findById(String id) {
		return repository.findById(id).orElseGet(CmmnClCode::empty).of();
	}

	@Transactional
	public CmmnClCodeDto update(CmmnClCodeDto dto) {
		log.debug("dto: {}", dto);
		CmmnClCode find = repository.findById(dto.getClCode()).orElseGet(CmmnClCode::empty);
		find.update(dto.getClCodeNm(), dto.getLastUpdtPnttm(), dto.getLastUpdusrId());
		return find.of();
	}

}
