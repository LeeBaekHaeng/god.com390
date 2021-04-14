<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div id="divTest"></div>

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/egovframework/com/cmm/jquery-1.12.4.min.js"></script>

	<script type="text/javascript">
		$.get('http://localhost:8080/test/api/v1/a1', {}, function(data) {
			console.log('data=', data);
			$('#divTest').text(JSON.stringify(data));
		}, 'json');
	</script>

</body>
</html>