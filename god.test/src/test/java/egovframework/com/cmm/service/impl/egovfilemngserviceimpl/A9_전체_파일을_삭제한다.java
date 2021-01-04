package egovframework.com.cmm.service.impl.egovfilemngserviceimpl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cmm.service.EgovFileMngService;
import egovframework.com.cmm.service.FileVO;
import god.test.GodTestAbstract;

public class A9_전체_파일을_삭제한다 extends GodTestAbstract {

//	@Resource(name = "EgovFileMngService")
	@Autowired
//	@Qualifier("EgovFileMngService")
	private EgovFileMngService egovFileMngService;

	@Override
	@Test
	public void test() {
		egovLogger.debug("전체 파일을 삭제한다.");

		FileVO fvo = new FileVO();
		fvo.setAtchFileId("FILE_000000000000035");

		try {
			egovFileMngService.deleteAllFileInf(fvo);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}
	}

}
