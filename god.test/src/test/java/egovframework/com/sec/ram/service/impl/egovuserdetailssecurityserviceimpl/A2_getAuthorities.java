package egovframework.com.sec.ram.service.impl.egovuserdetailssecurityserviceimpl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.com.cmm.util.EgovUserDetailsHelper;
import god.test.GodWebTestAbstract;

public class A2_getAuthorities extends GodWebTestAbstract {

	protected Logger egovLogger = LoggerFactory.getLogger(A2_getAuthorities.class);

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		// given

		// when
		List<String> authorities = EgovUserDetailsHelper.getAuthorities();

		// then
		assertEquals(authorities, null);

		egovLogger.debug("authorities={}", authorities);
	}

}
