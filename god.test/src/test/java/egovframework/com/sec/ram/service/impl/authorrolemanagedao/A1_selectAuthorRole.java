package egovframework.com.sec.ram.service.impl.authorrolemanagedao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.sec.ram.service.AuthorRoleManageVO;
import egovframework.com.sec.ram.service.impl.AuthorRoleManageDAO;
import god.test.GodTestAbstract;

public class A1_selectAuthorRole extends GodTestAbstract {

	@Autowired
	private AuthorRoleManageDAO dao;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		egovLogger.debug("selectAuthorRole mybatis sql 없음");

		AuthorRoleManageVO authorRoleManageVO = new AuthorRoleManageVO();

		AuthorRoleManageVO result = null;

		try {
			result = dao.selectAuthorRole(authorRoleManageVO);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		egovLogger.debug("result: {}", result);
	}

}
