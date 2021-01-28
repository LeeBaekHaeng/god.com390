package egovframework.com.sec.ram.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.sec.ram.service.AuthorManage;
import god.test.GodTestAbstract;

public class A3_insertAuthor extends GodTestAbstract {

	@Autowired
	private AuthorManageDAO dao;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		AuthorManage authorManage = new AuthorManage();
		authorManage.setAuthorCode("ROLE_USER2");
		authorManage.setAuthorNm("일반 사용자2");
		authorManage.setAuthorDc("test 권한설명");

		insertAuthor(authorManage);
	}

	public void insertAuthor(AuthorManage authorManage) {
		try {
			dao.insertAuthor(authorManage);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}
	}

}
