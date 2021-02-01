package egovframework.com.sec.ram.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.sec.ram.service.AuthorManageVO;
import god.test.GodTestAbstract;

public class A6_selectAuthorListTotCnt extends GodTestAbstract {

	@Autowired
	private AuthorManageDAO dao;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		AuthorManageVO authorManageVO = new AuthorManageVO();
		authorManageVO.setSearchCondition("1");
		authorManageVO.setSearchKeyword("일반 사용자");

		int selectAuthorListTotCnt = selectAuthorListTotCnt(authorManageVO);
		egovLogger.debug("selectAuthorListTotCnt: {}", selectAuthorListTotCnt);
	}

	public int selectAuthorListTotCnt(AuthorManageVO authorManageVO) {
		try {
			return dao.selectAuthorListTotCnt(authorManageVO);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
			return 0;
		}
	}

}
