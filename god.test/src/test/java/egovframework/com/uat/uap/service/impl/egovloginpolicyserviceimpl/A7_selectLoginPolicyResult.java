package egovframework.com.uat.uap.service.impl.egovloginpolicyserviceimpl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.uat.uap.service.EgovLoginPolicyService;
import egovframework.com.uat.uap.service.LoginPolicyVO;
import god.test.GodTestAbstract;

//@Rollback(false)
public class A7_selectLoginPolicyResult extends GodTestAbstract {

	@Autowired
	EgovLoginPolicyService service;

	@Override
	@Test
	@Deprecated
	public void test() {
		egovLogger.debug("test");

		// given
		LoginPolicyVO loginPolicyVO = new LoginPolicyVO();

		// when
		LoginPolicyVO result = null;
		try {
			result = service.selectLoginPolicyResult(loginPolicyVO);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		// then
		assertEquals(result, null);

		egovLogger.debug("result={}", result);
	}

}
