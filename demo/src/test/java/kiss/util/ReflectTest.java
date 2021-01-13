package kiss.util;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReflectTest {

// https://github.com/wmacevoy/kiss/blob/master/src/main/java/kiss/util/Reflect.java

	private static final Logger log = LoggerFactory.getLogger(ReflectTest.class);

	@Test
	public void test() {
		Class<?> clazz = org.springframework.data.repository.query.QueryByExampleExecutor.class;
		log.debug("clazz: {}", clazz);

		Method m[] = Reflect.getDeclaredMethodsInOrder(clazz);

		StringBuffer sb = new StringBuffer("\n");

		for (int i = 0; i < m.length; i++) {
			log.debug("method: {}", m[i].toString());
			log.debug("getName: {}", m[i].getName());

			sb.append("A");
			sb.append(String.format("%0" + String.valueOf(m.length).length() + "d", i + 1));
			sb.append("_");
			sb.append(m[i].getName());
			sb.append("\n");
		}

		log.debug(sb.toString());
	}

}
