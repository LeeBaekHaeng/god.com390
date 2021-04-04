package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.CmmnClCodeDto;
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

}
