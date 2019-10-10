<?php
	session_start();

	unset($_SESSION['loggedIN']);
	unset($_SESSION['Email']);
	unset($_SESSION['Password']);
	session_destroy();
	header('location: login.php');
	exit();


  ?>