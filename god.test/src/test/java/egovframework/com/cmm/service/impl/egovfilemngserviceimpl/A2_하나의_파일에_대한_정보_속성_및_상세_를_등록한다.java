package egovframework.com.cmm.service.impl.egovfilemngserviceimpl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cmm.service.EgovFileMngService;
import egovframework.com.cmm.service.FileVO;
import egovframework.rte.fdl.cmmn.exception.FdlException;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import god.test.GodTestAbstract;

public class A2_하나의_파일에_대한_정보_속성_및_상세_를_등록한다 extends GodTestAbstract {

//	@Resource(name = "EgovFileMngService")
	@Autowired
//	@Qualifier("EgovFileMngService")
	private EgovFileMngService egovFileMngService;

//	@Resource(name = "egovFileIdGnrService")
	@Autowired
//	@Qualifier("egovFileIdGnrService")
	private EgovIdGnrService egovFileIdGnrService;

	@Autowired
//	@Qualifier("egovMailMsgIdGnrService")
	private EgovIdGnrService egovMailMsgIdGnrService;

	@Override
	@Test
	public void test() {
		egovLogger.debug("하나의 파일에 대한 정보(속성 및 상세)를 등록한다.");

		FileVO fvo = new FileVO();
		try {
			fvo.setAtchFileId(egovFileIdGnrService.getNextStringId());
		} catch (FdlException e) {
			egovLogger.error(e.getMessage());
		}
		try {
			fvo.setFileSn(String.valueOf(egovFileMngService.getMaxFileSN(fvo)));
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		fvo.setFileMg("0");

		String atchFileId = null;

		try {
			atchFileId = egovFileMngService.insertFileInf(fvo);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		egovLogger.debug("atchFileId: {}", atchFileId);

		try {
			egovLogger.debug("mailMsgId: {}", egovMailMsgIdGnrService.getNextStringId());
		} catch (FdlException e) {
			egovLogger.error(e.getMessage());
		}
	}

}
