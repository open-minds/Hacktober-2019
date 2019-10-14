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
	<title>MiniProjet2</title>
	<link rel="stylesheet" type="text/css" href="style/navbar.css">
	<link rel="stylesheet" type="text/css" href="style/login.css">
</head>
<body >
		<nav>
		<ul class="topnav">
			<li><a href="#home">Home</a></li>
			<li><a href="login.php" >login</a></li>
			<li><a href="signup.php" class="active">signup</a></li>
			<li class="right"><a href="#about">About</a></li>
		</ul>
	</nav>
	<div style="text-align:center ; margin-top: 100px">
		<form action="signupsrvr.php" method="POST" target="_blank">
			<input type="text" name="nom" placeholder="Nom" style="height: 30px ;width: 200px;" required="true"><br>
			<input type="text" name="prenom" placeholder="Prenom" style="height: 30px ;width: 200px; margin-top: 5px" required="true"><br>
			<input type="email" name="email" placeholder="E-Mail" style="height: 30px ;width: 200px;margin-top: 5px" required="true"><br>
			<input type="password" name="password" placeholder="Password" style="height: 30px ;width: 200px;margin-top: 5px"><br>
			<select name="type"> <optgroup label="Type"><option value="S">Student</option><option value="T">Teacher</option></optgroup></select><br>
			<input type="tel" name="phone" placeholder="Numero de telephone" style="height: 30px ;width: 200px;margin-top: 5px" required="true"><br>
			<input type="submit" value="SignUp">
		</form>
	</div>
</body>
</html>