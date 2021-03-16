package egovframework.com.cop.ems.service.impl.egovsndngmailserviceimpl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cop.ems.service.EgovSndngMailService;
import egovframework.com.cop.ems.service.SndngMailVO;
import god.test.GodTestAbstract;

public class A1_sndngMail extends GodTestAbstract {

	@Autowired
	EgovSndngMailService egovSndngMailService;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		SndngMailVO vo = new SndngMailVO();
		vo.setRecptnPerson("dlqorgod@naver.com");
		vo.setSj("test 메일제목");
		vo.setEmailCn("test 메일내용");

		boolean result = false;

		try {
			result = egovSndngMailService.sndngMail(vo);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		egovLogger.debug("result={}", result);
	}

}
