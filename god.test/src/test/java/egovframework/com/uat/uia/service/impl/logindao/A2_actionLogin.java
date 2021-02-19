package egovframework.com.uat.uia.service.impl.logindao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cmm.LoginVO;
import egovframework.com.uat.uia.service.impl.LoginDAO;
import egovframework.com.utl.sim.service.EgovFileScrty;
import god.test.GodTestAbstract;

public class A2_actionLogin extends GodTestAbstract {

	@Autowired
	private LoginDAO dao;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		LoginVO vo = new LoginVO();

		vo.setUserSe("GNR");
//		vo.setUserSe("ENT");
//		vo.setUserSe("USR");

		vo.setId("USER");
		vo.setPassword("rhdxhd12");

		LoginVO result = actionLogin(vo);

		assertEquals(result.getUserSe(), vo.getUserSe());
		assertEquals(result.getUniqId(), vo.getUniqId());
	}

	@Test
	public void test2() {
		egovLogger.debug("test2");

		LoginVO vo = new LoginVO();

//		vo.setUserSe("GNR");
		vo.setUserSe("ENT");
//		vo.setUserSe("USR");

		vo.setId("ENTERPRISE");
		vo.setPassword("rhdxhd12");

		LoginVO result = actionLogin(vo);

		assertEquals(result.getUserSe(), vo.getUserSe());
		assertEquals(result.getUniqId(), vo.getUniqId());
	}

	@Test
	public void test3() {
		egovLogger.debug("test3");

		LoginVO vo = new LoginVO();

//		vo.setUserSe("GNR");
//		vo.setUserSe("ENT");
		vo.setUserSe("USR");

//		vo.setId("TEST1");
		vo.setId("webmaster");
		vo.setPassword("rhdxhd12");

		LoginVO result = actionLogin(vo);

		assertEquals(result.getUserSe(), vo.getUserSe());
		assertEquals(result.getUniqId(), vo.getUniqId());
	}

	public LoginVO actionLogin(LoginVO vo) {
		egovLogger.debug("actionLogin");
		LoginVO result = null;

		try {
			String enpassword = EgovFileScrty.encryptPassword(vo.getPassword(), vo.getId());
			vo.setPassword(enpassword);

			result = dao.actionLogin(vo);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		egovLogger.debug("result: {}", result);
		egovLogger.debug("getUserSe: {}", result.getUserSe());
		egovLogger.debug("getUniqId: {}", result.getUniqId());
		egovLogger.debug("getId: {}", result.getId());
		egovLogger.debug("getPassword: {}", result.getPassword());

		return result;
	}

}
