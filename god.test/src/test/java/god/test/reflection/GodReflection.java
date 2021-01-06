/**
 * 
 */
package god.test.reflection;

import java.lang.reflect.Method;

import org.apache.commons.lang3.SystemUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author god
 *
 */
public class GodReflection {

	protected static Logger egovLogger = LoggerFactory.getLogger(GodReflection.class);

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		egovLogger.info("setUpBeforeClass");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		egovLogger.info("tearDownAfterClass");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		egovLogger.info("setUp");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		egovLogger.info("tearDown");
	}

	@Test
	public void test() throws Exception {
		egovLogger.info("test");

		String className = "egovframework.com.cmm.util.EgovUserDetailsHelper";

		Class<?> c = Class.forName(className);
		Method m[] = c.getDeclaredMethods();

		StringBuffer sb = new StringBuffer(SystemUtils.LINE_SEPARATOR);

		for (int i = 0; i < m.length; i++) {
			egovLogger.debug("method: {}", m[i].toString());
			egovLogger.debug("method: {}", m[i].getName());

			sb.append("A");
			sb.append(i + 1);
			sb.append("_");
			sb.append(m[i].getName());
			sb.append(SystemUtils.LINE_SEPARATOR);
		}

		egovLogger.debug(sb.toString());
	}

}
