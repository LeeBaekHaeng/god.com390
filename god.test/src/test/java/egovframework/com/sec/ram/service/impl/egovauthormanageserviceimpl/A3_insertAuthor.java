package egovframework.com.sec.ram.service.impl.egovauthormanageserviceimpl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.sec.ram.service.AuthorManage;
import egovframework.com.sec.ram.service.AuthorManageVO;
import egovframework.com.sec.ram.service.EgovAuthorManageService;
import god.test.GodTestAbstract;

public class A3_insertAuthor extends GodTestAbstract {

	@Autowired
	EgovAuthorManageService egovAuthorManageService;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		// given
		AuthorManage authorManage = new AuthorManage();
		authorManage.setAuthorCode("test");
		authorManage.setAuthorNm("test 권한명");
		authorManage.setAuthorDc("test 권한설명");

		AuthorManageVO authorManageVO = new AuthorManageVO();
		authorManageVO.setAuthorCode(authorManage.getAuthorCode());
		AuthorManageVO selectAuthor = new AuthorManageVO();

		// when
		try {
			egovAuthorManageService.insertAuthor(authorManage);
			selectAuthor = egovAuthorManageService.selectAuthor(authorManageVO);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		// then
		assertEquals(authorManage.getAuthorCode(), selectAuthor.getAuthorCode());
		assertEquals(authorManage.getAuthorNm(), selectAuthor.getAuthorNm());
		assertEquals(authorManage.getAuthorDc(), selectAuthor.getAuthorDc());

		egovLogger.debug("selectAuthor={}", selectAuthor);
		egovLogger.debug("getAuthorCode={}", selectAuthor.getAuthorCode());
		egovLogger.debug("getAuthorNm={}", selectAuthor.getAuthorNm());
		egovLogger.debug("getAuthorDc={}", selectAuthor.getAuthorDc());
	}

}
