package god.test.java.lang.clazz;

import java.lang.reflect.Field;

import org.apache.commons.lang3.SystemUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GOD_A053_getFields {

	protected Logger egovLogger = LoggerFactory.getLogger(GOD_A053_getFields.class);

	@Test
	public void test() throws Exception {
		String className = egovframework.com.cop.ems.service.SndngMailVO.class.getName();
		egovLogger.debug("className: {}", className);

		Class<?> c = Class.forName(className);
		Field[] fields = c.getFields();

		StringBuffer sb = new StringBuffer(SystemUtils.LINE_SEPARATOR);

		for (int i = 0; i < fields.length; i++) {
			egovLogger.debug("fields: {}", fields[i]);
			egovLogger.debug("getName: {}", fields[i].getName());

			sb.append("A");
			sb.append(i + 1);
			sb.append("_");
			sb.append(fields[i].getName());
			sb.append(SystemUtils.LINE_SEPARATOR);
		}

		egovLogger.debug(sb.toString());
	}

}
