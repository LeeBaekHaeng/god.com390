package egovframework.com.cmm.service.impl.egodummyuserdetailsserviceimpl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import god.test.GodTestAbstract;

public class A1_인증된_사용자객체를_VO형식으로_가져온다 extends GodTestAbstract {

//	@Resource(name = "egovUserDetailsHelper")
	@Autowired
//	@Qualifier("egovUserDetailsHelper")
	private EgovUserDetailsHelper egovUserDetailsHelper;

	@Override
	@Test
	public void test() {
		egovLogger.debug("인증된 사용자객체를 VO형식으로 가져온다.");

		LoginVO loginVO = (LoginVO) egovUserDetailsHelper.getAuthenticatedUser();

		egovLogger.debug("loginVO: {}", loginVO);
		egovLogger.debug("loginVO: {}", loginVO.getId());

		assertEquals(loginVO.getId(), "TEST1");
	}

	@Test
	public void test2() {
		egovLogger.debug("인증된 사용자객체를 VO형식으로 가져온다.");

		LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();

		egovLogger.debug("loginVO: {}", loginVO);
		egovLogger.debug("loginVO: {}", loginVO.getId());

		assertEquals(loginVO.getId(), "TEST1");
	}

}
