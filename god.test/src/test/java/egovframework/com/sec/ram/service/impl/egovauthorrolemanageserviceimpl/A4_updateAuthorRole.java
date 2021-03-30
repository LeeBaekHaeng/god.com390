package egovframework.com.sec.ram.service.impl.egovauthorrolemanageserviceimpl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.sec.ram.service.AuthorRoleManage;
import egovframework.com.sec.ram.service.EgovAuthorRoleManageService;
import god.test.GodTestAbstract;

public class A4_updateAuthorRole extends GodTestAbstract {

	@Autowired
	EgovAuthorRoleManageService egovAuthorRoleManageService;

	@Override
	@Test
	@Deprecated
	public void test() {
		egovLogger.debug("test");

		// given
		AuthorRoleManage authorRoleManage = new AuthorRoleManage();

		// when
		boolean result = false;
		try {
			egovAuthorRoleManageService.updateAuthorRole(authorRoleManage);
			result = true;
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		// then
		assertEquals(result, true);

		egovLogger.debug("result={}", result);
	}

}
