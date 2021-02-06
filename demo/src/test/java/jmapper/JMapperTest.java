package jmapper;

import org.junit.jupiter.api.Test;

import com.googlecode.jmapper.JMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class JMapperTest {

	@Test
	void test() {
		log.debug("test");

		JMapper<Destination, Source> mapper;

		mapper = new JMapper<>(Destination.class, Source.class);

		Source source = new Source("id", "sourceField", "other");
		Destination destination = mapper.getDestination(source);

		log.debug("source: {}", source);
		log.debug("destination: {}", destination);
	}

}

//@Getter
//@Setter
//class Destination {
//	@JMap
//	private String id;
//	@JMap("sourceField")
//	private String destinationField;
//	private String other;
//
//	// getters and setters...
//}
//
//@Getter
//@Setter
//@AllArgsConstructor
//class Source {
//	private String id;
//	private String sourceField;
//	private String other;
//
//	// getters and setters...
//}