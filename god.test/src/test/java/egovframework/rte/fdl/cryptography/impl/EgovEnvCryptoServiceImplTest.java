package egovframework.rte.fdl.cryptography.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.rte.fdl.cryptography.EgovEnvCryptoService;
import god.test.GodTestAbstract;

public class EgovEnvCryptoServiceImplTest extends GodTestAbstract {

	@Autowired
	private EgovEnvCryptoService egovEnvCryptoService;

	@Override
	@Test
	public void test() {
		egovLogger.debug("test");

		egovLogger.debug("isCrypto: {}", egovEnvCryptoService.isCrypto());

		String password = egovEnvCryptoService.getPassword();

		egovLogger.debug("password: {}", password);

		assertEquals(password, "com01");

		// encrypt
		String encrypt = "com01";
		String encrypt2 = egovEnvCryptoService.encrypt(encrypt);
		String encryptNone = egovEnvCryptoService.encryptNone(encrypt);
		egovLogger.debug("encrypt: {}", encrypt);
		egovLogger.debug("encrypt2: {}", encrypt2);
		egovLogger.debug("encryptNone: {}", encryptNone);
		assertEquals(encrypt2, "xz4fmrSdr1vGGl6UtwPLwA%3D%3D");
	}

}
