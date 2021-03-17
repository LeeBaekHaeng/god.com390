package egovframework.com.sec.ram.service.impl.egovauthormanageserviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.sec.ram.service.AuthorManageVO;
import egovframework.com.sec.ram.service.EgovAuthorManageService;
import god.test.GodTestAbstract;

public class A1_selectAuthorAllList extends GodTestAbstract {

	@Autowired
	EgovAuthorManageService egovAuthorManageService;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		AuthorManageVO authorManageVO = new AuthorManageVO();

		List<AuthorManageVO> results = new ArrayList<>();

		try {
			results = egovAuthorManageService.selectAuthorAllList(authorManageVO);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		egovLogger.debug("results={}", results);
		egovLogger.debug("size={}", results.size());

		results.forEach(result -> {
			egovLogger.debug("getAuthorCode={}", result.getAuthorCode());
			egovLogger.debug("getAuthorNm={}", result.getAuthorNm());
			egovLogger.debug("getAuthorDc={}", result.getAuthorDc());
			egovLogger.debug("getAuthorCreatDe={}", result.getAuthorCreatDe());
		});
	}

}
