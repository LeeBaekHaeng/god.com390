package egovframework.com.cmm.service.impl.egovfilemngserviceimpl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cmm.service.EgovFileMngService;
import egovframework.com.cmm.service.FileVO;
import god.test.GodTestAbstract;

public class A8_파일_구분자에_대한_최대값을_구한다 extends GodTestAbstract {

//	@Resource(name = "EgovFileMngService")
	@Autowired
//	@Qualifier("EgovFileMngService")
	private EgovFileMngService egovFileMngService;

	@Override
	@Test
	public void test() {
		egovLogger.debug("파일 구분자에 대한 최대값을 구한다.");

		FileVO fvo = new FileVO();
		fvo.setAtchFileId("FILE_000000000000017");

		int maxFileSN = 0;

		try {
			maxFileSN = egovFileMngService.getMaxFileSN(fvo);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		egovLogger.debug("maxFileSN: {}", maxFileSN);
	}

}
