package egovframework.com.cmm.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cmm.service.FileVO;
import god.test.GodTestAbstract;

public class FileManageDAOTest_deleteFileInf extends GodTestAbstract {

	@Autowired
	private FileManageDAOTest fileManageDAOTest;

	@Override
	@Test
	public void test() {
		egovLogger.debug("하나의 파일을 삭제한다.");

		FileVO fvo = new FileVO();
		fvo.setAtchFileId("FILE_000000000000001");
		fvo.setFileSn("1");

		fileManageDAOTest.deleteFileInf(fvo);
	}

}
