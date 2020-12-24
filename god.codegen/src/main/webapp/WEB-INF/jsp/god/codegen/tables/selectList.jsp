<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr>
			<th>index</th>
			<th>count</th>
			<!-- 			<th>table</th> -->
			<th>tableSchema</th>
			<th>tableName</th>
			<th>tableComment</th>
		</tr>
		<c:forEach items="${tables}" var="table" varStatus="i">
			<tr>
				<td><c:out value="${i.index}" /></td>
				<td><c:out value="${i.count}" /></td>
				<%-- 				<td><c:out value="${table}" /></td> --%>
				<td><c:out value="${table.tableSchema}" /></td>
				<td><c:out value="${table.tableName}" /></td>
				<td><c:out value="${table.tableComment}" /></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>