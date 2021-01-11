package egovframework.com.cmm.service.impl.egovcmmuseserviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.CmmnDetailCode;
import egovframework.com.cmm.service.CmmnDetailCodeDebugUtils;
import egovframework.com.cmm.service.EgovCmmUseService;
import god.test.GodTestAbstract;

public class A1_selectCmmCodeDetail extends GodTestAbstract {

	@Autowired
	@Qualifier("EgovCmmUseService")
	private EgovCmmUseService egovCmmUseService;

	@Override
	@Test
	public void test() {
		egovLogger.debug("공통코드를 조회한다.");

		ComDefaultCodeVO vo = new ComDefaultCodeVO();
		vo.setCodeId("COM001");

		egovLogger.debug("vo: {}", vo);

		List<CmmnDetailCode> results = selectCmmCodeDetail(vo);

		CmmnDetailCodeDebugUtils.debug(results);
	}

	@Test
	public void test2() {
		egovLogger.debug("공통코드를 조회한다.");

		ComDefaultCodeVO vo = new ComDefaultCodeVO();
		vo.setCodeId("COM002");

		egovLogger.debug("vo: {}", vo);

		List<CmmnDetailCode> results = selectCmmCodeDetail(vo);

		CmmnDetailCodeDebugUtils.debug(results);
	}

	private List<CmmnDetailCode> selectCmmCodeDetail(ComDefaultCodeVO vo) {
		try {
			return egovCmmUseService.selectCmmCodeDetail(vo);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
			return new ArrayList<>();
		}
	}

}
