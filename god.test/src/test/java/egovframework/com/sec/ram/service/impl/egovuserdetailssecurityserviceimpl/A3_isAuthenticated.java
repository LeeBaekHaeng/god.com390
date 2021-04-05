package egovframework.com.sec.ram.service.impl.egovuserdetailssecurityserviceimpl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.com.cmm.util.EgovUserDetailsHelper;
import god.test.GodWebTestAbstract;

public class A3_isAuthenticated extends GodWebTestAbstract {

	protected Logger egovLogger = LoggerFactory.getLogger(A3_isAuthenticated.class);

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		// given

		// when
		Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();

		// then
		assertEquals(isAuthenticated, false);

		egovLogger.debug("isAuthenticated={}", isAuthenticated);
	}

}
