package egovframework.com.sec.ram.service.impl.egovauthormanageserviceimpl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.sec.ram.service.AuthorManageVO;
import egovframework.com.sec.ram.service.EgovAuthorManageService;
import god.test.GodTestAbstract;

public class A5_selectAuthorList extends GodTestAbstract {

	@Autowired
	EgovAuthorManageService egovAuthorManageService;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		// given
		AuthorManageVO authorManageVO = new AuthorManageVO();
		authorManageVO.setFirstIndex(0);
		authorManageVO.setRecordCountPerPage(10);
		authorManageVO.setSearchCondition("1");
		authorManageVO.setSearchKeyword("일반 사용자");

		// when
		List<AuthorManageVO> results = new ArrayList<>();
		try {
			results = egovAuthorManageService.selectAuthorList(authorManageVO);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}
		AuthorManageVO result = results.get(0);

		// then
		assertEquals(results.isEmpty(), false);
		assertEquals(result.getAuthorNm(), authorManageVO.getSearchKeyword());

		egovLogger.debug("results={}", results);

		results.forEach(action -> {
			egovLogger.debug("getAuthorCode={}", action.getAuthorCode());
			egovLogger.debug("getAuthorNm={}", action.getAuthorNm());
			egovLogger.debug("getAuthorDc={}", action.getAuthorDc());
			egovLogger.debug("getAuthorCreatDe={}", action.getAuthorCreatDe());

		});
	}

}
