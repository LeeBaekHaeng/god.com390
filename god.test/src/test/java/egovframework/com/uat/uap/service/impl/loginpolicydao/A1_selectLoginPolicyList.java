package egovframework.com.uat.uap.service.impl.loginpolicydao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.uat.uap.service.LoginPolicyVO;
import egovframework.com.uat.uap.service.impl.LoginPolicyDAO;
import god.test.GodTestAbstract;

public class A1_selectLoginPolicyList extends GodTestAbstract {

	@Autowired
	private LoginPolicyDAO dao;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		LoginPolicyVO loginPolicyVO = new LoginPolicyVO();
		loginPolicyVO.setFirstIndex(0);
		loginPolicyVO.setRecordCountPerPage(10);
//		loginPolicyVO.setSearchCondition("1");
//		loginPolicyVO.setSearchKeyword("테스트1");

		List<LoginPolicyVO> results = new ArrayList<>();

		try {
			results = dao.selectLoginPolicyList(loginPolicyVO);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		LoginPolicyVOLogger.debug(results);
	}

}
