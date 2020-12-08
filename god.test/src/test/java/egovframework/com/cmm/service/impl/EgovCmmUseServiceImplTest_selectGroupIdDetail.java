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

public class EgovCmmUseServiceImplTest_selectGroupIdDetail extends GodTestAbstract {

//	@Resource(name = "cmmUseDAO")
	@Autowired
	@Qualifier("cmmUseDAO")
	private CmmUseDAO cmmUseDAO;

	@Override
	@Test
	public void test() {
		egovLogger.debug("그룹정보를 코드형태로 리턴한다.");

		ComDefaultCodeVO vo = new ComDefaultCodeVO();
		vo.setTableNm("COMTNAUTHORGROUPINFO");
		vo.setHaveDetailCondition("Y");
		vo.setDetailCondition("GROUP_00000000000000");

		egovLogger.debug("vo: {}", vo);

		List<CmmnDetailCode> results = selectGroupIdDetail(vo);

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

	private List<CmmnDetailCode> selectGroupIdDetail(ComDefaultCodeVO vo) {
		try {
			return cmmUseDAO.selectGroupIdDetail(vo);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
			return new ArrayList<>();
		}
	}

}
