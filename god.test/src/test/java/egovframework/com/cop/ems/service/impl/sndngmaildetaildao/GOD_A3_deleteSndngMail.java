package egovframework.com.cop.ems.service.impl.sndngmaildetaildao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cop.ems.service.SndngMailVO;
import egovframework.com.cop.ems.service.impl.SndngMailDetailDAO;
import egovframework.com.cop.ems.service.impl.SndngMailRegistDAO;
import egovframework.rte.fdl.cmmn.exception.FdlException;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import god.test.GodTestAbstract;

public class GOD_A3_deleteSndngMail extends GodTestAbstract {

	@Autowired
	private EgovIdGnrService egovMailMsgIdGnrService;

//	@Resource(name = "sndngMailRegistDAO")
	@Autowired
//	@Qualifier("sndngMailRegistDAO")
	private SndngMailRegistDAO sndngMailRegistDAO;

//	@Resource(name = "sndngMailDetailDAO")
	@Autowired
//	@Qualifier("sndngMailDetailDAO")
	private SndngMailDetailDAO sndngMailDetailDAO;

	@Override
	@Test
	public void test() {
		String mssageId = getMssageId();

		insertSndngMail(mssageId);

		egovLogger.debug("발송메일을 삭제한다.");

		SndngMailVO vo = new SndngMailVO();
		vo.setMssageId(mssageId);

		try {
			sndngMailDetailDAO.deleteSndngMail(vo);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}
	}

	private String getMssageId() {
		try {
			return egovMailMsgIdGnrService.getNextStringId();
		} catch (FdlException e) {
			egovLogger.error(e.getMessage());
			return null;
		}
	}

	private void insertSndngMail(String mssageId) {
		SndngMailVO vo = new SndngMailVO();
		vo.setMssageId(mssageId);
		vo.setDsptchPerson("test 테스트 발신자");
		vo.setRecptnPerson("test 테스트 수신자");
		vo.setSj("test 테스트 제목");

		try {
			sndngMailRegistDAO.insertSndngMail(vo);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}
	}

}
