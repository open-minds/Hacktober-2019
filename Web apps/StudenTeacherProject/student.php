<?php
session_start();
if (!isset($_SESSION["Email"]) && !isset($_SESSION["Password"]) && $_SESSION["Type"]!='S') {
	header("Location: login.php");
	exit();
}
?>
<!DOCTYPE html>
<html>
<head>
	<title>Student</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script type="text/javascript" src="js/student.js"></script>
	<link rel="stylesheet" type="text/css" href="style/student.css">
</head>
<body>
	<center style="margin-top: 100px">
		
		<input id="logout" type="button" name="logout" value="Logout" onclick="window.location.href='logout.php'"><br>
		<form id="searchform" autocomplete="off" action="studentsrvr.php" method="POST" onsubmit="return false">
			<div class="autocomplete" style="width:300px;">
				<input id="searchbox" type="text" name="myDomain" placeholder="Domain" required="true">
			</div>
			<input type="submit" value="search">
		</form>

		<div id="qstnspace" style="width:700px;">	
		</div>
	</center>

</body>
</html>