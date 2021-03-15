package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.EmplyrInfoDto;
import com.example.demo.entity.EmplyrInfo;
import com.example.demo.repository.EmplyrInfoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service

@RequiredArgsConstructor
@Slf4j
public class EmplyrInforService {

	private final EmplyrInfoRepository repository;

	public EmplyrInfoDto save(EmplyrInfoDto dto) {
		log.debug("dto: {}", dto);
		EmplyrInfo entity = dto.of();
		EmplyrInfo saveEntity = repository.save(entity);
		EmplyrInfoDto saveDto = saveEntity.of();
		return saveDto;
	}

//	public Page<EmplyrInfoDto> findAll(EmplyrInfoDto dto, Pageable pageable) {
//		Specification<EmplyrInfo> spec = EmplyrInfoSpecs.where(dto.of());
//		Page<EmplyrInfo> page = repository.findAll(spec, pageable);
//		List<EmplyrInfoDto> content = page.get().map(mapper -> mapper.of()).collect(Collectors.toList());
//		return new PageImpl<>(content, pageable, page.getTotalElements());
//	}
//
//	public EmplyrInfoDto findById(String id) {
//		return repository.findById(id).orElseGet(EmplyrInfo::new).of();
//	}
//
//	@Transactional
//	public EmplyrInfoDto update(EmplyrInfoDto dto) {
//		log.debug("dto: {}", dto);
//		log.debug("getEmplyrInfoId: {}", dto.getEmplyrInfoId());
//		log.debug("getEntrprsSeCode: {}", dto.getEntrprsSeCode());
//
//		repository.flush();
//
//		EmplyrInfo find = repository.findById(dto.getEmplyrInfoId()).orElseGet(EmplyrInfo::new);
//
//		repository.flush();
//
//		find.setEntrprsSeCode(dto.getEntrprsSeCode());
//
//		repository.flush();
//
//		log.debug("find: {}", find);
//		log.debug("getEmplyrInfoId: {}", find.getEmplyrInfoId());
//		log.debug("getEntrprsSeCode: {}", find.getEntrprsSeCode());
//
//		return find.of();
//	}
//
//	public void deleteById(String id) {
//		repository.deleteById(id);
//	}

}
