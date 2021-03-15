package egovframework.com.cop.ems.service.impl.egovsndngmailregistserviceimpl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cmm.service.Globals;
import egovframework.com.cop.ems.service.EgovSndngMailRegistService;
import god.test.GodTestAbstract;

public class A3_recptnXmlData extends GodTestAbstract {

	@Autowired
	EgovSndngMailRegistService service;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		String xml = Globals.MAIL_REQUEST_PATH + "MAILMSG_000000000073" + ".xml";

		boolean result = false;

		try {
			result = service.recptnXmlData(xml);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		egovLogger.debug("result={}", result);

		assertEquals(true, result);
	}

}
