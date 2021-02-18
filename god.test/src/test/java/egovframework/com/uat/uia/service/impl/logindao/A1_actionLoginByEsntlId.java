package egovframework.com.uat.uia.service.impl.logindao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cmm.LoginVO;
import egovframework.com.uat.uia.service.impl.LoginDAO;
import god.test.GodTestAbstract;

public class A1_actionLoginByEsntlId extends GodTestAbstract {

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

		vo.setUniqId("USRCNFRM_00000000001");

		LoginVO result = actionLoginByEsntlId(vo);

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

		vo.setUniqId("USRCNFRM_00000000002");

		LoginVO result = actionLoginByEsntlId(vo);

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

		vo.setUniqId("USRCNFRM_00000000000");
//		vo.setUniqId("USRCNFRM_99999999999");

		LoginVO result = actionLoginByEsntlId(vo);

		assertEquals(result.getUserSe(), vo.getUserSe());
		assertEquals(result.getUniqId(), vo.getUniqId());
	}

	public LoginVO actionLoginByEsntlId(LoginVO vo) {
		egovLogger.debug("actionLoginByEsntlId");
		LoginVO result = null;

		try {
			result = dao.actionLoginByEsntlId(vo);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		egovLogger.debug("result: {}", result);
		egovLogger.debug("getUserSe: {}", result.getUserSe());
		egovLogger.debug("getUniqId: {}", result.getUniqId());

		return result;
	}

}
