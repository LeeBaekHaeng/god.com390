<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Kakao JavaScript SDK</title>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script>
	// SDK를 초기화 합니다. 사용할 앱의 JavaScript 키를 설정해 주세요.
	Kakao.init('772e3c0b76e818aa6a45c274028c5b54');

	// SDK 초기화 여부를 판단합니다.
	console.log(Kakao.isInitialized());
</script>
</head>
<body>

	<a id="custom-login-btn" href="javascript:loginWithKakao()"> <img
		src="//k.kakaocdn.net/14/dn/btqCn0WEmI3/nijroPfbpCa4at5EIsjyf0/o.jpg"
		width="222" />
	</a>
	<p id="token-result"></p>
	<p id="user-result"></p>
	<script type="text/javascript">
  function loginWithKakao() {
    Kakao.Auth.authorize({
//       redirectUri: 'https://developers.kakao.com/tool/demo/oauth'
      redirectUri: 'http://localhost:8080/test/oauth'
    })
  }
  // 아래는 데모를 위한 UI 코드입니다.
  displayToken()
  function displayToken() {
    const token = getCookie('authorize-access-token')
    if(token) {
      Kakao.Auth.setAccessToken(token)
      Kakao.Auth.getStatusInfo(({ status }) => {
        if(status === 'connected') {
          document.getElementById('token-result').innerText = 'login success. token: ' + Kakao.Auth.getAccessToken()
          Kakao.Auth.getStatusInfo(function(res) {
            console.log('res', res);
            console.log('user', res.user);
            console.log('id', res.user.id);
            console.log('kakao_account', res.user.kakao_account);
            console.log('profile', res.user.kakao_account.profile);
            console.log('nickname', res.user.kakao_account.profile.nickname);
            console.log('iconnected_at', res.user.connected_at);
            document.getElementById('user-result').innerText = '회원번호: '+res.user.id + ', 서비스에 연결 완료된 시각, UTC: ' + res.user.connected_at + ', 닉네임: ' + res.user.kakao_account.profile.nickname;
          });
        } else {
          Kakao.Auth.setAccessToken(null)
        }
      })
    }
  }
  function getCookie(name) {
    const value = "; " + document.cookie;
    const parts = value.split("; " + name + "=");
    if (parts.length === 2) return parts.pop().split(";").shift();
  }
</script>

</body>
</html>