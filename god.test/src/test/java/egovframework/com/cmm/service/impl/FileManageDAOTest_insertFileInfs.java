package egovframework.com.cmm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import egovframework.com.cmm.service.FileVO;
import egovframework.rte.fdl.cmmn.exception.FdlException;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import god.test.GodTestAbstract;

public class FileManageDAOTest_insertFileInfs extends GodTestAbstract {

//	@Resource(name = "FileManageDAO")
	@Autowired
	@Qualifier("FileManageDAO")
	private FileManageDAO fileMngDAO;

//	@Resource(name = "egovFileIdGnrService")
	@Autowired
	@Qualifier("egovFileIdGnrService")
	private EgovIdGnrService idgenService;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		List<FileVO> fileList = new ArrayList<>();

		FileVO fileVO = new FileVO();
		fileVO.setAtchFileId(getNextStringId());
		fileVO.setFileSn("1");
		fileVO.setFileMg("0");
		fileList.add(fileVO);

		egovLogger.debug("fileList: {}", fileList);
		egovLogger.debug("size: {}", fileList.size());

		String atchFileId = insertFileInfs(fileList);

		egovLogger.debug("atchFileId: {}", atchFileId);
	}

	private String insertFileInfs(List<FileVO> fileList) {
		try {
			return fileMngDAO.insertFileInfs(fileList);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
			return null;
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
