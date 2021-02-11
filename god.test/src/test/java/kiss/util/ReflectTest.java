package kiss.util;

import java.lang.reflect.Method;

import org.apache.commons.lang3.SystemUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.com.uat.uap.service.impl.LoginPolicyDAO;

public class ReflectTest {

// https://github.com/wmacevoy/kiss/blob/master/src/main/java/kiss/util/Reflect.java

	protected static Logger egovLogger = LoggerFactory.getLogger(ReflectTest.class);

	@Test
	public void test() {
//		Class<?> clazz = egovframework.com.cmm.service.EgovCmmUseService.class;
//		Class<EgovCmmUseServiceImpl> clazz = egovframework.com.cmm.service.impl.EgovCmmUseServiceImpl.class;
//		Class<ClassLoader> clazz = java.lang.ClassLoader.class;
//		Class<?> clazz = egovframework.com.cop.ems.service.impl.SndngMailDetailDAO.class;
//		Class<?> clazz = java.lang.Class.class;
//		Class<?> clazz = SndngMailDtlsDAO.class;
//		Class<?> clazz = SndngMailRegistDAO.class;
//		Class<?> clazz = AuthorManageDAO.class;
//		Class<?> clazz = AuthorRoleManageDAO.class;
		Class<?> clazz = LoginPolicyDAO.class;
//		Class<?> clazz = LoginPolicyVO.class;
//		Class<?> clazz = LoginPolicy.class;

		egovLogger.debug("clazz: {}", clazz);

		Method m[] = Reflect.getDeclaredMethodsInOrder(clazz);

		StringBuffer sb = new StringBuffer(SystemUtils.LINE_SEPARATOR);

		for (int i = 0; i < m.length; i++) {
			egovLogger.debug("method: {}", m[i].toString());
			egovLogger.debug("getName: {}", m[i].getName());

			sb.append("A");
			sb.append(String.format("%0" + String.valueOf(m.length).length() + "d", i + 1));
			sb.append("_");
			sb.append(m[i].getName());
			sb.append(SystemUtils.LINE_SEPARATOR);
		}

		egovLogger.debug(sb.toString());
	}

}
