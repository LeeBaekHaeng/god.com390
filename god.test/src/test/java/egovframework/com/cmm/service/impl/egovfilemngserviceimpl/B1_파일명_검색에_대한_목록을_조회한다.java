package egovframework.com.cmm.service.impl.egovfilemngserviceimpl;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cmm.service.EgovFileMngService;
import egovframework.com.cmm.service.FileVO;
import god.test.GodTestAbstract;

public class B1_파일명_검색에_대한_목록을_조회한다 extends GodTestAbstract {

//	@Resource(name = "EgovFileMngService")
	@Autowired
//	@Qualifier("EgovFileMngService")
	private EgovFileMngService egovFileMngService;

	@SuppressWarnings("unchecked")
	@Override
	@Test
	public void test() {
		egovLogger.debug("파일명 검색에 대한 목록을 조회한다.");

//		FileVO fvo = getFileVO();
		FileVO fvo = getFileVO2();

		Map<String, Object> result = null;

		try {
			result = egovFileMngService.selectFileListByFileNm(fvo);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		List<FileVO> resultList = (List<FileVO>) result.get("resultList");
		String resultCnt = (String) result.get("resultCnt");

		DebugUtils.debug(resultList);
		egovLogger.debug("resultCnt: {}", resultCnt);
	}

	FileVO getFileVO() {
		FileVO fvo = new FileVO();
		fvo.setAtchFileId("FILE_000000000000035");
//		fvo.setRecordCountPerPage(Integer.MAX_VALUE);
		fvo.setFirstIndex(0);
		fvo.setSearchCnd("streFileNm");
		fvo.setSearchWrd("34");
		return fvo;
	}

	FileVO getFileVO2() {
		FileVO fvo = new FileVO();
		fvo.setAtchFileId("FILE_000000000000035");
//		fvo.setRecordCountPerPage(Integer.MAX_VALUE);
		fvo.setFirstIndex(0);
		fvo.setSearchCnd("orignlFileNm");
		fvo.setSearchWrd("34");
		return fvo;
	}

}
