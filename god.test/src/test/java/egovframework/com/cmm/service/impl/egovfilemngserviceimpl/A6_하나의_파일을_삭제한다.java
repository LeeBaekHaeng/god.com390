package egovframework.com.cmm.service.impl.egovfilemngserviceimpl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cmm.service.EgovFileMngService;
import egovframework.com.cmm.service.FileVO;
import god.test.GodTestAbstract;

public class A6_하나의_파일을_삭제한다 extends GodTestAbstract {

//	@Resource(name = "EgovFileMngService")
	@Autowired
//	@Qualifier("EgovFileMngService")
	private EgovFileMngService egovFileMngService;

	@Override
	@Test
	public void test() {
		egovLogger.debug("하나의 파일을 삭제한다.");

		FileVO fvo = new FileVO();
		fvo.setAtchFileId("FILE_000000000000018");
		fvo.setFileSn("1");

		try {
			egovFileMngService.deleteFileInf(fvo);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}
	}

}
