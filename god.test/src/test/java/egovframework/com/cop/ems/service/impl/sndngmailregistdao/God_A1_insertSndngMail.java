package egovframework.com.cop.ems.service.impl.sndngmailregistdao;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cop.ems.service.SndngMailVO;
import egovframework.com.cop.ems.service.impl.SndngMailRegistDAO;
import egovframework.rte.fdl.cmmn.exception.FdlException;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.fdl.string.EgovDateUtil;
import god.test.GodTestAbstract;

public class God_A1_insertSndngMail extends GodTestAbstract {

	@Autowired
	private SndngMailRegistDAO dao;

	@Autowired
	private EgovIdGnrService egovMailMsgIdGnrService;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		String today = EgovDateUtil.toString(new Date(), null, null);

		SndngMailVO vo = new SndngMailVO();

		try {
			vo.setMssageId(egovMailMsgIdGnrService.getNextStringId());
		} catch (FdlException e) {
			egovLogger.error(e.getMessage());
		}

		vo.setDsptchPerson("test 발신자");
		vo.setRecptnPerson("test 수신자");
		vo.setSj("test 제목 " + today);

		SndngMailVO result = null;

		try {
			result = dao.insertSndngMail(vo);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		egovLogger.debug("result: {}", result);
	}

}
