package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.EntrprsMberSpecs;
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

	public Page<EntrprsMberDto> findAll(EntrprsMberDto dto, Pageable pageable) {
		Specification<EntrprsMber> spec = EntrprsMberSpecs.where(dto.of());
		Page<EntrprsMber> page = repository.findAll(spec, pageable);
		List<EntrprsMberDto> content = page.get().map(mapper -> mapper.of()).collect(Collectors.toList());
		return new PageImpl<>(content, pageable, page.getTotalElements());
	}

	public EntrprsMberDto findById(String id) {
		return repository.findById(id).orElseGet(EntrprsMber::new).of();
	}

	@Transactional
	public EntrprsMberDto update(EntrprsMberDto dto) {
		log.debug("dto: {}", dto);
		log.debug("getEntrprsMberId: {}", dto.getEntrprsMberId());
		log.debug("getEntrprsSeCode: {}", dto.getEntrprsSeCode());

		repository.flush();

		EntrprsMber find = repository.findById(dto.getEntrprsMberId()).orElseGet(EntrprsMber::new);

		repository.flush();

		find.setEntrprsSeCode(dto.getEntrprsSeCode());

		repository.flush();

		log.debug("find: {}", find);
		log.debug("getEntrprsMberId: {}", find.getEntrprsMberId());
		log.debug("getEntrprsSeCode: {}", find.getEntrprsSeCode());

		return find.of();
	}

	public void deleteById(String id) {
		repository.deleteById(id);
	}

}
