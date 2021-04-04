package egovframework.com.sec.ram.service.impl.egovuserdetailssecurityserviceimpl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import god.test.GodWebTestAbstract;

public class A1_getAuthenticatedUser extends GodWebTestAbstract {

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
