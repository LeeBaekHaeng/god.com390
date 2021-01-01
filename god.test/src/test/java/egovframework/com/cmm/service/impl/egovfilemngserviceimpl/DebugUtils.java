package egovframework.com.cmm.service.impl.egovfilemngserviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.com.cmm.service.FileVO;

public class DebugUtils {

	protected static Logger egovLogger = LoggerFactory.getLogger(DebugUtils.class);

	public static void debug(FileVO fileVO) {
		egovLogger.debug("fileVO: {}", fileVO);

		if (fileVO == null) {
			return;
		}

		egovLogger.debug("getAtchFileId: {}", fileVO.getAtchFileId());
		egovLogger.debug("getFileCn: {}", fileVO.getFileCn());
		egovLogger.debug("getFileExtsn: {}", fileVO.getFileExtsn());
		egovLogger.debug("getFileMg: {}", fileVO.getFileMg());
		egovLogger.debug("getFileSn: {}", fileVO.getFileSn());
		egovLogger.debug("getFileStreCours: {}", fileVO.getFileStreCours());
		egovLogger.debug("getOrignlFileNm: {}", fileVO.getOrignlFileNm());
		egovLogger.debug("getStreFileNm: {}", fileVO.getStreFileNm());
	}

	public static void debug2(FileVO fileVO) {
		egovLogger.debug("fileVO: {}", fileVO);

		if (fileVO == null) {
			return;
		}

		egovLogger.debug("getAtchFileId: {}", fileVO.getAtchFileId());
		egovLogger.debug("getFileCn: {}", fileVO.getFileCn());
		egovLogger.debug("getFileSn: {}", fileVO.getFileSn());
		egovLogger.debug("getFileStreCours: {}", fileVO.getFileStreCours());
		egovLogger.debug("getStreFileNm: {}", fileVO.getStreFileNm());
		egovLogger.debug("getFileExtsn: {}", fileVO.getFileExtsn());
		egovLogger.debug("getOrignlFileNm: {}", fileVO.getOrignlFileNm());
		egovLogger.debug("getFileMg: {}", fileVO.getFileMg());
	}

}
