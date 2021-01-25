package egovframework.com.cop.ems.service.impl.sndngmailregistdao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cop.ems.service.SndngMailVO;
import egovframework.com.cop.ems.service.impl.SndngMailRegistDAO;
import god.test.GodTestAbstract;

public class God_A3_updateSndngMail extends GodTestAbstract {

	@Autowired
	private SndngMailRegistDAO dao;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		SndngMailVO vo = new SndngMailVO();
		vo.setMssageId("MAILMSG_000000000006");
		vo.setSndngResultCode("R"); // 요청
//		vo.setSndngResultCode("F"); // 실패
//		vo.setSndngResultCode("C"); // 완료

		SndngMailVO result = null;

		try {
			result = dao.updateSndngMail(vo);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		egovLogger.debug("result: {}", result);
		egovLogger.debug("getMssageId: {}", result.getMssageId());
		egovLogger.debug("getSndngResultCode: {}", result.getSndngResultCode());
	}

}
