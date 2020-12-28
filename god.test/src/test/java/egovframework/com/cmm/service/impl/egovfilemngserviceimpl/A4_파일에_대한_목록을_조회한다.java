package egovframework.com.cmm.service.impl.egovfilemngserviceimpl;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cmm.service.EgovFileMngService;
import egovframework.com.cmm.service.FileVO;
import god.test.GodTestAbstract;

public class A4_파일에_대한_목록을_조회한다 extends GodTestAbstract {

//	@Resource(name = "EgovFileMngService")
	@Autowired
//	@Qualifier("EgovFileMngService")
	private EgovFileMngService egovFileMngService;

	@Override
	@Test
	public void test() {
		egovLogger.debug("파일에 대한 목록을 조회한다.");

		FileVO fvo = new FileVO();
		fvo.setAtchFileId("FILE_000000000000035");

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
