package egovframework.com.sec.ram.service.impl.authorrolemanagedao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.sec.ram.service.AuthorRoleManageVO;
import egovframework.com.sec.ram.service.impl.AuthorRoleManageDAO;
import god.test.GodTestAbstract;

public class A6_selectAuthorRoleListTotCnt extends GodTestAbstract {

	@Autowired
	private AuthorRoleManageDAO dao;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		List<Integer> cnts = new ArrayList<>();

		cnt("ROLE_ANONYMOUS", cnts);
		cnt("ROLE_USER", cnts);
		cnt("ROLE_ADMIN", cnts);

		cnts.forEach(cnt -> egovLogger.debug("cnt: {}", cnt));
	}

	public void cnt(String searchKeyword, List<Integer> cnts) {
		egovLogger.debug("selectAuthorRoleListTotCnt");

		AuthorRoleManageVO authorRoleManageVO = new AuthorRoleManageVO();
		authorRoleManageVO.setSearchKeyword(searchKeyword);

		int result = 0;

		try {
			result = dao.selectAuthorRoleListTotCnt(authorRoleManageVO);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		egovLogger.debug("result: {}", result);

		cnts.add(result);
	}

}
