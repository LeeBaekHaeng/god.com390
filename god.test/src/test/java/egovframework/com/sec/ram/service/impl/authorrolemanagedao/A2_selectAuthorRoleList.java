package egovframework.com.sec.ram.service.impl.authorrolemanagedao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.sec.ram.service.AuthorRoleManageVO;
import egovframework.com.sec.ram.service.impl.AuthorRoleManageDAO;
import god.test.GodTestAbstract;

public class A2_selectAuthorRoleList extends GodTestAbstract {

	@Autowired
	private AuthorRoleManageDAO dao;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		AuthorRoleManageVO authorRoleManageVO = new AuthorRoleManageVO();
//		authorRoleManageVO.setSearchKeyword("ROLE_ANONYMOUS");
//		authorRoleManageVO.setSearchKeyword("ROLE_USER");
		authorRoleManageVO.setSearchKeyword("ROLE_ADMIN");
		authorRoleManageVO.setFirstIndex(0);
		authorRoleManageVO.setRecordCountPerPage(10);

		List<AuthorRoleManageVO> results = null;

		try {
			results = dao.selectAuthorRoleList(authorRoleManageVO);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		egovLogger.debug("results: {}", results);

		results.forEach(result -> {
			egovLogger.debug("result: {}", result);
			egovLogger.debug("getRoleCode: {}", result.getRoleCode());
			egovLogger.debug("getRoleNm: {}", result.getRoleNm());
			egovLogger.debug("getRolePtn: {}", result.getRolePtn());
			egovLogger.debug("getRoleDc: {}", result.getRoleDc());
			egovLogger.debug("getRoleTyp: {}", result.getRoleTyp());
			egovLogger.debug("getRoleSort: {}", result.getRoleSort());
			egovLogger.debug("getAuthorCode: {}", result.getAuthorCode());
			egovLogger.debug("getRegYn: {}", result.getRegYn());
			egovLogger.debug("getCreatDt: {}", result.getCreatDt());
		});
	}

}
