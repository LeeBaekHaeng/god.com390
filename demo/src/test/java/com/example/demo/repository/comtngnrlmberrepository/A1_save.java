package com.example.demo.repository.comtngnrlmberrepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.ComTnGnrlMber;
import com.example.demo.repository.ComTnGnrlMberRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
//@RequiredArgsConstructor
class A1_save {

	private final ComTnGnrlMberRepository repository;

	@Autowired
	public A1_save(ComTnGnrlMberRepository repository) {
		this.repository = repository;
	}

	@Test
	void test() {
		log.debug("test");

		ComTnGnrlMber entity = new ComTnGnrlMber();
		entity.setMberId("1");
		entity.setPassword("test 비밀번호");
		entity.setPasswordHint("test 비밀번호힌트");
		entity.setPasswordCnsr("test 비밀번호정답");

		log.debug("entity: {}", entity);

		ComTnGnrlMber save = repository.save(entity);

		log.debug("save: {}", save);
		log.debug("getMberId: {}", save.getMberId());
		log.debug("getPassword: {}", save.getPassword());
		log.debug("getPasswordHint: {}", save.getPasswordHint());
		log.debug("getPasswordCnsr: {}", save.getPasswordCnsr());

		assertEquals(entity.getMberId(), save.getMberId());
		assertEquals(entity.getPassword(), save.getPassword());
		assertEquals(entity.getPasswordHint(), save.getPasswordHint());
		assertEquals(entity.getPasswordCnsr(), save.getPasswordCnsr());
	}

}
