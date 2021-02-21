package egovframework.com.uat.uia.service.impl.logindao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cmm.LoginVO;
import egovframework.com.uat.uia.service.impl.LoginDAO;
import god.test.GodTestAbstract;

public class A3_actionCrtfctLogin extends GodTestAbstract {

	@Autowired
	private LoginDAO dao;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		LoginVO vo = new LoginVO();

		vo.setDn("DN_00000000000");

		LoginVO result = actionLogin(vo);

		assertEquals(result.getDn(), null);
		assertEquals(result.getId(), "TEST1");
	}

	@Test
	public void test2() {
		egovLogger.debug("test");

		LoginVO vo = new LoginVO();

		vo.setDn("DN_99999999999");

		LoginVO result = actionLogin(vo);

		assertEquals(result.getDn(), null);
		assertEquals(result.getId(), "webmaster");
	}

	public LoginVO actionLogin(LoginVO vo) {
		egovLogger.debug("actionLogin");
		LoginVO result = null;

		try {
			result = dao.actionCrtfctLogin(vo);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		egovLogger.debug("result: {}", result);
		egovLogger.debug("getUserSe: {}", result.getUserSe());
		egovLogger.debug("getUniqId: {}", result.getUniqId());
		egovLogger.debug("getId: {}", result.getId());
		egovLogger.debug("getPassword: {}", result.getPassword());
		egovLogger.debug("getDn: {}", result.getDn());

		return result;
	}

}
