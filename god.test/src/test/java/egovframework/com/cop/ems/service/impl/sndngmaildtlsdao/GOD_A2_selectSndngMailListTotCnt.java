package egovframework.com.cop.ems.service.impl.sndngmaildtlsdao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cmm.ComDefaultVO;
import egovframework.com.cop.ems.service.impl.SndngMailDtlsDAO;
import god.test.GodTestAbstract;

public class GOD_A2_selectSndngMailListTotCnt extends GodTestAbstract {

	@Autowired
	private SndngMailDtlsDAO dao;

	@Override
	@Test
	public void test() {
		egovLogger.debug("발송메일 총건수를 조회한다.");

		ComDefaultVO vo = new ComDefaultVO();
		vo.setFirstIndex(0);
//		vo.setSearchCondition("1");
//		vo.setSearchCondition("2");
		vo.setSearchCondition("3");
		vo.setSearchKeyword("test 테스트");

		int result = 0;

		try {
			result = dao.selectSndngMailListTotCnt(vo);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		egovLogger.debug("result: {}", result);
	}

}
