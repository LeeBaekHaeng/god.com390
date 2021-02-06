package lombok;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class GodLombokV1Test {

	@Test
	void test() {
		log.debug("test");

		GodLombokV1 godLombokV1 = new GodLombokV1();
		godLombokV1.setId(1L);
		godLombokV1.setName("test 이름");

		log.debug("godLombokV1: {}", godLombokV1);
		log.debug("getId: {}", godLombokV1.getId());
		log.debug("getName: {}", godLombokV1.getName());

		godLombokV1 = new GodLombokV1(2L, "test 2 이름", null);

		log.debug("godLombokV1: {}", godLombokV1);
		log.debug("getId: {}", godLombokV1.getId());
		log.debug("getName: {}", godLombokV1.getName());
	}

}
