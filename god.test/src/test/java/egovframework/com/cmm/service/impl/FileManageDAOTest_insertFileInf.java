package egovframework.com.cmm.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;

import egovframework.com.cmm.service.FileVO;
import egovframework.rte.fdl.cmmn.exception.FdlException;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.fdl.string.EgovDateUtil;
import god.test.GodTestAbstract;

public class FileManageDAOTest_insertFileInf extends GodTestAbstract {

	@Resource(name = "FileManageDAO")
	private FileManageDAO fileMngDAO;

	@Resource(name = "egovFileIdGnrService")
	private EgovIdGnrService idgenService;

	@Override
	@Test
	public void test() {
		egovLogger.debug("하나의 파일에 대한 정보(속성 및 상세)를 등록한다.");

		FileVO vo = new FileVO();

		vo.setAtchFileId(getNextStringId());
		vo.setFileSn("1");
		vo.setFileMg("1");

		vo.setFileCn("test 파일내용 " + EgovDateUtil.toString(new Date(), "yyyy-MM-dd HH:mm:ss", null));

		insertFileInf(vo);
	}

	private void insertFileInf(FileVO vo) {
		try {
			fileMngDAO.insertFileInf(vo);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}
	}

	private String getNextStringId() {
		try {
			return idgenService.getNextStringId();
		} catch (FdlException e) {
			egovLogger.error(e.getMessage());
			return null;
		}
	}

}
