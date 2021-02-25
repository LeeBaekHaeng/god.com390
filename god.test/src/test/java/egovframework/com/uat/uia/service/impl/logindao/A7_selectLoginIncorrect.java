package egovframework.com.uat.uia.service.impl.logindao;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cmm.LoginVO;
import egovframework.com.uat.uia.service.impl.LoginDAO;
import god.test.GodTestAbstract;

public class A7_selectLoginIncorrect extends GodTestAbstract {

	@Autowired
	private LoginDAO dao;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		LoginVO vo = new LoginVO();

		vo.setUserSe("GNR");

		vo.setId("USER");

		Map<?, ?> result = selectLoginIncorrect(vo);

		assertEquals(result.get("userId"), vo.getId());
	}

	public Map<?, ?> selectLoginIncorrect(LoginVO vo) {
		try {
			Map<?, ?> result = dao.selectLoginIncorrect(vo);

			egovLogger.debug("result: {}", result);
			egovLogger.debug("userId: {}", result.get("userId"));
			egovLogger.debug("userPw: {}", result.get("userPw"));
			egovLogger.debug("userNm: {}", result.get("userNm"));
			egovLogger.debug("uniqId: {}", result.get("uniqId"));
			egovLogger.debug("lockAt: {}", result.get("lockAt"));
			egovLogger.debug("lockCnt: {}", result.get("lockCnt"));

			return result;
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
			return null;
		}
	}

}
