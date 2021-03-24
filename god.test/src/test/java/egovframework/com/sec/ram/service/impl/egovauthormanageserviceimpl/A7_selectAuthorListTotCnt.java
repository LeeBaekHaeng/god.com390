package egovframework.com.sec.ram.service.impl.egovauthormanageserviceimpl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.sec.ram.service.AuthorManageVO;
import egovframework.com.sec.ram.service.EgovAuthorManageService;
import god.test.GodTestAbstract;

public class A7_selectAuthorListTotCnt extends GodTestAbstract {

	@Autowired
	EgovAuthorManageService egovAuthorManageService;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		// given
		AuthorManageVO authorManageVO = new AuthorManageVO();
		authorManageVO.setSearchCondition("1");
		authorManageVO.setSearchKeyword("일반 사용자");

		// when
		int selectAuthorListTotCnt = 0;
		try {
			selectAuthorListTotCnt = egovAuthorManageService.selectAuthorListTotCnt(authorManageVO);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		// then
		assertEquals(selectAuthorListTotCnt, 1);

		egovLogger.debug("selectAuthorListTotCnt={}", selectAuthorListTotCnt);
	}

}
