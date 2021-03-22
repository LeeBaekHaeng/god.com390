package egovframework.com.sec.ram.service.impl.egovauthormanageserviceimpl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.sec.ram.service.AuthorManageVO;
import egovframework.com.sec.ram.service.EgovAuthorManageService;
import god.test.GodTestAbstract;

public class A4_selectAuthor extends GodTestAbstract {

	@Autowired
	EgovAuthorManageService egovAuthorManageService;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		// given
		AuthorManageVO authorManageVO = new AuthorManageVO();
		authorManageVO.setAuthorCode("ROLE_USER");
		AuthorManageVO selectAuthor = new AuthorManageVO();

		// when
		try {
			selectAuthor = egovAuthorManageService.selectAuthor(authorManageVO);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		// then
		assertEquals(authorManageVO.getAuthorCode(), selectAuthor.getAuthorCode());

		egovLogger.debug("selectAuthor={}", selectAuthor);
		egovLogger.debug("getAuthorCode={}", selectAuthor.getAuthorCode());
		egovLogger.debug("getAuthorNm={}", selectAuthor.getAuthorNm());
		egovLogger.debug("getAuthorDc={}", selectAuthor.getAuthorDc());
	}

}
