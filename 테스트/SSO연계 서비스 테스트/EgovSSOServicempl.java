/**
 * 개요
 * - 로그인정책에 대한 ServiceImpl 클래스를 정의한다.
 * 
 * 상세내용
 * - 로그인정책에 대한 등록, 수정, 삭제, 조회, 반영확인 기능을 제공한다.
 * - 로그인정책의 조회기능은 목록조회, 상세조회로 구분된다.
 * @author lee.m.j
 * @version 1.0
 * @created 03-8-2009 오후 2:08:54
 *   <pre>
 * == 개정이력(Modification Information) ==
 * 
 *   수정일       수정자           수정내용
 *  -------     --------    ---------------------------
 *  2009.8.3    이문준     최초 생성
 * </pre>
 */

package egovframework.com.uat.sso.service.impl;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Service;

import egovframework.com.cmm.LoginVO;
import egovframework.com.uat.sso.service.EgovSSOService;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("egovSSOService")
public class EgovSSOServicempl extends EgovAbstractServiceImpl implements EgovSSOService {

	@Override
	public boolean hasTokenInSSOServer(ServletRequest request, ServletResponse response) {
		return true;
	}

	@Override
	public void requestIssueToken(ServletRequest request, ServletResponse response) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void ssoLoginByServer(ServletRequest request, ServletResponse response) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public LoginVO getLoginVO(ServletRequest request, ServletResponse response) {
		LoginVO loginVO = new LoginVO();
		loginVO.setUniqId("USRCNFRM_00000000000");
		loginVO.setUserSe("USR");
		loginVO.setPassword("TEST1TEST1");
		return loginVO;
	}

	@Override
	public void ssoLogout(ServletRequest request, ServletResponse response, String returnURL) throws IOException {
		// TODO Auto-generated method stub

	}

}
