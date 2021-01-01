package egovframework.com.cmm.service.impl.egovfilemngserviceimpl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cmm.service.EgovFileMngService;
import egovframework.com.cmm.service.FileVO;
import god.test.GodTestAbstract;

public class A7_파일에_대한_상세정보를_조회한다 extends GodTestAbstract {

//	@Resource(name = "EgovFileMngService")
	@Autowired
//	@Qualifier("EgovFileMngService")
	private EgovFileMngService egovFileMngService;

	@Override
	@Test
	public void test() {
		egovLogger.debug("파일에 대한 상세정보를 조회한다.");

		FileVO fvo = new FileVO();
		fvo.setAtchFileId("FILE_000000000000017");
		fvo.setFileSn("1");

		FileVO result = null;

		try {
			result = egovFileMngService.selectFileInf(fvo);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		DebugUtils.debug(result);
		DebugUtils.debug2(result);
	}

}
