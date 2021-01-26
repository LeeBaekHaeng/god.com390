package egovframework.com.sec.ram.service.impl;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.sec.ram.service.AuthorManageVO;
import god.test.GodTestAbstract;

public class A1_selectAuthorList extends GodTestAbstract {

	@Autowired
	private AuthorManageDAO dao;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		AuthorManageVO authorManageVO = new AuthorManageVO();

		selectAuthorList(authorManageVO);
	}

	@Test
	public void test2() {
		egovLogger.debug("test");

		AuthorManageVO authorManageVO = new AuthorManageVO();
		authorManageVO.setFirstIndex(0);
		authorManageVO.setRecordCountPerPage(10);
		authorManageVO.setSearchCondition("1");
		authorManageVO.setSearchKeyword("스프링시큐리티 내부사용(롤부여 금지)");

		selectAuthorList(authorManageVO);
	}

	@Test
	public void test3() {
		egovLogger.debug("test");

		AuthorManageVO authorManageVO = new AuthorManageVO();
		authorManageVO.setFirstIndex(0);
		authorManageVO.setRecordCountPerPage(10);
		authorManageVO.setSearchCondition("1");
		authorManageVO.setSearchKeyword("자");

		selectAuthorList(authorManageVO);
	}

	public void selectAuthorList(AuthorManageVO authorManageVO) {
		egovLogger.debug("selectAuthorList");

		List<AuthorManageVO> results = null;

		try {
			results = dao.selectAuthorList(authorManageVO);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		egovLogger.debug("results: {}", results);
		egovLogger.debug("size: {}", results.size());
	}

}
