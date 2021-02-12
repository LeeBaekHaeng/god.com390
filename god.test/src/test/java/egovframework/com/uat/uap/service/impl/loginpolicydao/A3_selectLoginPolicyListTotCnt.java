package egovframework.com.uat.uap.service.impl.loginpolicydao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.uat.uap.service.LoginPolicyVO;
import egovframework.com.uat.uap.service.impl.LoginPolicyDAO;
import god.test.GodTestAbstract;

public class A3_selectLoginPolicyListTotCnt extends GodTestAbstract {

	@Autowired
	private LoginPolicyDAO dao;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");
		LoginPolicyVO loginPolicyVO = new LoginPolicyVO();
		int result = selectLoginPolicyListTotCnt(loginPolicyVO);
		egovLogger.debug("result: {}", result);
		assertEquals(result, 4);
	}

	@Test
	public void test2() {
		LoginPolicyVO loginPolicyVO = new LoginPolicyVO();
		loginPolicyVO.setSearchCondition("1");
		loginPolicyVO.setSearchKeyword("테스트1");
		int result = selectLoginPolicyListTotCnt(loginPolicyVO);
		egovLogger.debug("result: {}", result);
		assertEquals(result, 1);
	}

	@Test
	public void test3() {
		int result = selectLoginPolicyListTotCnt("일반회원");
		egovLogger.debug("result: {}", result);
		assertEquals(result, 1);
	}

	@Test
	public void test4() {
		int result = selectLoginPolicyListTotCnt("NIA");
		egovLogger.debug("result: {}", result);
		assertEquals(result, 1);
	}

	@Test
	public void test5() {
		int result = selectLoginPolicyListTotCnt("웹마스터");
		egovLogger.debug("result: {}", result);
		assertEquals(result, 1);
	}

	public int selectLoginPolicyListTotCnt(String searchKeyword) {
		LoginPolicyVO loginPolicyVO = new LoginPolicyVO();
		loginPolicyVO.setSearchCondition("1");
		loginPolicyVO.setSearchKeyword(searchKeyword);
		int result = selectLoginPolicyListTotCnt(loginPolicyVO);
		return result;
	}

	public int selectLoginPolicyListTotCnt(LoginPolicyVO loginPolicyVO) {
		try {
			return dao.selectLoginPolicyListTotCnt(loginPolicyVO);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
			return 0;
		}
	}

}
