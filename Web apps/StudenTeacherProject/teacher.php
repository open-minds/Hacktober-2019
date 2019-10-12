<?php
session_start();
if (!isset($_SESSION["Email"]) && !isset($_SESSION["Password"]) && $_SESSION["Type"]!='T') {
	header("Location: login.php");
	exit();
}
?>
<!DOCTYPE html>
<html>
<head>
	<title>Teacher</title>
	<script type="text/javascript" src="js/teacher.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<center style="margin-top: 100px">
		<input id="logout" type="button" name="logout" value="Logout" onclick="window.location.href='logout.php'"><br>
		<input id="qtns" type="button" name="questions" value="Questions" ><br>
		<div id="qstnswrpr">
			<form action="teacher.php" method="POST" onsubmit="return false">
				<input id="qstn1" type="text" name="qstn" required="true">
				<input id="ansr1" type="text" name="ansr" required="true">
				<select name="Domain">
					<optgroup label="Domain">
						<option value="Biologie">Biologie</option>
						<option value="Informatique">Informatique</option>
						<option value="Math">Math</option>
						<option value="Physique">Physique</option>
						<option value="Pharmacy">Pharmacy</option>
					</select>
					<input type="submit" name="submit">
				</form>
			</div>
		</center>	
	</body>
	</html>