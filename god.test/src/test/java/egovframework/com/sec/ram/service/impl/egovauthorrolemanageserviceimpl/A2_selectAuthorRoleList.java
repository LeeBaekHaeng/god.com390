package egovframework.com.sec.ram.service.impl.egovauthorrolemanageserviceimpl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.sec.ram.service.AuthorRoleManageVO;
import egovframework.com.sec.ram.service.EgovAuthorRoleManageService;
import god.test.GodTestAbstract;

public class A2_selectAuthorRoleList extends GodTestAbstract {

	@Autowired
	EgovAuthorRoleManageService egovAuthorRoleManageService;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		// given
		AuthorRoleManageVO authorRoleManageVO = new AuthorRoleManageVO();
		authorRoleManageVO.setSearchKeyword("ROLE_USER");
		authorRoleManageVO.setRecordCountPerPage(10);
		authorRoleManageVO.setFirstIndex(0);

		// when
		List<AuthorRoleManageVO> results = new ArrayList<>();
		try {
			results = egovAuthorRoleManageService.selectAuthorRoleList(authorRoleManageVO);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		// then
		assertEquals(results.get(2).getAuthorCode(), authorRoleManageVO.getSearchKeyword());

		egovLogger.debug("results={}", results);
	}

}
