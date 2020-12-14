package egovframework.com.cmm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cmm.service.FileVO;
import god.test.GodTestAbstract;

public class FileManageDAOTest_deleteFileInfs extends GodTestAbstract {

	@Autowired
	private FileManageDAOTest fileManageDAOTest;

	@Override
	@Test
	public void test() {
		egovLogger.debug("여러 개의 파일을 삭제한다.");

		List<FileVO> fileList = new ArrayList<>();

		FileVO file = new FileVO();
		file.setAtchFileId("test");
		file.setFileSn("1");
		fileList.add(file);

		fileManageDAOTest.deleteFileInfs(fileList);
	}

}
