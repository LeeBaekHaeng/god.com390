package egovframework.com.uat.uia.service.impl.logindao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cmm.LoginVO;
import egovframework.com.uat.uia.service.impl.LoginDAO;
import egovframework.rte.fdl.cryptography.EgovPasswordEncoder;
import god.test.GodTestAbstract;

public class A6_updatePassword extends GodTestAbstract {

	@Autowired
	private LoginDAO dao;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		LoginVO vo = new LoginVO();

		vo.setUserSe("GNR");

		vo.setId("USER");

		vo.setPassword(new EgovPasswordEncoder().encryptPassword("rhdxhd12"));

		updatePassword(vo);
	}

	public void updatePassword(LoginVO vo) {
		try {
			dao.updatePassword(vo);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}
	}

}
