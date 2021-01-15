package god.test.java.lang.clazz;

import java.lang.reflect.Field;

import org.apache.commons.lang3.SystemUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import utils.NamingUtils;

public class GOD_A060_getDeclaredFields {

	protected Logger egovLogger = LoggerFactory.getLogger(GOD_A060_getDeclaredFields.class);

	@Test
	public void test() throws Exception {
		String className = egovframework.com.cop.ems.service.SndngMailVO.class.getName();
		egovLogger.debug("className: {}", className);

		Class<?> c = Class.forName(className);
		Field[] fields = c.getDeclaredFields();

		StringBuffer sb = new StringBuffer(SystemUtils.LINE_SEPARATOR);
		StringBuffer sb2 = new StringBuffer(SystemUtils.LINE_SEPARATOR);

		for (int i = 0; i < fields.length; i++) {
			egovLogger.debug("fields: {}", fields[i]);
			egovLogger.debug("getName: {}", fields[i].getName());

			sb.append("vo.set");
			sb.append(NamingUtils.convertCamelcaseToPascalcase(fields[i].getName()));
			sb.append("(\"\");");
			sb.append(SystemUtils.LINE_SEPARATOR);

			sb2.append("egovLogger.debug(\"");
			sb2.append(fields[i].getName());
			sb2.append(": {}\", vo.get");
			sb2.append(NamingUtils.convertCamelcaseToPascalcase(fields[i].getName()));
			sb2.append("());");
			sb2.append(SystemUtils.LINE_SEPARATOR);
		}

		egovLogger.debug(sb.toString());
		egovLogger.debug(sb2.toString());
	}

}
