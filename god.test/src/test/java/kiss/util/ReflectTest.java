package kiss.util;

import java.lang.reflect.Method;

import org.apache.commons.lang3.SystemUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.com.cmm.service.impl.EgovCmmUseServiceImpl;

public class ReflectTest {

// https://github.com/wmacevoy/kiss/blob/master/src/main/java/kiss/util/Reflect.java

	protected static Logger egovLogger = LoggerFactory.getLogger(ReflectTest.class);

	@Test
	public void test() {
//		Class<?> clazz = egovframework.com.cmm.service.EgovCmmUseService.class;
		Class<EgovCmmUseServiceImpl> clazz = egovframework.com.cmm.service.impl.EgovCmmUseServiceImpl.class;
		egovLogger.debug("clazz: {}", clazz);

		Method m[] = Reflect.getDeclaredMethodsInOrder(clazz);

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
