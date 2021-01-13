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

public class A4_selectGroupIdDetail extends GodTestAbstract {

	@Autowired
//	@Qualifier("EgovCmmUseService")
	private EgovCmmUseService egovCmmUseService;

	@Override
	@Test
	public void test() {
		egovLogger.debug("그룹정보를 코드형태로 리턴한다.");

		ComDefaultCodeVO vo = new ComDefaultCodeVO();
		vo.setTableNm("COMTNAUTHORGROUPINFO");
		vo.setHaveDetailCondition("Y");
		vo.setDetailCondition("GROUP_00000000000000");

		List<CmmnDetailCode> results = selectGroupIdDetail(vo);

		CmmnDetailCodeDebugUtils.debug(results);

		assertEquals(results.get(0).getCodeId(), vo.getTableNm());
		assertEquals(results.get(0).getCode(), vo.getDetailCondition());
	}

	private List<CmmnDetailCode> selectGroupIdDetail(ComDefaultCodeVO vo) {
		try {
			return egovCmmUseService.selectGroupIdDetail(vo);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
			return null;
		}
	}

}
