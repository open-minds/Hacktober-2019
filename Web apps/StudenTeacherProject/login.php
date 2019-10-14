<?php
session_start();
if (isset($_SESSION["Email"]) && isset($_SESSION["Password"])) {
	if($_SESSION["Type"]=='T'){
		echo "haha";
		header('location: teacher.php');
		exit();
	}else{
		header('location: student.php');
		exit();
	}
}
?>
<!DOCTYPE html>
<html>
<head>
	<title>Login</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="style/navbar.css">
	<link rel="stylesheet" type="text/css" href="style/login.css">
</head>
<body>
	<nav>
		<ul class="topnav">
			<li><a href="#home">Home</a></li>
			<li><a href="login.php" class="active">login</a></li>
			<li><a href="signup.php">signup</a></li>
			<li class="right"><a href="#about">About</a></li>
		</ul>
	</nav>
	<div style="text-align:center ; margin-top: 100px">
		<form id="login-form" action="loginsrvr.php" method="POST" target="_blank" onsubmit="return false">
			<label for="email">Email:</label><input id="email" type="text" name="email" placeholder="Email" required="true"><br>
			<label for="password">Password:</label><input id="password" type="password" name="password" placeholder="Password" required="true"><br>
			<input type="submit" value="Login">
		</form>
	</div>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#login-form").submit(function(event){
				var email = $("#email").val();
				var password = $("#password").val();
				$.ajax(
				{
					url :'loginsrvr.php',
					method : 'POST',
					data: {
						emailPHP: email,
						passwordPHP:password
					},
					success : function(response) {
						if(response=="Failed"){
							$('#password').css('border-color', 'red');
						}else{
							if(response=='T'){
								window.location.href="teacher.php";
							}else{
								window.location.href="student.php";
							}
						}
					},
					dataType : 'text'
				});
			});
		});
	</script>
</body>
</html>