SSO연계 서비스 테스트

/god.com/src/main/java/egovframework/com/sec/security/filter/EgovSpringSecurityLoginFilter.java
//springSecurity.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher(request.getServletContext().getContextPath() +"/egov_security_login", "POST"));
springSecurity.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher(request.getServletContext().getContextPath() +"/egov_security_login", "GET"));
springSecurity.setPostOnly(false);

---

/god.com/src/main/resources/egovframework/egovProps/globals.properties
Globals.Auth = security

/god.com/src/main/java/egovframework/com/cmm/context/EgovWebServletContextListener.java

http://localhost:8080/com/uat/uap/selectLoginPolicyList.do

---

12월 17, 2020 7:42:22 오후 org.apache.catalina.core.StandardWrapperValve invoke
심각: 경로가 [/com]인 컨텍스트의 서블릿 [dispatcher]을(를) 위한 Servlet.service() 호출이 예외를 발생시켰습니다.
org.springframework.security.web.firewall.RequestRejectedException: The request was rejected because the URL contained a potentially malicious String ";"

http://localhost:8080/com/uat/uia/egovLoginUsr.do;jsessionid=6284DF58F18B4E7DA5DCE8463697131D

/god.com/src/main/resources/egovframework/spring/com/context-security.xml
&lt;!-- URL에 세미콜론(semicolon)허용 여부(기본값/false) --&gt;

---

/god.com/src/main/webapp/WEB-INF/web.xml
    &lt;!-- &lt;error-page&gt;
      &lt;error-code&gt;404&lt;/error-code&gt;
      &lt;location&gt;/code404.jsp&lt;/location&gt;
    &lt;/error-page&gt;
    
    &lt;error-page&gt;
      &lt;error-code&gt;500&lt;/error-code&gt;
      &lt;location&gt;/code500.jsp&lt;/location&gt;
    &lt;/error-page&gt; --&gt;

---

http://localhost:8080/com/uat/uia/actionLogin.do?message=&id=USER&password=rhdxhd12&pwd=&userSe=GNR&j_username=

get

HTTP 상태 404 – 찾을 수 없음

/com/egov_security_login

Origin 서버가 대상 리소스를 위한 현재의 representation을 찾지 못했거나, 그것이 존재하는지를 밝히려 하지 않습니다.

---

12월 17, 2020 8:20:03 오후 org.apache.catalina.core.StandardWrapperValve invoke
심각: 경로가 [/com]인 컨텍스트의 서블릿 [dispatcher]을(를) 위한 Servlet.service() 호출이 예외를 발생시켰습니다.
java.lang.IllegalStateException: getAttribute: 세션이 이미 무효화되었습니다.

---

https://www.egovframe.go.kr/wiki/doku.php?id=egovframework:com:v2:uat:sso%EC%97%B0%EA%B3%84_%EC%84%9C%EB%B9%84%EC%8A%A4
