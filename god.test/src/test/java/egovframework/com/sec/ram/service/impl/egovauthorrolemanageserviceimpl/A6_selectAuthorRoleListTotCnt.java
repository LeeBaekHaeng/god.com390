package egovframework.com.sec.ram.service.impl.egovauthorrolemanageserviceimpl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.sec.ram.service.AuthorRoleManageVO;
import egovframework.com.sec.ram.service.EgovAuthorRoleManageService;
import god.test.GodTestAbstract;

public class A6_selectAuthorRoleListTotCnt extends GodTestAbstract {

	@Autowired
	EgovAuthorRoleManageService egovAuthorRoleManageService;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		// given
		AuthorRoleManageVO authorRoleManageVO = new AuthorRoleManageVO();
		authorRoleManageVO.setSearchKeyword("ROLE_USER");

		// when
		int result = 0;
		try {
			result = egovAuthorRoleManageService.selectAuthorRoleListTotCnt(authorRoleManageVO);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		// then
		assertEquals(result, 11);

		egovLogger.debug("result={}", result);
	}

}
