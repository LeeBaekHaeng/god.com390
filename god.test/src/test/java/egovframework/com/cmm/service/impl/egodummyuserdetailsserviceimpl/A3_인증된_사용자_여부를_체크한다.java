package egovframework.com.cmm.service.impl.egodummyuserdetailsserviceimpl;

import org.junit.Test;

import egovframework.com.cmm.util.EgovUserDetailsHelper;
import god.test.GodTestAbstract;

public class A3_인증된_사용자_여부를_체크한다 extends GodTestAbstract {

	@Override
	@Test
	public void test() {
		egovLogger.debug("인증된 사용자 여부를 체크한다.");

		Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();

		egovLogger.debug("isAuthenticated: {}", isAuthenticated);
	}

}
