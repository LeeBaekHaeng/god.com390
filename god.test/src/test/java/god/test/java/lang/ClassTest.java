package god.test.java.lang;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.apache.commons.lang3.SystemUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClassTest {

	protected static Logger egovLogger = LoggerFactory.getLogger(ClassTest.class);

	@Test
	public void test() throws Exception {
		String className = Class.class.getCanonicalName();
		egovLogger.debug("getCanonicalName: {}", className);

		className = Class.class.getName();
		egovLogger.debug("getName: {}", className);

		className = Class.class.getSimpleName();
		egovLogger.debug("getSimpleName: {}", className);

		className = Class.class.getTypeName();
		egovLogger.debug("getTypeName: {}", className);

		Class<?> c = Class.forName(className);
		Method m[] = c.getDeclaredMethods();

		StringBuffer sb = new StringBuffer(SystemUtils.LINE_SEPARATOR);

		for (int i = 0; i < m.length; i++) {
			boolean isPublic = Modifier.isPublic(m[i].getModifiers());

			if (m[i].getName().indexOf("Methods") == -1) {
				continue;
			}

			egovLogger.debug("method: {}", m[i].toString());
			egovLogger.debug("getName: {}", m[i].getName());
			egovLogger.debug("getModifiers: {}", m[i].getModifiers());

			sb.append("A");
			sb.append(i + 1);
			sb.append("_");
			sb.append(m[i].getModifiers());
			sb.append("_");
			sb.append(isPublic);
			sb.append("_");
			sb.append(m[i].getName());
			sb.append(SystemUtils.LINE_SEPARATOR);
		}

		egovLogger.debug(sb.toString());
	}

}
