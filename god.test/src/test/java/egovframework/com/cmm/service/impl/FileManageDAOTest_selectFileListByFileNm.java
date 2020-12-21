package egovframework.com.cmm.service.impl;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cmm.service.FileVO;
import god.test.GodTestAbstract;

public class FileManageDAOTest_selectFileListByFileNm extends GodTestAbstract {

	@Autowired
	private FileManageDAOTest fileManageDAOTest;

	@Override
	@Test
	public void test() {
		egovLogger.debug("파일명 검색에 대한 목록을 조회한다.");

		FileVO fvo = new FileVO();
		fvo.setSearchCnd("streFileNm");
		fvo.setSearchWrd("GOD");

		fvo.setRecordCountPerPage(10);
		fvo.setFirstIndex(0);

		List<FileVO> results = fileManageDAOTest.selectFileListByFileNm(fvo);

		egovLogger.debug("results: {}", results);
		
		for (FileVO result:results) {
			egovLogger.debug("result: {}", result);
			egovLogger.debug("getAtchFileId: {}", result.getAtchFileId());
			egovLogger.debug("getFileCn: {}", result.getFileCn());
			egovLogger.debug("getFileExtsn: {}", result.getFileExtsn());
			egovLogger.debug("getFileMg: {}", result.getFileMg());
			egovLogger.debug("getFileSn: {}", result.getFileSn());
			egovLogger.debug("getFileStreCours: {}", result.getFileStreCours());
			egovLogger.debug("getOrignlFileNm: {}", result.getOrignlFileNm());
			egovLogger.debug("getStreFileNm: {}", result.getStreFileNm());
			egovLogger.debug("getCreatDt: {}", result.getCreatDt());
		}
	}
	
	@Test
	public void test2() {
		egovLogger.debug("파일명 검색에 대한 목록을 조회한다.");

		FileVO fvo = new FileVO();
		fvo.setSearchCnd("orignlFileNm");
		fvo.setSearchWrd("GOD");

		fvo.setRecordCountPerPage(10);
		fvo.setFirstIndex(0);

		List<FileVO> results = fileManageDAOTest.selectFileListByFileNm(fvo);

		egovLogger.debug("results: {}", results);
		
		for (FileVO result:results) {
			egovLogger.debug("result: {}", result);
			egovLogger.debug("getAtchFileId: {}", result.getAtchFileId());
			egovLogger.debug("getFileCn: {}", result.getFileCn());
			egovLogger.debug("getFileExtsn: {}", result.getFileExtsn());
			egovLogger.debug("getFileMg: {}", result.getFileMg());
			egovLogger.debug("getFileSn: {}", result.getFileSn());
			egovLogger.debug("getFileStreCours: {}", result.getFileStreCours());
			egovLogger.debug("getOrignlFileNm: {}", result.getOrignlFileNm());
			egovLogger.debug("getStreFileNm: {}", result.getStreFileNm());
			egovLogger.debug("getCreatDt: {}", result.getCreatDt());
		}
	}

}
