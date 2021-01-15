package egovframework.com.cop.ems.service.impl.sndngmaildetaildao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cop.ems.service.SndngMailVO;
import egovframework.com.cop.ems.service.impl.SndngMailDetailDAO;
import god.test.GodTestAbstract;

public class GOD_A2_selectAtchmnFileList extends GodTestAbstract {

//	@Resource(name = "sndngMailDetailDAO")
	@Autowired
//	@Qualifier("sndngMailDetailDAO")
	private SndngMailDetailDAO sndngMailDetailDAO;

	@Override
	@Test
	public void test() {
		egovLogger.debug("발송메일에 첨부된 파일목록을 조회한다.");

		SndngMailVO vo = new SndngMailVO();
		vo.setMssageId("1");

		List<?> results = null;

		try {
			results = sndngMailDetailDAO.selectAtchmnFileList(vo);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		egovLogger.debug("results: {}", results);
	}

}
