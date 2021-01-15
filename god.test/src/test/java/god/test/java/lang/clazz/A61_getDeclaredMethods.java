package god.test.java.lang.clazz;

import java.lang.reflect.Method;

import org.apache.commons.lang3.SystemUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class A61_getDeclaredMethods {

	protected Logger egovLogger = LoggerFactory.getLogger(A61_getDeclaredMethods.class);

	@Test
	public void test() throws Exception {
//		String className = Class.class.getName();
		String className = egovframework.com.cmm.service.EgovCmmUseService.class.getName();
		egovLogger.debug("getName: {}", className);

		Class<?> c = Class.forName(className);
		Method m[] = c.getDeclaredMethods();

		StringBuffer sb = new StringBuffer(SystemUtils.LINE_SEPARATOR);

		for (int i = 0; i < m.length; i++) {
//			if (m[i].getName().indexOf("Methods") == -1) {
//				continue;
//			}

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
