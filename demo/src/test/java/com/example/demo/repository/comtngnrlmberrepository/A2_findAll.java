package com.example.demo.repository.comtngnrlmberrepository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import com.example.demo.domain.ComTnGnrlMberSpecs;
import com.example.demo.entity.ComTnGnrlMber;
import com.example.demo.repository.ComTnGnrlMberRepository;
import com.example.demo.service.ComTnGnrlMberService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class A2_findAll {

	private final ComTnGnrlMberRepository repository;
	private final ComTnGnrlMberService service;

	@Autowired
	public A2_findAll(ComTnGnrlMberRepository repository, ComTnGnrlMberService service) {
		this.repository = repository;
		this.service = service;
	}

	@Test
	void test() {
		log.debug("test");

		List<ComTnGnrlMber> saveAll = service.saveAll();
		saveAll.forEach(action -> {
			log.debug("action: {}", action);
			log.debug("getMberId: {}", action.getMberId());
		});

		ComTnGnrlMber entity = new ComTnGnrlMber();
		entity.setMberId("1");
		entity.setPassword("test 비밀번호1");

		log.debug("entity: {}", entity);

//		Specification<ComTnGnrlMber> spec = ComTnGnrlMberSpecs.equalMberId(entity)
//				.and(ComTnGnrlMberSpecs.equalPassword(entity));
		Specification<ComTnGnrlMber> spec = ComTnGnrlMberSpecs.where(entity);

		Sort sort = Sort.by("mberId").descending();
		sort = sort.and(Sort.by("sbscrbDe").descending());
		Pageable pageable = PageRequest.of(0, 10, sort);

		Page<ComTnGnrlMber> page = repository.findAll(spec, pageable);

		log.debug("getTotalElements: {}", page.getTotalElements());

		page.get().forEach(action -> {
			log.debug("action: {}", action);
			log.debug("getMberId: {}", action.getMberId());
		});
	}

}
