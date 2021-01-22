package kr.or.kisa.seed;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KISA_SHA256Test {

	protected Logger egovLogger = LoggerFactory.getLogger(KISA_SHA256Test.class);

	private static final String charsetName = StandardCharsets.UTF_8.name();

	@Test
	public void test() throws Exception {
		egovLogger.debug("test");

		String encrypt = encrypt("god 갓");
		egovLogger.debug("encrypt: {}", encrypt);
	}

	/**
	 * 암호화
	 * 
	 * @param plainText 평문
	 * @return
	 */
	public String encrypt(String plainText) {
		try {
			byte[] pszMessage = plainText.getBytes(charsetName);
			int uPlainTextLen = pszMessage.length;
			byte[] pszDigest = new byte[32];

			KISA_SHA256.SHA256_Encrpyt(pszMessage, uPlainTextLen, pszDigest);

			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < pszDigest.length; i++) {
				String hex = Integer.toHexString(0xff & pszDigest[i]);
				if (hex.length() == 1) {
					buffer.append('0');
				}
				buffer.append(hex);
			}

			return buffer.toString();
		} catch (UnsupportedEncodingException e) {
			egovLogger.error(e.getMessage());
			return null;
		}
	}

}
