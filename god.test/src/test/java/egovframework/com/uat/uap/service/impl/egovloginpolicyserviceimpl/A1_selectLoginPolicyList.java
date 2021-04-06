package egovframework.com.uat.uap.service.impl.egovloginpolicyserviceimpl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.uat.uap.service.EgovLoginPolicyService;
import egovframework.com.uat.uap.service.LoginPolicyVO;
import god.test.GodTestAbstract;

public class A1_selectLoginPolicyList extends GodTestAbstract {

	@Autowired
	EgovLoginPolicyService service;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		// given
		LoginPolicyVO loginPolicyVO = new LoginPolicyVO();
		loginPolicyVO.setFirstIndex(0);
		loginPolicyVO.setRecordCountPerPage(10);
		loginPolicyVO.setSearchKeyword("테스트1");
		loginPolicyVO.setSearchCondition("1");

		// when
		List<LoginPolicyVO> results = new ArrayList<>();
		try {
			results = service.selectLoginPolicyList(loginPolicyVO);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		// then
		assertEquals(results.get(0).getEmplyrNm(), loginPolicyVO.getSearchKeyword());

		egovLogger.debug("results={}", results);
	}

}
