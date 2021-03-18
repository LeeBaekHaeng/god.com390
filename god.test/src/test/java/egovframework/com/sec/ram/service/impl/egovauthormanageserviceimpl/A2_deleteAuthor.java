package egovframework.com.sec.ram.service.impl.egovauthormanageserviceimpl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.sec.ram.service.AuthorManage;
import egovframework.com.sec.ram.service.EgovAuthorManageService;
import god.test.GodTestAbstract;

public class A2_deleteAuthor extends GodTestAbstract {

	@Autowired
	EgovAuthorManageService egovAuthorManageService;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		AuthorManage authorManage = new AuthorManage();
		authorManage.setAuthorCode("test");

		try {
			egovAuthorManageService.deleteAuthor(authorManage);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}
	}

}
