package egovframework.com.cmm.service.impl.egovfilemngserviceimpl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cmm.service.EgovFileMngService;
import egovframework.com.cmm.service.FileVO;
import egovframework.rte.fdl.cmmn.exception.FdlException;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.fdl.string.EgovDateUtil;
import god.test.GodTestAbstract;

public class A3_여러_개의_파일에_대한_정보_속성_및_상세_를_등록한다 extends GodTestAbstract {

//	@Resource(name = "EgovFileMngService")
	@Autowired
//	@Qualifier("EgovFileMngService")
	private EgovFileMngService egovFileMngService;

//	@Resource(name = "egovFileIdGnrService")
	@Autowired
//	@Qualifier("egovFileIdGnrService")
	private EgovIdGnrService egovFileIdGnrService;

	@Override
	@Test
	public void test() {
		egovLogger.debug("여러 개의 파일에 대한 정보(속성 및 상세)를 등록한다.");

		List<FileVO> fvoList = new ArrayList<>();

		String atchFileId = null;
		int maxFileSN = 0;

		FileVO fvo = new FileVO();
		try {
			atchFileId = egovFileIdGnrService.getNextStringId();
		} catch (FdlException e) {
			egovLogger.error(e.getMessage());
		}
		fvo.setAtchFileId(atchFileId);

		try {
			maxFileSN = egovFileMngService.getMaxFileSN(fvo);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		fvo = new FileVO();
		fvo.setAtchFileId(atchFileId);
		fvo.setFileSn(String.valueOf(maxFileSN++));
		fvo.setFileMg("0");
		fvo.setFileCn("test 파일내용 1 " + EgovDateUtil.toString(new Date(), null, null));
		fvoList.add(fvo);

		fvo = new FileVO();
		fvo.setAtchFileId(atchFileId);
		fvo.setFileSn(String.valueOf(maxFileSN++));
		fvo.setFileMg("0");
		fvo.setFileCn("test 파일내용 2 " + EgovDateUtil.toString(new Date(), null, null));
		fvoList.add(fvo);

		String atchFileIdResult = null;
		try {
			atchFileIdResult = egovFileMngService.insertFileInfs(fvoList);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		egovLogger.debug("atchFileIdResult: {}", atchFileIdResult);

		assertEquals(atchFileIdResult, atchFileId);
	}

}
