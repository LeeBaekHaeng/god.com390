package egovframework.com.sec.ram.service.impl.egovauthorrolemanageserviceimpl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.sec.ram.service.AuthorRoleManageVO;
import egovframework.com.sec.ram.service.EgovAuthorRoleManageService;
import god.test.GodTestAbstract;

public class A1_selectAuthorRole extends GodTestAbstract {

	@Autowired
	EgovAuthorRoleManageService egovAuthorRoleManageService;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		// given
		AuthorRoleManageVO authorRoleManageVO = new AuthorRoleManageVO();

		// when
		AuthorRoleManageVO result = new AuthorRoleManageVO();
		try {
			result = egovAuthorRoleManageService.selectAuthorRole(authorRoleManageVO);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		// then
		assertEquals(result.getAuthorRole(), null);

		egovLogger.debug("result={}", result);
	}

}
