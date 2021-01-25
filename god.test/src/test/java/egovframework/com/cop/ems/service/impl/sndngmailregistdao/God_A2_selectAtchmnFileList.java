package egovframework.com.cop.ems.service.impl.sndngmailregistdao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cop.ems.service.AtchmnFileVO;
import egovframework.com.cop.ems.service.SndngMailVO;
import egovframework.com.cop.ems.service.impl.SndngMailRegistDAO;
import god.test.GodTestAbstract;

public class God_A2_selectAtchmnFileList extends GodTestAbstract {

	@Autowired
	private SndngMailRegistDAO dao;

	@SuppressWarnings("unchecked")
	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		SndngMailVO vo = new SndngMailVO();
		vo.setAtchFileId("test god");

		List<AtchmnFileVO> results = null;

		try {
			results = (List<AtchmnFileVO>) dao.selectAtchmnFileList(vo);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		egovLogger.debug("results: {}", results);
	}

}
