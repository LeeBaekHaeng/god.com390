package egovframework.com.uat.uia.service.impl.logindao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cmm.LoginVO;
import egovframework.com.uat.uia.service.impl.LoginDAO;
import god.test.GodTestAbstract;

public class A4_searchId extends GodTestAbstract {

	@Autowired
	private LoginDAO dao;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		LoginVO vo = new LoginVO();

		vo.setUserSe("GNR");
		vo.setName("일반회원");
		vo.setEmail("egovframesupport@gmail.com");

		LoginVO result = actionLogin(vo);

		assertEquals(result.getId(), "USER");
	}

	@Test
	public void test2() {
		egovLogger.debug("test2");

		LoginVO vo = new LoginVO();

		vo.setUserSe("ENT");
		vo.setName("NIA");
		vo.setEmail("egovframesupport@gmail.com");

		LoginVO result = actionLogin(vo);

		assertEquals(result.getId(), "ENTERPRISE");
	}

	@Test
	public void test3() {
		egovLogger.debug("test3");

		LoginVO vo = new LoginVO();

		vo.setUserSe("USR");
		vo.setName("테스트1");
		vo.setEmail("egovframesupport@gmail.com");

		LoginVO result = actionLogin(vo);

		assertEquals(result.getId(), "TEST1");
	}

	public LoginVO actionLogin(LoginVO vo) {
		egovLogger.debug("actionLogin");
		LoginVO result = null;

		try {
			result = dao.searchId(vo);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		egovLogger.debug("result: {}", result);
		egovLogger.debug("getId: {}", result.getId());

		return result;
	}

}
