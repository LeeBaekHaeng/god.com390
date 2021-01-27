package egovframework.com.sec.ram.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.sec.ram.service.AuthorManageVO;
import god.test.GodTestAbstract;

public class A2_selectAuthor extends GodTestAbstract {

	@Autowired
	private AuthorManageDAO dao;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		AuthorManageVO authorManageVO = new AuthorManageVO();
		authorManageVO.setAuthorCode("IS_AUTHENTICATED_ANONYMOUSLY");

		selectAuthor(authorManageVO);
	}

	public void selectAuthor(AuthorManageVO authorManageVO) {
		egovLogger.debug("selectAuthorList");

		AuthorManageVO result = null;

		try {
			result = dao.selectAuthor(authorManageVO);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		egovLogger.debug("result: {}", result);

		if (result == null) {
			return;
		}

		egovLogger.debug("getAuthorCode: {}", result.getAuthorCode());
		egovLogger.debug("getAuthorNm: {}", result.getAuthorNm());
		egovLogger.debug("getAuthorDc: {}", result.getAuthorDc());
		egovLogger.debug("getAuthorCreatDe: {}", result.getAuthorCreatDe());
	}

}
