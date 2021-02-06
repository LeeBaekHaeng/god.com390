package lombok;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class GodLombokV2Test {

	@Test
	void test() {
		log.debug("test");

		GodLombokV2 godLombokV2 = GodLombokV2.builder().id(1L).name("test 이름").build();

		log.debug("godLombokV2: {}", godLombokV2);
		log.debug("getId: {}", godLombokV2.getId());
		log.debug("getName: {}", godLombokV2.getName());

		godLombokV2 = new GodLombokV2(2L, "test 2 이름", null);

		log.debug("godLombokV2: {}", godLombokV2);
		log.debug("getId: {}", godLombokV2.getId());
		log.debug("getName: {}", godLombokV2.getName());
	}

}
