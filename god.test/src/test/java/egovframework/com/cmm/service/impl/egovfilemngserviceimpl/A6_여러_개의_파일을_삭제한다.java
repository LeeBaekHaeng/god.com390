package egovframework.com.cmm.service.impl.egovfilemngserviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cmm.service.EgovFileMngService;
import egovframework.com.cmm.service.FileVO;
import god.test.GodTestAbstract;

public class A6_여러_개의_파일을_삭제한다 extends GodTestAbstract {

//	@Resource(name = "EgovFileMngService")
	@Autowired
//	@Qualifier("EgovFileMngService")
	private EgovFileMngService egovFileMngService;

	@Override
	@Test
	public void test() {
		egovLogger.debug("여러 개의 파일을 삭제한다.");

		String atchFileId = "FILE_000000000000035";

		List<FileVO> fvoList = new ArrayList<>();

		FileVO fvo = new FileVO();
		fvo.setAtchFileId(atchFileId);
		fvo.setFileSn("1");
		fvoList.add(fvo);

		fvo = new FileVO();
		fvo.setAtchFileId(atchFileId);
		fvo.setFileSn("2");
		fvoList.add(fvo);

		for (int i = 0; i < 15; i++) {
			fvo = new FileVO();
			fvo.setAtchFileId(atchFileId);
			fvo.setFileSn(String.valueOf(i));
			fvoList.add(fvo);
		}

		try {
			egovFileMngService.deleteFileInfs(fvoList);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}
	}

}
