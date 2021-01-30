package egovframework.com.sec.ram.service.impl;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.sec.ram.service.AuthorManage;
import egovframework.com.sec.ram.service.AuthorManageVO;
import egovframework.rte.fdl.string.EgovDateUtil;
import god.test.GodTestAbstract;

public class A4_updateAuthor extends GodTestAbstract {

	@Autowired
	private AuthorManageDAO dao;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		String today = EgovDateUtil.toString(new Date(), null, null);

		AuthorManage authorManage = new AuthorManage();
		authorManage.setAuthorCode("ROLE_USER");
		authorManage.setAuthorNm("test 일반 사용자 " + today);
		authorManage.setAuthorDc("test 권한설명 " + today);

		updateAuthor(authorManage);

		AuthorManageVO authorManageVO = new AuthorManageVO();
		authorManageVO.setAuthorCode(authorManage.getAuthorCode());
		selectAuthor(authorManageVO);
	}

	public void updateAuthor(AuthorManage authorManage) {
		try {
			dao.updateAuthor(authorManage);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}
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
