package god.test.reflection;

import java.lang.reflect.Method;

import org.apache.commons.lang3.SystemUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;

public class ReflectionUtilsTest {

	protected static Logger egovLogger = LoggerFactory.getLogger(ReflectionUtilsTest.class);

	@Test
	public void test() {
		Class<?> leafClass = egovframework.com.cmm.service.EgovCmmUseService.class;

		Method[] m = ReflectionUtils.getAllDeclaredMethods(leafClass);

		StringBuffer sb = new StringBuffer(SystemUtils.LINE_SEPARATOR);

		for (int i = 0; i < m.length; i++) {
			egovLogger.debug("method: {}", m[i].toString());
			egovLogger.debug("getName: {}", m[i].getName());

			sb.append("A");
			sb.append(i + 1);
			sb.append("_");
			sb.append(m[i].getName());
			sb.append(SystemUtils.LINE_SEPARATOR);
		}

		egovLogger.debug(sb.toString());
	}

}
