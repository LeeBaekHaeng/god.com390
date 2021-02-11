package egovframework.com.uat.uap.service.impl.loginpolicydao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.com.uat.uap.service.LoginPolicyVO;

public class LoginPolicyVOLogger {

	protected static Logger egovLogger = LoggerFactory.getLogger(LoginPolicyVOLogger.class);

	public static void debug(LoginPolicyVO loginPolicyVO) {
		egovLogger.debug("loginPolicyVO: {}", loginPolicyVO);
		egovLogger.debug("getEmplyrId: {}", loginPolicyVO.getEmplyrId());
		egovLogger.debug("getEmplyrNm: {}", loginPolicyVO.getEmplyrNm());
		egovLogger.debug("getEmplyrSe: {}", loginPolicyVO.getEmplyrSe());
		egovLogger.debug("getIpInfo: {}", loginPolicyVO.getIpInfo());
		egovLogger.debug("getDplctPermAt: {}", loginPolicyVO.getDplctPermAt());
		egovLogger.debug("getLmttAt: {}", loginPolicyVO.getLmttAt());
		egovLogger.debug("getUserId: {}", loginPolicyVO.getUserId());
		egovLogger.debug("getRegDate: {}", loginPolicyVO.getRegDate());
		egovLogger.debug("getRegYn: {}", loginPolicyVO.getRegYn());
	}

	public static void debug(List<LoginPolicyVO> results) {
		egovLogger.debug("results: {}", results);
		egovLogger.debug("size: {}", results.size());
		results.forEach(result -> debug(result));
	}

}
