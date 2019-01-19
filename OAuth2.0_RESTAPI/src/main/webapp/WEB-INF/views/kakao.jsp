<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width"/>
<title>Login Demo - Kakao JavaScript SDK</title>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
</head>
<body>
<a id="kakao-login-btn"></a>
<a href="http://developers.kakao.com/logout"></a>
<script type='text/javascript'>
	//<![CDATA[

		Kakao.init('1a13f4981bdf4963532f1b66e10cb0e4');

		Kakao.Auth.createLoginButton({
			container: '#kakao-login-btn',
			success: function(authObj) {
				console.log(JSON.stringify(authObj));
				
				$.ajax({
					type		: "POST",
					url			: "/sign/kakao",
					data		: {authorization : authObj.access_token},
					success: function(result){
						console.log(result);
					}
				});
			},
			fail: function(err) {
				console.log(JSON.stringify(err));
			}
		});
	//]]>
</script>

</body>
</html>