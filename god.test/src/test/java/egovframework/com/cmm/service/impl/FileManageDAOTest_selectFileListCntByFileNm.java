package egovframework.com.cmm.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cmm.service.FileVO;
import god.test.GodTestAbstract;

public class FileManageDAOTest_selectFileListCntByFileNm extends GodTestAbstract {

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

		int result = fileManageDAOTest.selectFileListCntByFileNm(fvo);

		egovLogger.debug("result: {}", result);
	}

	@Test
	public void test2() {
		egovLogger.debug("파일명 검색에 대한 목록을 조회한다.");

		FileVO fvo = new FileVO();
		fvo.setSearchCnd("orignlFileNm");
		fvo.setSearchWrd("GOD");

		fvo.setRecordCountPerPage(10);
		fvo.setFirstIndex(0);

		int result = fileManageDAOTest.selectFileListCntByFileNm(fvo);

		egovLogger.debug("result: {}", result);
	}

}
