package egovframework.com.uat.uap.service.impl.egovloginpolicyserviceimpl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.uat.uap.service.EgovLoginPolicyService;
import egovframework.com.uat.uap.service.LoginPolicy;
import god.test.GodTestAbstract;

//@Rollback(false)
public class A6_deleteLoginPolicy extends GodTestAbstract {

	@Autowired
	EgovLoginPolicyService service;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		// given
		LoginPolicy loginPolicy = new LoginPolicy();
		loginPolicy.setEmplyrId("TEST1");

		// when
		boolean result = false;
		try {
			service.deleteLoginPolicy(loginPolicy);
			result = true;
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		// then
		assertEquals(result, true);

		egovLogger.debug("result={}", result);
	}

}
