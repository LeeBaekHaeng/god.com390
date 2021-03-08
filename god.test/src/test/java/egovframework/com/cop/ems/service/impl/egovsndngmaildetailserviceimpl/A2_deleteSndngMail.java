package egovframework.com.cop.ems.service.impl.egovsndngmaildetailserviceimpl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import egovframework.com.cop.ems.service.EgovSndngMailDetailService;
import egovframework.com.cop.ems.service.SndngMailVO;
import god.test.GodTestAbstract;

public class A2_deleteSndngMail extends GodTestAbstract {

	@Autowired
	private EgovSndngMailDetailService egovSndngMailDetailService;

	@Override
	@Test
	@Transactional
	public void test() {
		egovLogger.debug("test");

		SndngMailVO vo = new SndngMailVO();
		vo.setMssageId("MAILMSG_000000000073");

		try {
			egovSndngMailDetailService.deleteSndngMail(vo);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}
	}

}
