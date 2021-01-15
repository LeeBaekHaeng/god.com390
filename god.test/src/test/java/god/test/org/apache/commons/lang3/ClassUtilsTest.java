package god.test.org.apache.commons.lang3;

import java.util.List;

import org.apache.commons.lang.ClassUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.com.cmm.service.impl.EgovCmmUseServiceImpl;
import god.test.org.apache.commons.io.FileUtilsTest;

public class ClassUtilsTest {

	protected Logger egovLogger = LoggerFactory.getLogger(FileUtilsTest.class);

	@SuppressWarnings("rawtypes")
	@Test
	public void test() {
//		Class cls = EgovCmmUseService.class;
		Class cls = EgovCmmUseServiceImpl.class;

		List interfaces = ClassUtils.getAllInterfaces(cls);
		int size = interfaces.size();
		egovLogger.debug("interfaces: {}", interfaces);
		egovLogger.debug("size: {}", size);
		for (int i = 0; i < size; i++) {
			egovLogger.debug("interface: {}", interfaces.get(i));
		}

		List allSuperclasses = ClassUtils.getAllSuperclasses(cls);
		size = allSuperclasses.size();
		egovLogger.debug("allSuperclasses: {}", allSuperclasses);
		for (int i = 0; i < size; i++) {
			egovLogger.debug("allSuperclass: {}", allSuperclasses.get(i));
		}
	}

}
