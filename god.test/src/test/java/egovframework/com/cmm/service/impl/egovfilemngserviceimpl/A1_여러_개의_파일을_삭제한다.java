package egovframework.com.cmm.service.impl.egovfilemngserviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import egovframework.com.cmm.service.EgovFileMngService;
import egovframework.com.cmm.service.FileVO;
import egovframework.rte.fdl.cmmn.exception.FdlException;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.fdl.string.EgovDateUtil;
import god.test.GodTestAbstract;

public class A1_여러_개의_파일을_삭제한다 extends GodTestAbstract {

	@Resource(name = "EgovFileMngService")
	private EgovFileMngService egovFileMngService;

	@Resource(name = "egovFileIdGnrService")
	private EgovIdGnrService egovFileIdGnrService;

	private String atchFileId;
	private String fileSn;

	private FileVO fvo;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		egovLogger.debug("하나의 파일에 대한 정보(속성 및 상세)를 등록한다.");

		fvo = new FileVO();
		fvo.setAtchFileId(getNextStringId());
		fvo.setFileSn(getMaxFileSN(fvo));
		fvo.setFileMg("0");
		fvo.setFileCn("test 파일내용 " + EgovDateUtil.toString(new Date(), "yyyy-MM-dd HH:mm:ss", null));

		String insertFileInf = egovFileMngService.insertFileInf(fvo);
		egovLogger.debug("insertFileInf: {}", insertFileInf);

		atchFileId = insertFileInf;
		fileSn = fvo.getFileSn();
	}

	private String getNextStringId() {
		try {
			return egovFileIdGnrService.getNextStringId();
		} catch (FdlException e) {
			egovLogger.error(e.getMessage());
			return null;
		}
	}

	private String getMaxFileSN(FileVO fvo) {
		try {
			return String.valueOf(egovFileMngService.getMaxFileSN(fvo));
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
			return null;
		}

	}

	@Override
	@Test
	public void test() {
		egovLogger.debug("여러 개의 파일을 삭제한다.");

		List<FileVO> fvoList = new ArrayList<>();
		fvo = new FileVO();
		fvo.setAtchFileId(atchFileId);
		fvo.setFileSn(fileSn);
		fvoList.add(fvo);

		try {
			egovFileMngService.deleteFileInfs(fvoList);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}
	}

}
