<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="google-signin-client_id" content="788806329174-6aufaqsdku9p51avh129kkusgk9i1v0t.apps.googleusercontent.com">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script src="https://apis.google.com/js/client:platform.js?onload=start" async defer></script>

<script type="text/javascript">
	function start(){
		gapi.load('auth2', function(){
			auth2 = gapi.auth2.init({
				client_id: '788806329174-6aufaqsdku9p51avh129kkusgk9i1v0t.apps.googleusercontent.com'
			});
		});
		
		gapi.signin2.render('my-signin2', {
			'scope': 'profile email',
			'width': 400,
			'height': 50,
			'longtitle': true,
			'theme': 'dark'
		});
		
		$("#my-signin2").css({"width": "400px"});
	}
</script>
</head>
<body>
	<div id="my-signin2"></div>
	<script type="text/javascript">
	
		$('#my-signin2').click(function() {
			auth2.grantOfflineAccess().then(signInCallback);
		});
		
		function signInCallback(authResult){
			console.log(authResult);
			
			if (authResult['code']) {
				console.log("authResult['code'] : " + authResult['code']);
				
				$.ajax({
					type: 'POST',
					url: '/sign/googleAuth',
					headers: {
						'X-Requested-With': 'XMLHttpRequest'
					}, 
					contentType: 'application/x-www-form-urlencoded;charset=UTF-8',
					success: function(result) {
						console.log(result);
					},
					processData: true,
					data: {"code":authResult['code']}
				});
			} else {
				console.log("error");
			}
		}
	</script>
</body>

</html>