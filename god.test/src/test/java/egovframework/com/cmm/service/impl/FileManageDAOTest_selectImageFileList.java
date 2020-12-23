package egovframework.com.cmm.service.impl;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cmm.service.FileVO;
import god.test.GodTestAbstract;

public class FileManageDAOTest_selectImageFileList extends GodTestAbstract {

	@Autowired
	private FileManageDAOTest fileManageDAOTest;

	@Override
	@Test
	public void test() {
		egovLogger.debug("이미지 파일에 대한 목록을 조회한다.");

		FileVO fvo = new FileVO();
		fvo.setAtchFileId("FILE_000000000000001");

		List<FileVO> results = fileManageDAOTest.selectImageFileList(fvo);

		egovLogger.debug("results: {}", results);
		egovLogger.debug("size: {}", results.size());

		for (FileVO result : results) {
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
