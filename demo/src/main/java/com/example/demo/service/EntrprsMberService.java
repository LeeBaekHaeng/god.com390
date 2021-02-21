package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.EntrprsMberDto;
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

}
