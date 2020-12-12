package egovframework.com.cmm.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cmm.service.FileVO;
import egovframework.rte.fdl.string.EgovDateUtil;
import god.test.GodTestAbstract;

public class FileManageDAOTest_updateFileInfs extends GodTestAbstract {

	@Autowired
	private FileManageDAOTest fileManageDAOTest;

	@Override
	@Test
	public void test() {
		egovLogger.debug("여러 개의 파일에 대한 정보(속성 및 상세)를 수정한다.");

		List<FileVO> fileList = new ArrayList<>();

		FileVO file = new FileVO();
		file.setAtchFileId("FILE_000000000000001");
		file.setFileSn(Integer.toString(fileManageDAOTest.getMaxFileSN(file)));
		file.setFileMg("0");
		file.setFileCn("test 파일내용 " + EgovDateUtil.toString(new Date(), null, null));
		fileList.add(file);

		egovLogger.debug("fileList: {]", fileList);

		fileManageDAOTest.updateFileInfs(fileList);
	}

}
