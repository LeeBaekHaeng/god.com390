package com.example.demo;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class GetterSetterExampleTest {

	@Test
	void test() {
		GetterSetterExample getterSetterExample = new GetterSetterExample();

		getterSetterExample.setAge(10);

		getterSetterExample.setName("test god");

		log.debug("getAge: {}", getterSetterExample.getAge());
		log.debug("getName: {}", getterSetterExample.getName());
	}

}
