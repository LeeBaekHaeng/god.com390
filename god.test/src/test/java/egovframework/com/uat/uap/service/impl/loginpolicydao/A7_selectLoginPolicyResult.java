package egovframework.com.uat.uap.service.impl.loginpolicydao;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.uat.uap.service.LoginPolicy;
import egovframework.com.uat.uap.service.LoginPolicyVO;
import egovframework.com.uat.uap.service.impl.LoginPolicyDAO;
import god.test.GodTestAbstract;

public class A7_selectLoginPolicyResult extends GodTestAbstract {

	@Autowired
	private LoginPolicyDAO dao;

	@Override
	@Before
	public void setUp() throws Exception {
		LoginPolicy loginPolicy = new LoginPolicy();
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

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");
		LoginPolicyVO loginPolicyVO = new LoginPolicyVO();
		loginPolicyVO.setEmplyrId("TEST1");

		LoginPolicyVO result = null;

		try {
			result = dao.selectLoginPolicyResult(loginPolicyVO);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		egovLogger.debug("result: {}", result);

		assertEquals(result, null);
	}

}
