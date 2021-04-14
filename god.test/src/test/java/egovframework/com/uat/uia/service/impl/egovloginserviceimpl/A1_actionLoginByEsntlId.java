package egovframework.com.uat.uia.service.impl.egovloginserviceimpl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cmm.LoginVO;
import egovframework.com.uat.uia.service.EgovLoginService;
import god.test.GodTestAbstract;

public class A1_actionLoginByEsntlId extends GodTestAbstract {

	@Autowired
	EgovLoginService service;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		// given
		LoginVO vo = new LoginVO();
		vo.setUserSe("GNR");
		vo.setUniqId("USRCNFRM_00000000001");

		// when
		LoginVO result = null;
		try {
			result = service.actionLoginByEsntlId(vo);
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
		}

		// then
		assertEquals(result.getUniqId(), vo.getUniqId());

		egovLogger.debug("result={}", result);
		egovLogger.debug("getUniqId={}", result.getUniqId());
	}

}
