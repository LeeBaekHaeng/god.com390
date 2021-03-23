package egovframework.com.sec.ram.service.impl.egovauthormanageserviceimpl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.sec.ram.service.AuthorManage;
import egovframework.com.sec.ram.service.AuthorManageVO;
import egovframework.com.sec.ram.service.EgovAuthorManageService;
import god.test.GodTestAbstract;

public class A6_updateAuthor extends GodTestAbstract {

	@Autowired
	EgovAuthorManageService egovAuthorManageService;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		// given
		AuthorManage authorManage = new AuthorManage();
		authorManage.setAuthorCode("ROLE_USER");
		authorManage.setAuthorNm("test 일반 사용자");
		authorManage.setAuthorDc("test 일반 사용자");

		// when
		AuthorManageVO authorManageVO = new AuthorManageVO();
		authorManageVO.setAuthorCode(authorManage.getAuthorCode());
		AuthorManageVO selectAuthor = new AuthorManageVO();
		try {
			egovAuthorManageService.updateAuthor(authorManage);
			selectAuthor = egovAuthorManageService.selectAuthor(authorManageVO);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		// then
		assertEquals(selectAuthor.getAuthorCode(), authorManage.getAuthorCode());
		assertEquals(selectAuthor.getAuthorNm(), authorManage.getAuthorNm());
		assertEquals(selectAuthor.getAuthorDc(), authorManage.getAuthorDc());

		egovLogger.debug("selectAuthor={}", selectAuthor);
		egovLogger.debug("getAuthorCode={}", selectAuthor.getAuthorCode());
		egovLogger.debug("getAuthorNm={}", selectAuthor.getAuthorNm());
		egovLogger.debug("getAuthorDc={}", selectAuthor.getAuthorDc());
	}

}
