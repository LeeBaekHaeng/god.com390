package egovframework.com.uat.uia.service.impl.logindao;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cmm.LoginVO;
import egovframework.com.uat.uia.service.impl.LoginDAO;
import god.test.GodTestAbstract;

public class A8_updateLoginIncorrect extends GodTestAbstract {

	@Autowired
	private LoginDAO dao;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		Map<String, Object> map = new HashMap<>();
		map.put("USER_SE", "GNR");
//		map.put("updateAt", "E");
		map.put("updateAt", "L");
//		map.put("updateAt", "C");
		map.put("id", "USER");

		updateLoginIncorrect(map);

		LoginVO vo = new LoginVO();
		vo.setUserSe((String) map.get("USER_SE"));
		vo.setId((String) map.get("id"));
		Map<?, ?> result = null;
		try {
			result = dao.selectLoginIncorrect(vo);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}
		egovLogger.debug("result: {}", result);
		egovLogger.debug("userId: {}", result.get("userId"));
		egovLogger.debug("userPw: {}", result.get("userPw"));
		egovLogger.debug("userNm: {}", result.get("userNm"));
		egovLogger.debug("uniqId: {}", result.get("uniqId"));
		egovLogger.debug("lockAt: {}", result.get("lockAt"));
		egovLogger.debug("lockCnt: {}", result.get("lockCnt"));

	}

	@Test
	public void test2() {
		egovLogger.debug("test2");

		Map<String, Object> map = new HashMap<>();
		map.put("USER_SE", "ENT");
		map.put("updateAt", "E");
//		map.put("updateAt", "L");
//		map.put("updateAt", "C");
		map.put("id", "ENTERPRISE");

		updateLoginIncorrect(map);

		LoginVO vo = new LoginVO();
		vo.setUserSe((String) map.get("USER_SE"));
		vo.setId((String) map.get("id"));
		Map<?, ?> result = null;
		try {
			result = dao.selectLoginIncorrect(vo);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}
		egovLogger.debug("result: {}", result);
		egovLogger.debug("userId: {}", result.get("userId"));
		egovLogger.debug("userPw: {}", result.get("userPw"));
		egovLogger.debug("userNm: {}", result.get("userNm"));
		egovLogger.debug("uniqId: {}", result.get("uniqId"));
		egovLogger.debug("lockAt: {}", result.get("lockAt"));
		egovLogger.debug("lockCnt: {}", result.get("lockCnt"));

	}

	@Test
	public void test3() {
		egovLogger.debug("test3");

		Map<String, Object> map = new HashMap<>();
		map.put("USER_SE", "USR");
//		map.put("updateAt", "E");
		map.put("updateAt", "L");
//		map.put("updateAt", "C");
//		map.put("id", "TEST1");
		map.put("id", "webmaster");

		updateLoginIncorrect(map);

		LoginVO vo = new LoginVO();
		vo.setUserSe((String) map.get("USER_SE"));
		vo.setId((String) map.get("id"));
		Map<?, ?> result = null;
		try {
			result = dao.selectLoginIncorrect(vo);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}
		egovLogger.debug("result: {}", result);
		egovLogger.debug("userId: {}", result.get("userId"));
		egovLogger.debug("userPw: {}", result.get("userPw"));
		egovLogger.debug("userNm: {}", result.get("userNm"));
		egovLogger.debug("uniqId: {}", result.get("uniqId"));
		egovLogger.debug("lockAt: {}", result.get("lockAt"));
		egovLogger.debug("lockCnt: {}", result.get("lockCnt"));

	}

	public void updateLoginIncorrect(Map<?, ?> map) {
		try {
			dao.updateLoginIncorrect(map);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}
	}

}
