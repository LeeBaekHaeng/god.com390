package egovframework.com.cmm.service.impl.egovcmmuseserviceimpl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.CmmnDetailCode;
import egovframework.com.cmm.service.CmmnDetailCodeDebugUtils;
import egovframework.com.cmm.service.EgovCmmUseService;
import god.test.GodTestAbstract;

public class A3_selectOgrnztIdDetail extends GodTestAbstract {

	@Autowired
//	@Qualifier("EgovCmmUseService")
	private EgovCmmUseService egovCmmUseService;

	@Override
	@Test
	public void test() {
		egovLogger.debug("조직정보를 코드형태로 리턴한다.");

		ComDefaultCodeVO vo = new ComDefaultCodeVO();
		vo.setTableNm("COMTNORGNZTINFO");
		vo.setHaveDetailCondition("Y");
		vo.setDetailCondition(vo.getTableNm());

		List<CmmnDetailCode> results = selectOgrnztIdDetail(vo);

		CmmnDetailCodeDebugUtils.debug(results);

		assertEquals(results.get(0).getCodeId(), vo.getTableNm());
	}

	private List<CmmnDetailCode> selectOgrnztIdDetail(ComDefaultCodeVO vo) {
		try {
			return egovCmmUseService.selectOgrnztIdDetail(vo);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
			return null;
		}
	}

}
