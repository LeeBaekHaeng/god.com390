package egovframework.com.uat.uap.service.impl.egovloginpolicyserviceimpl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.uat.uap.service.EgovLoginPolicyService;
import egovframework.com.uat.uap.service.LoginPolicy;
import god.test.GodTestAbstract;

//@Rollback(false)
public class A4_insertLoginPolicy extends GodTestAbstract {

	@Autowired
	EgovLoginPolicyService service;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		// given
		LoginPolicy loginPolicy = new LoginPolicy();
		loginPolicy.setEmplyrId("TEST1");
		loginPolicy.setIpInfo("127.0.0.1");
		loginPolicy.setDplctPermAt("Y");
		loginPolicy.setLmttAt("Y");

		// when
		boolean result = false;
		try {
			service.insertLoginPolicy(loginPolicy);
			result = true;
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		// then
		assertEquals(result, true);

		egovLogger.debug("result={}", result);
	}

}
