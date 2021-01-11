package egovframework.com.cmm.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.com.cmm.service.CmmnDetailCode;

public class CmmnDetailCodeDebugUtils {

	protected static Logger egovLogger = LoggerFactory.getLogger(CmmnDetailCodeDebugUtils.class);

	public static void debug(List<CmmnDetailCode> results) {
		if (!egovLogger.isDebugEnabled()) {
			return;
		}

		egovLogger.debug("results: {}", results);

		if (results == null) {
			return;
		}

		egovLogger.debug("size: {}", results.size());

		for (CmmnDetailCode result : results) {
			egovLogger.debug("result: {}", result);
			egovLogger.debug("getCodeId: {}", result.getCodeId());
			egovLogger.debug("getCode: {}", result.getCode());
			egovLogger.debug("getCodeNm: {}", result.getCodeNm());
			egovLogger.debug("getCodeDc: {}", result.getCodeDc());
		}
	}

}
