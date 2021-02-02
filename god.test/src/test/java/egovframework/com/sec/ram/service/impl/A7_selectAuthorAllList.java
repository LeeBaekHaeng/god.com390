package egovframework.com.sec.ram.service.impl;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.sec.ram.service.AuthorManageVO;
import god.test.GodTestAbstract;

public class A7_selectAuthorAllList extends GodTestAbstract {

	@Autowired
	private AuthorManageDAO dao;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		AuthorManageVO authorManageVO = new AuthorManageVO();

		List<AuthorManageVO> results = selectAuthorListTotCnt(authorManageVO);
		egovLogger.debug("results: {}", results);
		egovLogger.debug("size: {}", results.size());

		results.forEach(result -> {
			egovLogger.debug("result: {}", result);
			egovLogger.debug("getAuthorCode: {}", result.getAuthorCode());
			egovLogger.debug("getAuthorNm: {}", result.getAuthorNm());
			egovLogger.debug("getAuthorDc: {}", result.getAuthorDc());
			egovLogger.debug("getAuthorCreatDe: {}", result.getAuthorCreatDe());
		});
	}

	public List<AuthorManageVO> selectAuthorListTotCnt(AuthorManageVO authorManageVO) {
		try {
			return dao.selectAuthorAllList(authorManageVO);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
			return null;
		}
	}

}
