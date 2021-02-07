package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ComTnGnrlMberDTO;
import com.example.demo.entity.ComTnGnrlMber;
import com.example.demo.repository.ComTnGnrlMberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ComTnGnrlMberService {

	private final ComTnGnrlMberRepository repository;

	public ComTnGnrlMber save(ComTnGnrlMber entity) {
		log.debug("entity: {}", entity);
		return repository.save(entity);
	}

	public ComTnGnrlMberDTO save(ComTnGnrlMberDTO dto) {
		log.debug("dto: {}", dto);
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(repository.save(modelMapper.map(dto, ComTnGnrlMber.class)), ComTnGnrlMberDTO.class);
	}

	public Page<ComTnGnrlMber> findAll(Specification<ComTnGnrlMber> spec, Pageable pageable) {
		return repository.findAll(spec, pageable);
	}

	public ComTnGnrlMber findById(String id) {
//		Optional<ComTnGnrlMber> optional = repository.findById(id);
//		if (optional.isPresent()) {
//			return optional.get();
//		} else {
//			return new ComTnGnrlMber();
//		}
		return repository.findById(id).orElseGet(ComTnGnrlMber::new);
	}

	public ComTnGnrlMber update(ComTnGnrlMber entity) {
		log.debug("entity: {}", entity);
		log.debug("getMberId: {}", entity.getMberId());
		log.debug("getPassword: {}", entity.getPassword());

		ComTnGnrlMber find = repository.findById(entity.getMberId()).orElseGet(ComTnGnrlMber::new);
		find.setPassword(entity.getPassword());

//		TODO http://modelmapper.org/getting-started/

		log.debug("find: {}", find);
		log.debug("getMberId: {}", find.getMberId());
		log.debug("getPassword: {}", find.getPassword());

		ComTnGnrlMber save = repository.save(find);

		log.debug("save: {}", save);
		log.debug("getMberId: {}", save.getMberId());
		log.debug("getPassword: {}", save.getPassword());

		return save;
	}

	public void deleteById(String id) {
		repository.deleteById(id);
	}

	public List<ComTnGnrlMber> saveAll() {
		log.debug("saveAll");

		List<ComTnGnrlMber> entities = new ArrayList<>();

		for (int i = 1; i < 100; i++) {
			ComTnGnrlMber entity = new ComTnGnrlMber();
			entity.setMberId(String.valueOf(i));
			entity.setPassword("test 비밀번호" + i);
			entity.setMberNm("test 회원명" + i);
			entity.setZip(entity.getMberId());
			entity.setAdres("test 주소" + i);
			entity.setAreaNo(entity.getMberId());
			entity.setEndTelno(entity.getMberId());
			entity.setMbtlnum("test 이동전화번호" + i);
			entity.setMiddleTelno(entity.getMberId());
			entity.setEsntlId(entity.getMberId());

			entities.add(entity);
		}

		log.debug("entities: {}", entities);

		List<ComTnGnrlMber> saveAll = repository.saveAll(entities);

		log.debug("saveAll: {}", saveAll);

		return saveAll;
	}

}
