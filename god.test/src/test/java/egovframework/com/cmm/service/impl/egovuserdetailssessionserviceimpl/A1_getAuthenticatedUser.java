package egovframework.com.cmm.service.impl.egovuserdetailssessionserviceimpl;

import org.junit.Test;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import god.test.GodTestAbstract;

public class A1_getAuthenticatedUser extends GodTestAbstract {

//	@Autowired
//	private EgovUserDetailsHelper egovUserDetailsHelper;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

//		LoginVO loginVO = (LoginVO) egovUserDetailsHelper.getAuthenticatedUser();
		LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();

		egovLogger.debug("loginVO: {}", loginVO);
		egovLogger.debug("getId: {}", loginVO.getId());
	}

}
