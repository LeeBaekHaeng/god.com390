<%@page import="java.util.List"%>
<%@page import="egovframework.com.cmm.LoginVO"%>
<%@page import="egovframework.com.cmm.util.EgovUserDetailsHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%
	LoginVO authenticatedUser = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
	List<String> authorities = EgovUserDetailsHelper.getAuthorities();
	Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();

	request.setAttribute("authenticatedUser", authenticatedUser);
	request.setAttribute("authorities", authorities);
	request.setAttribute("isAuthenticated", isAuthenticated);
%>

<h2>EgovUserDetailsHelper</h2>
<h3>authenticatedUser</h3>
<ol>
	<li>authenticatedUser: <c:out value="${authenticatedUser}" /></li>
	<li>name: <c:out value="${authenticatedUser.name}" /></li>
</ol>
<h3>authorities</h3>
<ol>
	<li>authorities: <c:out value="${authorities}" /></li>
	<c:forEach items="${authorities}" var="authority">
		<li>authority: <c:out value="${authority}" /></li>
	</c:forEach>
</ol>
<h3>isAuthenticated</h3>
<ol>
	<li>isAuthenticated: <c:out value="${isAuthenticated}" /></li>
</ol>

<h2>loginVO</h2>
<ol>
	<li><c:out value="${loginVO}" /></li>
	<li><c:out value="${loginVO.name}" /></li>
</ol>
