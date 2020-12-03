package egovframework.com.cmm.service.impl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.CmmnDetailCode;
import god.test.GodTestAbstract;

public class CmmUseDAOTest extends GodTestAbstract {

	@Autowired
	@Qualifier("cmmUseDAO")
	private CmmUseDAO cmmUseDAO;

	@Override
	@Test
	public void test() {
		egovLogger.info("test");

		ComDefaultCodeVO vo = new ComDefaultCodeVO();
		vo.setCodeId("COM001");

		egovLogger.debug("vo: {}", vo);

		List<CmmnDetailCode> results = selectCmmCodeDetail(vo);

		egovLogger.debug("results: {}", results);

		for (CmmnDetailCode result : results) {
			egovLogger.debug("result: {}", result);
			egovLogger.debug("getCodeId: {}", result.getCodeId());
			egovLogger.debug("getCode: {}", result.getCode());
			egovLogger.debug("getCodeNm: {}", result.getCodeNm());
			egovLogger.debug("getCodeDc: {}", result.getCodeDc());

			assertEquals(result.getCodeId(), vo.getCodeId());
		}
	}

	private List<CmmnDetailCode> selectCmmCodeDetail(ComDefaultCodeVO vo) {
		try {
			return cmmUseDAO.selectCmmCodeDetail(vo);
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}

}
