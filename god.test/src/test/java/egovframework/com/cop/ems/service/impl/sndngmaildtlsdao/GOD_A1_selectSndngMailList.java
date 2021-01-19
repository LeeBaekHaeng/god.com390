package egovframework.com.cop.ems.service.impl.sndngmaildtlsdao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cmm.ComDefaultVO;
import egovframework.com.cop.ems.service.SndngMailVO;
import egovframework.com.cop.ems.service.impl.SndngMailDtlsDAO;
import god.test.GodTestAbstract;

public class GOD_A1_selectSndngMailList extends GodTestAbstract {

	@Autowired
	private SndngMailDtlsDAO dao;

	@SuppressWarnings("unchecked")
	@Override
	@Test
	public void test() {
		egovLogger.debug("발송메일 목록을 조회한다.");

		ComDefaultVO vo = new ComDefaultVO();
		vo.setFirstIndex(0);
//		vo.setSearchCondition("1");
//		vo.setSearchCondition("2");
		vo.setSearchCondition("3");
		vo.setSearchKeyword("test 테스트");

		List<SndngMailVO> results = null;

		try {
			results = (List<SndngMailVO>) dao.selectSndngMailList(vo);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		egovLogger.debug("results: {}", results);

		for (SndngMailVO result : results) {
			egovLogger.debug("result: {}", result);
			egovLogger.debug("getMssageId: {}", result.getMssageId());
		}
	}

}
