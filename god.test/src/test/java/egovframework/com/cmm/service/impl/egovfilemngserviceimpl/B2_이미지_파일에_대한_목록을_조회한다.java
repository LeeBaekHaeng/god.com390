package egovframework.com.cmm.service.impl.egovfilemngserviceimpl;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cmm.service.EgovFileMngService;
import egovframework.com.cmm.service.FileVO;
import god.test.GodTestAbstract;

public class B2_이미지_파일에_대한_목록을_조회한다 extends GodTestAbstract {

//	@Resource(name = "EgovFileMngService")
	@Autowired
//	@Qualifier("EgovFileMngService")
	private EgovFileMngService egovFileMngService;

	@Override
	@Test
	public void test() {
		egovLogger.debug("이미지 파일에 대한 목록을 조회한다.");

		FileVO vo = new FileVO();
		vo.setAtchFileId("FILE_000000000000034");

		List<FileVO> results = null;

		try {
			results = egovFileMngService.selectImageFileList(vo);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		DebugUtils.debug(results);
	}

}
