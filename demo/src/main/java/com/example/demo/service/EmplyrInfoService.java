package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.EmplyrInfoSpecs;
import com.example.demo.dto.EmplyrInfoDto;
import com.example.demo.entity.EmplyrInfo;
import com.example.demo.repository.EmplyrInfoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional(readOnly = true)

@RequiredArgsConstructor
@Slf4j
public class EmplyrInfoService {

	private final EmplyrInfoRepository repository;

	@Transactional
	public EmplyrInfoDto save(EmplyrInfoDto dto) {
		log.debug("dto: {}", dto);
		EmplyrInfo entity = dto.of();
		EmplyrInfo saveEntity = repository.save(entity);
		EmplyrInfoDto saveDto = saveEntity.of();
		return saveDto;
	}

	public Page<EmplyrInfoDto> findAll(EmplyrInfoDto dto, Pageable pageable) {
		Specification<EmplyrInfo> spec = EmplyrInfoSpecs.where(dto.of());
		Page<EmplyrInfo> page = repository.findAll(spec, pageable);
		List<EmplyrInfoDto> content = page.get().map(mapper -> mapper.of()).collect(Collectors.toList());
		return new PageImpl<>(content, pageable, page.getTotalElements());
	}

	public EmplyrInfoDto findById(String id) {
		return repository.findById(id).orElseGet(EmplyrInfo::empty).of();
	}

	@Transactional
	public EmplyrInfoDto update(EmplyrInfoDto dto) {
		log.debug("dto: {}", dto);
		EmplyrInfo find = repository.findById(dto.getEmplyrId()).orElseGet(EmplyrInfo::empty);
		find.update(dto.getUserNm());
		return find.of();
	}

	@Transactional
	public void deleteById(String id) {
		repository.deleteById(id);
	}

}
