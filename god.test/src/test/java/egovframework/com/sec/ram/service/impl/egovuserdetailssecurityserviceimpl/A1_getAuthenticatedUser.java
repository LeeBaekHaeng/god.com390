package egovframework.com.sec.ram.service.impl.egovuserdetailssecurityserviceimpl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;

@RunWith(SpringRunner.class)

@ContextConfiguration({ "classpath*:egovframework/spring/com/**/context-*.xml",
		"classpath*:god/spring/test/**/context-*.xml",
		"file:../god.com/src/main/webapp/WEB-INF/config/egovframework/springmvc/egov-com-*.xml" })

@WebAppConfiguration

@ActiveProfiles({ "mysql", "security" })

@Transactional

public class A1_getAuthenticatedUser {

	protected Logger egovLogger = LoggerFactory.getLogger(A1_getAuthenticatedUser.class);

//	@Autowired
//	EgovUserDetailsHelper egovUserDetailsHelper;

	@Test
	public void test() {
		egovLogger.debug("test");

		// given

		// when
//		LoginVO loginVO = (LoginVO) egovUserDetailsHelper.getAuthenticatedUser();
		LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();

		// then
		assertEquals(loginVO, null);

		egovLogger.debug("loginVO={}", loginVO);

		if (loginVO != null) {
			egovLogger.debug("getId={}", loginVO.getId());
		}
	}

}
