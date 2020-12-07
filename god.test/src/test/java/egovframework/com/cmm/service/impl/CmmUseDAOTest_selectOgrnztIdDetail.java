package egovframework.com.cmm.service.impl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.CmmnDetailCode;
import egovframework.com.cmm.service.EgovCmmUseService;
import god.test.GodTestAbstract;

public class CmmUseDAOTest_selectOgrnztIdDetail extends GodTestAbstract {

	@Autowired
	@Qualifier("EgovCmmUseService")
	private EgovCmmUseService egovCmmUseService;

	@Override
	@Test
	public void test() {
		ComDefaultCodeVO vo = new ComDefaultCodeVO();
		vo.setTableNm("COMTNORGNZTINFO");
		vo.setHaveDetailCondition("Y");
		vo.setDetailCondition("ORGNZT_0000000000000");

		egovLogger.debug("vo: {}", vo);

		List<CmmnDetailCode> results = selectOgrnztIdDetail(vo);

		egovLogger.debug("results: {}", results);

		for (CmmnDetailCode result : results) {
			egovLogger.debug("result: {}", result);
			egovLogger.debug("getCodeId: {}", result.getCodeId());
			egovLogger.debug("getCode: {}", result.getCode());
			egovLogger.debug("getCodeNm: {}", result.getCodeNm());
			egovLogger.debug("getCodeDc: {}", result.getCodeDc());

			assertEquals(result.getCode(), vo.getDetailCondition());
		}
	}

	private List<CmmnDetailCode> selectOgrnztIdDetail(ComDefaultCodeVO vo) {
		try {
			return egovCmmUseService.selectOgrnztIdDetail(vo);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
			return new ArrayList<>();
		}
	}

}
