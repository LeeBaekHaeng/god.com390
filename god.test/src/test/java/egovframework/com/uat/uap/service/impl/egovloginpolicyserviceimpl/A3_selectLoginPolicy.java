package egovframework.com.uat.uap.service.impl.egovloginpolicyserviceimpl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.uat.uap.service.EgovLoginPolicyService;
import egovframework.com.uat.uap.service.LoginPolicyVO;
import god.test.GodTestAbstract;

public class A3_selectLoginPolicy extends GodTestAbstract {

	@Autowired
	EgovLoginPolicyService service;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		// given
		LoginPolicyVO loginPolicyVO = new LoginPolicyVO();
		loginPolicyVO.setEmplyrId("TEST1");

		// when
		LoginPolicyVO result = new LoginPolicyVO();
		try {
			result = service.selectLoginPolicy(loginPolicyVO);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		// then
		assertEquals(result.getEmplyrId(), loginPolicyVO.getEmplyrId());

		egovLogger.debug("result={}", result);
		egovLogger.debug("getEmplyrId={}", result.getEmplyrId());
	}

}
