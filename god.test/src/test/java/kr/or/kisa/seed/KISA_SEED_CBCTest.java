package kr.or.kisa.seed;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KISA_SEED_CBCTest {

	protected Logger egovLogger = LoggerFactory.getLogger(KISA_SEED_CBCTest.class);

	private static final String charsetName = StandardCharsets.UTF_8.name();
//	private static final byte[] pbszUserKey = "88,E3,4F,8F,08,17,79,F1,E9,F3,94,37,0A,D4,05,89".getBytes();
//	private static final byte[] pbszIV = "26,8D,66,A7,35,A8,1A,81,6F,BA,D9,FA,36,16,25,01".getBytes();
	private static final byte[] pbszUserKey = "1234567890123456".getBytes();
//	private static final byte[] pbszUserKey = Base64.getDecoder().decode(Base64.getEncoder().encode("1234567890123456".getBytes()));
	private static final byte[] pbszIV = "1234567890123456".getBytes();

	@Test
	public void test() throws Exception {
		egovLogger.debug("test");

		String encrypt = encrypt("god 갓");
		egovLogger.debug("encrypt: {}", encrypt);

		String decrypt = decrypt(encrypt);
		egovLogger.debug("decrypt: {}", decrypt);
	}

	/**
	 * 암호화
	 * 
	 * @param plainText 평문
	 * @return
	 */
	public String encrypt(String plainText) {
		try {
			byte[] message = plainText.getBytes(charsetName);
			int message_offset = 0;
			int message_length = message.length;

			byte[] bs = KISA_SEED_CBC.SEED_CBC_Encrypt(pbszUserKey, pbszIV, message, message_offset, message_length);

			byte[] encode = Base64.getEncoder().encode(bs);

			return new String(encode, charsetName);
		} catch (UnsupportedEncodingException e) {
			egovLogger.error(e.getMessage());
			return null;
		}
	}

	/**
	 * 복호화
	 * 
	 * @param cryptogram 암호문
	 * @return
	 */
	public String decrypt(String cryptogram) {
		try {
			byte[] message = cryptogram.getBytes(charsetName);
			byte[] decode = Base64.getDecoder().decode(message);

			int message_offset = 0;
			int message_length = decode.length;

			byte[] bs = KISA_SEED_CBC.SEED_CBC_Decrypt(pbszUserKey, pbszIV, decode, message_offset, message_length);

			return new String(bs, charsetName);
		} catch (UnsupportedEncodingException e) {
			egovLogger.error(e.getMessage());
			return null;
		}
	}

}
