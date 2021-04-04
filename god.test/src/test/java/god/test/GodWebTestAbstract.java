package god.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)

@ContextConfiguration({ "classpath*:egovframework/spring/com/**/context-*.xml",
		"classpath*:god/spring/test/**/context-*.xml",
		"file:../god.com/src/main/webapp/WEB-INF/config/egovframework/springmvc/egov-com-*.xml" })

@WebAppConfiguration

@ActiveProfiles({ "mysql", "security" })

@Transactional
public abstract class GodWebTestAbstract {

	protected Logger egovLogger = LoggerFactory.getLogger(GodWebTestAbstract.class);

	public abstract void test();

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

}
