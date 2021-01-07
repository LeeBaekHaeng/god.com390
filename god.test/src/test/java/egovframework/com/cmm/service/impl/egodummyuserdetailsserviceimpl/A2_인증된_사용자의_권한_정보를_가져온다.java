package egovframework.com.cmm.service.impl.egodummyuserdetailsserviceimpl;

import java.util.List;

import org.junit.Test;

import egovframework.com.cmm.util.EgovUserDetailsHelper;
import god.test.GodTestAbstract;

public class A2_인증된_사용자의_권한_정보를_가져온다 extends GodTestAbstract {

	@Override
	@Test
	public void test() {
		egovLogger.debug("인증된 사용자의 권한 정보를 가져온다.");

		List<String> authorities = EgovUserDetailsHelper.getAuthorities();

		egovLogger.debug("authorities: {}", authorities);
		egovLogger.debug("size: {}", authorities.size());

		for (String authoritie : authorities) {
			egovLogger.debug("authoritie: {}", authoritie);
		}
	}

}
