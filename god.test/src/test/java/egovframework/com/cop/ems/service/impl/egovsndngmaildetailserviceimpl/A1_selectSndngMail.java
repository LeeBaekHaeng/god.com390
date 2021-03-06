package egovframework.com.cop.ems.service.impl.egovsndngmaildetailserviceimpl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cop.ems.service.EgovSndngMailDetailService;
import egovframework.com.cop.ems.service.SndngMailVO;
import god.test.GodTestAbstract;

public class A1_selectSndngMail extends GodTestAbstract {

	@Autowired
	private EgovSndngMailDetailService egovSndngMailDetailService;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		SndngMailVO vo = new SndngMailVO();
//		vo.setMssageId("MAILMSG_000000000069");
		vo.setMssageId("MAILMSG_000000000069-");

		SndngMailVO result = null;

		try {
			result = egovSndngMailDetailService.selectSndngMail(vo);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		egovLogger.debug("result: {}", result);

		if (result == null) {
			return;
		}

		egovLogger.debug("getMssageId: {}", result.getMssageId());

		assertEquals(result.getMssageId(), vo.getMssageId());
	}

}
