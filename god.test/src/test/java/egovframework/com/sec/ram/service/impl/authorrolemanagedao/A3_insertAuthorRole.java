package egovframework.com.sec.ram.service.impl.authorrolemanagedao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.sec.ram.service.AuthorRoleManage;
import egovframework.com.sec.ram.service.impl.AuthorRoleManageDAO;
import god.test.GodTestAbstract;

public class A3_insertAuthorRole extends GodTestAbstract {

	@Autowired
	private AuthorRoleManageDAO dao;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		AuthorRoleManage authorRoleManage = new AuthorRoleManage();
		authorRoleManage.setAuthorCode("ROLE_ADMIN");
		authorRoleManage.setRoleCode("web-000001");

		boolean result = false;

		try {
			dao.insertAuthorRole(authorRoleManage);
			result = true;
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		egovLogger.debug("result: {}", result);
	}

}
