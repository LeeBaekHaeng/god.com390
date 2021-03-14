package egovframework.com.cop.ems.service.impl.egovsndngmailregistserviceimpl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cop.ems.service.EgovSndngMailRegistService;
import egovframework.com.cop.ems.service.SndngMailVO;
import god.test.GodTestAbstract;

public class A2_trnsmitXmlData extends GodTestAbstract {

	@Autowired
	EgovSndngMailRegistService service;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		SndngMailVO vo = new SndngMailVO();
		vo.setMssageId("MAILMSG_000000000073");
//		vo.setDsptchPerson("test 발신자");
//		vo.setSj("test 제목");

		boolean result = false;

		try {
			result = service.trnsmitXmlData(vo);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		egovLogger.debug("result={}", result);

		assertEquals(true, result);
	}

}
