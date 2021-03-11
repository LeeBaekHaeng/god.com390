package egovframework.com.cop.ems.service.impl.egovsndngmaildtlsserviceimpl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cmm.service.Globals;
import egovframework.com.cop.ems.service.EgovSndngMailDtlsService;
import egovframework.com.cop.ems.service.SndngMailVO;
import god.test.GodTestAbstract;

public class A3_deleteSndngMailList extends GodTestAbstract {

	@Autowired
	private EgovSndngMailDtlsService egovSndngMailDtlsService;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		egovLogger.debug("Globals.MAIL_REQUEST_PATH={}", Globals.MAIL_REQUEST_PATH);

		SndngMailVO vo = new SndngMailVO();
		vo.setMssageId("MAILMSG_000000000073");

		int result = 0;

		try {
			egovSndngMailDtlsService.deleteSndngMailList(vo);
			result = 1;
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		egovLogger.debug("result={}", result);
	}

}
