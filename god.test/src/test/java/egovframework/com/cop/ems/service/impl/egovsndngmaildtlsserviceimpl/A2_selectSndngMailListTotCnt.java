package egovframework.com.cop.ems.service.impl.egovsndngmaildtlsserviceimpl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cmm.ComDefaultVO;
import egovframework.com.cop.ems.service.EgovSndngMailDtlsService;
import god.test.GodTestAbstract;

public class A2_selectSndngMailListTotCnt extends GodTestAbstract {

	@Autowired
	private EgovSndngMailDtlsService egovSndngMailDtlsService;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		ComDefaultVO vo = new ComDefaultVO();

		vo.setSearchCondition("1");
//		vo.setSearchCondition("2");
//		vo.setSearchCondition("3");
		vo.setSearchKeyword("test");

		int result = 0;

		try {
			result = egovSndngMailDtlsService.selectSndngMailListTotCnt(vo);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		egovLogger.debug("result={}", result);
	}

}
