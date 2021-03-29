package egovframework.com.sec.ram.service.impl.egovauthorrolemanageserviceimpl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.sec.ram.service.AuthorRoleManage;
import egovframework.com.sec.ram.service.EgovAuthorRoleManageService;
import god.test.GodTestAbstract;

public class A3_insertAuthorRole extends GodTestAbstract {

	@Autowired
	EgovAuthorRoleManageService egovAuthorRoleManageService;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		// given
		AuthorRoleManage authorRoleManage = new AuthorRoleManage();
		authorRoleManage.setAuthorCode("ROLE_USER");
		authorRoleManage.setRoleCode("web-000011");

		// when
		boolean result = false;
		try {
			egovAuthorRoleManageService.insertAuthorRole(authorRoleManage);
			result = true;
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		// then
		assertEquals(result, true);

		egovLogger.debug("result={}", result);
	}

}
