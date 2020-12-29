package egovframework.com.cmm.service.impl.egovfilemngserviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cmm.service.EgovFileMngService;
import egovframework.com.cmm.service.FileVO;
import egovframework.rte.fdl.string.EgovDateUtil;
import god.test.GodTestAbstract;

public class A5_여러_개의_파일에_대한_정보_속성_및_상세_를_수정한다 extends GodTestAbstract {

//	@Resource(name = "EgovFileMngService")
	@Autowired
//	@Qualifier("EgovFileMngService")
	private EgovFileMngService egovFileMngService;

	@Override
	@Test
	public void test() {
		egovLogger.debug("여러 개의 파일에 대한 정보(속성 및 상세)를 수정한다.");

		String atchFileId = "FILE_000000000000035";

		int maxFileSN = getMaxFileSN(atchFileId);

		List<FileVO> fvoList = getFvoList(atchFileId, maxFileSN);

		updateFileInfs(fvoList);

		debug(atchFileId);
	}

	private int getMaxFileSN(String atchFileId) {
		FileVO fvo = new FileVO();
		fvo.setAtchFileId(atchFileId);
		int maxFileSN;
		try {
			maxFileSN = egovFileMngService.getMaxFileSN(fvo);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
			return 0;
		}
		return maxFileSN;
	}

	private List<FileVO> getFvoList(String atchFileId, int maxFileSN) {
		List<FileVO> fvoList = new ArrayList<>();

		for (int i = 1; i < 11; i++) {
			FileVO fvo = new FileVO();
			fvo.setAtchFileId(atchFileId);
			fvo.setFileSn(String.valueOf(maxFileSN++));
			fvo.setFileMg("0");
			fvo.setFileCn("test 파일내용 " + i + " " + EgovDateUtil.toString(new Date(), null, null));
			fvoList.add(fvo);
		}

		return fvoList;
	}

	private void updateFileInfs(List<FileVO> fvoList) {
		try {
			egovFileMngService.updateFileInfs(fvoList);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}
	}

	private void debug(String atchFileId) {
		FileVO fvo = new FileVO();
		fvo.setAtchFileId(atchFileId);

		List<FileVO> results = null;

		try {
			results = egovFileMngService.selectFileInfs(fvo);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		egovLogger.debug("results: {}", results);

		for (FileVO result : results) {
			egovLogger.debug("result: {}", result);
			egovLogger.debug("getAtchFileId: {}", result.getAtchFileId());
			egovLogger.debug("getFileSn: {}", result.getFileSn());
		}
	}

}
