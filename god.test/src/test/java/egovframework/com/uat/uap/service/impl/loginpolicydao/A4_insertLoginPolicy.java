package egovframework.com.uat.uap.service.impl.loginpolicydao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.uat.uap.service.LoginPolicy;
import egovframework.com.uat.uap.service.LoginPolicyVO;
import egovframework.com.uat.uap.service.impl.LoginPolicyDAO;
import god.test.GodTestAbstract;

public class A4_insertLoginPolicy extends GodTestAbstract {

	@Autowired
	private LoginPolicyDAO dao;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");
		LoginPolicy loginPolicy = new LoginPolicyVO();
		loginPolicy.setEmplyrId("TEST1");
		loginPolicy.setIpInfo("test IP정보");
		loginPolicy.setDplctPermAt("Y");
		loginPolicy.setLmttAt("Y");

		try {
			dao.insertLoginPolicy(loginPolicy);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}
	}

}
