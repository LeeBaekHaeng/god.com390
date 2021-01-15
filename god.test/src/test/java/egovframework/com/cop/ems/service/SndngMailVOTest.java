package egovframework.com.cop.ems.service;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import god.test.java.lang.clazz.GOD_A060_getDeclaredFields;

public class SndngMailVOTest {

	protected Logger egovLogger = LoggerFactory.getLogger(GOD_A060_getDeclaredFields.class);

	@Test
	public void test() {
		SndngMailVO vo = new SndngMailVO();

		vo.setMssageId("");
		vo.setDsptchPerson("");
		vo.setRecptnPerson("");
		vo.setSj("");
		vo.setSndngResultCode("");
		vo.setEmailCn("");
		vo.setAtchFileId("");
		vo.setFileStreCours("");
		vo.setOrignlFileNm("");
		vo.setSndngDe("");
		vo.setAtchFileIdList("");
		vo.setXmlContent("");
		vo.setLink("");

		egovLogger.debug("mssageId: {}", vo.getMssageId());
		egovLogger.debug("dsptchPerson: {}", vo.getDsptchPerson());
		egovLogger.debug("recptnPerson: {}", vo.getRecptnPerson());
		egovLogger.debug("sj: {}", vo.getSj());
		egovLogger.debug("sndngResultCode: {}", vo.getSndngResultCode());
		egovLogger.debug("emailCn: {}", vo.getEmailCn());
		egovLogger.debug("atchFileId: {}", vo.getAtchFileId());
		egovLogger.debug("fileStreCours: {}", vo.getFileStreCours());
		egovLogger.debug("orignlFileNm: {}", vo.getOrignlFileNm());
		egovLogger.debug("sndngDe: {}", vo.getSndngDe());
		egovLogger.debug("atchFileIdList: {}", vo.getAtchFileIdList());
		egovLogger.debug("xmlContent: {}", vo.getXmlContent());
		egovLogger.debug("link: {}", vo.getLink());
	}

}
