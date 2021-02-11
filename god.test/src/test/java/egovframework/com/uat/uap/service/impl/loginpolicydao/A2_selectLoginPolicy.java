package egovframework.com.uat.uap.service.impl.loginpolicydao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.uat.uap.service.LoginPolicyVO;
import egovframework.com.uat.uap.service.impl.LoginPolicyDAO;
import god.test.GodTestAbstract;

public class A2_selectLoginPolicy extends GodTestAbstract {

	@Autowired
	private LoginPolicyDAO dao;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		LoginPolicyVO loginPolicyVO = new LoginPolicyVO();
		loginPolicyVO.setEmplyrId("TEST1");
//		loginPolicyVO.setEmplyrId("USER");
//		loginPolicyVO.setEmplyrId("ENTERPRISE");
//		loginPolicyVO.setEmplyrId("webmaster");

		LoginPolicyVO result = null;
//		LoginPolicyVO result = new LoginPolicyVO();

		try {
			result = dao.selectLoginPolicy(loginPolicyVO);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		LoginPolicyVOLogger.debug(result);

		assertEquals(result.getEmplyrId(), loginPolicyVO.getEmplyrId());
	}

}
