package egovframework.com.cmm.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cmm.service.FileVO;
import god.test.GodTestAbstract;

public class FileManageDAOTest_selectFileInf extends GodTestAbstract {

	@Autowired
	private FileManageDAOTest fileManageDAOTest;

	@Override
	@Test
	public void test() {
		egovLogger.debug("파일에 대한 상세정보를 조회한다.");

		FileVO fvo = new FileVO();
		fvo.setAtchFileId("FILE_000000000000011");
		fvo.setFileSn("1");

		egovLogger.debug("fvo: {}", fvo);

		FileVO result = fileManageDAOTest.selectFileInf(fvo);

		egovLogger.debug("result: {}", result);

		if (result == null) {
			return;
		}

		egovLogger.debug("getAtchFileId: {}", result.getAtchFileId());
		egovLogger.debug("getFileCn: {}", result.getFileCn());
		egovLogger.debug("getFileSn: {}", result.getFileSn());
		egovLogger.debug("getFileStreCours: {}", result.getFileStreCours());
		egovLogger.debug("getStreFileNm: {}", result.getStreFileNm());
		egovLogger.debug("getFileExtsn: {}", result.getFileExtsn());
		egovLogger.debug("getOrignlFileNm: {}", result.getOrignlFileNm());
		egovLogger.debug("getFileMg: {}", result.getFileMg());
	}

}
