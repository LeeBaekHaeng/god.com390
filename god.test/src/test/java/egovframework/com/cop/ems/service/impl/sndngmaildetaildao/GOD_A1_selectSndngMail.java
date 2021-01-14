package egovframework.com.cop.ems.service.impl.sndngmaildetaildao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cop.ems.service.SndngMailVO;
import egovframework.com.cop.ems.service.impl.SndngMailDetailDAO;
import god.test.GodTestAbstract;

public class GOD_A1_selectSndngMail extends GodTestAbstract {

//	@Resource(name = "sndngMailDetailDAO")
	@Autowired
//	@Qualifier("sndngMailDetailDAO")
	private SndngMailDetailDAO sndngMailDetailDAO;

	@Override
	@Test
	public void test() {
		egovLogger.debug("발송메일을 상세 조회한다.");

		SndngMailVO vo = new SndngMailVO();
		vo.setMssageId("1-");

		SndngMailVO result = null;

		try {
			result = sndngMailDetailDAO.selectSndngMail(vo);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		egovLogger.debug("result: {}", result);

		if (result == null) {
			return;
		}

		egovLogger.debug("getMssageId: {}", result.getMssageId());
	}

}
