package egovframework.com.cmm.service.impl.egovcmmuseserviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.CmmnDetailCode;
import egovframework.com.cmm.service.CmmnDetailCodeDebugUtils;
import egovframework.com.cmm.service.EgovCmmUseService;
import god.test.GodTestAbstract;

public class A2_selectCmmCodeDetails extends GodTestAbstract {

	@Autowired
//	@Qualifier("EgovCmmUseService")
	private EgovCmmUseService egovCmmUseService;

	@Override
	@Test
	public void test() {
		egovLogger.debug("ComDefaultCodeVO의 리스트를 받아서 여러개의 코드 리스트를 맵에 담아서 리턴한다.");

		List<ComDefaultCodeVO> voList = new ArrayList<>();

		ComDefaultCodeVO vo = new ComDefaultCodeVO();
		vo.setCodeId("COM001");
		voList.add(vo);

		vo = new ComDefaultCodeVO();
		vo.setCodeId("COM002");
		voList.add(vo);

		Map<String, List<CmmnDetailCode>> result = selectCmmCodeDetails(voList);

		List<CmmnDetailCode> COM001s = result.get("COM001");
		CmmnDetailCodeDebugUtils.debug(COM001s);

		List<CmmnDetailCode> COM002s = result.get("COM002");
		CmmnDetailCodeDebugUtils.debug(COM002s);
	}

	private Map<String, List<CmmnDetailCode>> selectCmmCodeDetails(List<?> voList) {
		try {
			return egovCmmUseService.selectCmmCodeDetails(voList);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
			return null;
		}
	}

}
