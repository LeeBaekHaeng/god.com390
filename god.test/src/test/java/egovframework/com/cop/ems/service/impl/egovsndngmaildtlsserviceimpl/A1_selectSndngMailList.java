package egovframework.com.cop.ems.service.impl.egovsndngmaildtlsserviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cmm.ComDefaultVO;
import egovframework.com.cop.ems.service.EgovSndngMailDtlsService;
import egovframework.com.cop.ems.service.SndngMailVO;
import god.test.GodTestAbstract;

public class A1_selectSndngMailList extends GodTestAbstract {

	@Autowired
	private EgovSndngMailDtlsService egovSndngMailDtlsService;

	@SuppressWarnings("unchecked")
	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		ComDefaultVO vo = new ComDefaultVO();
		vo.setFirstIndex(0);
		vo.setRecordCountPerPage(10);

		vo.setSearchCondition("1");
//		vo.setSearchCondition("2");
//		vo.setSearchCondition("3");
		vo.setSearchKeyword("test");

		List<SndngMailVO> results = new ArrayList<>();

		try {
			results = (List<SndngMailVO>) egovSndngMailDtlsService.selectSndngMailList(vo);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		egovLogger.debug("isEmpty={}", results.isEmpty());
		egovLogger.debug("size={}", results.size());

		results.forEach(result -> {
			egovLogger.debug("result={}", result);
			egovLogger.debug("getMssageId={}", result.getMssageId());
		});

		for (SndngMailVO result : results) {
			egovLogger.debug("result={}", result);
			egovLogger.debug("getMssageId={}", result.getMssageId());
		}
	}

}
