package egovframework.com.cmm.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cmm.service.FileVO;
import god.test.GodTestAbstract;

public class FileManageDAOTest_getMaxFileSN extends GodTestAbstract {

	@Autowired
	private FileManageDAOTest fileManageDAOTest;

	@Override
	@Test
	public void test() {
		egovLogger.debug("파일 구분자에 대한 최대값을 구한다.");

		FileVO fvo = new FileVO();
		fvo.setAtchFileId("FILE_000000000000011");

		int maxFileSN = fileManageDAOTest.getMaxFileSN(fvo);

		egovLogger.debug("maxFileSN: {}", maxFileSN);
	}

}
