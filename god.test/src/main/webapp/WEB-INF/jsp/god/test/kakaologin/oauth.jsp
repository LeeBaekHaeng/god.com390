<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Kakao JavaScript SDK</title>
<script
	src="${pageContext.request.contextPath}/js/egovframework/com/cmm/jquery-1.12.4.min.js"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script>
	// SDK를 초기화 합니다. 사용할 앱의 JavaScript 키를 설정해 주세요.
	Kakao.init('772e3c0b76e818aa6a45c274028c5b54');

	// SDK 초기화 여부를 판단합니다.
	console.log(Kakao.isInitialized());

	$
			.post(
					'https://kauth.kakao.com/oauth/token',
					{
						grant_type : 'authorization_code',
						client_id : '16726536a924a18a4cb2e62ff4e2afcc',
						// 		client_id : '1fb506b1f77f07dab5bc79e7f654ed75',
						redirect_uri : 'http://localhost:8080/test/oauth',
						code : '${param.code}',
					// 			client_secret : '',
					},
					function(data) {
						console.log('data', data);
						console.log('access_token', data.access_token);
						// 		Kakao.Auth.setAccessToken(data.access_token);
						document.cookie = 'authorize-access-token='
								+ data.access_token;
						location.href = '${pageContext.request.contextPath}/kakaologin/login.do';
					}, 'json');
</script>
</head>
<body>

</body>
</html>