package egovframework.com.uat.uap.service.impl.egovloginpolicyserviceimpl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.uat.uap.service.EgovLoginPolicyService;
import egovframework.com.uat.uap.service.LoginPolicyVO;
import god.test.GodTestAbstract;

public class A2_selectLoginPolicyListTotCnt extends GodTestAbstract {

	@Autowired
	EgovLoginPolicyService service;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		// given
		LoginPolicyVO loginPolicyVO = new LoginPolicyVO();
		loginPolicyVO.setSearchKeyword("테스트1");
		loginPolicyVO.setSearchCondition("1");

		// when
		int result = 0;
		try {
			result = service.selectLoginPolicyListTotCnt(loginPolicyVO);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		// then
		assertEquals(result, 1);

		egovLogger.debug("result={}", result);
	}

}
