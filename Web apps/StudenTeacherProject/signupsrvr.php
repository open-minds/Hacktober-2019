<?php

$Nom = $_POST["nom"];
$Prenom= $_POST["prenom"];
$Email = $_POST["email"];
$Password = $_POST["password"];
$Type = $_POST["type"];
$Tel = $_POST["phone"];

// Attempt MySQL server connection.
$link = mysqli_connect("localhost", "root","");

// Check connection.
if(!$link)die("ERROR: Could not connect. " . mysqli_connect_error());

//Selecting DB.
$db_selected=  mysqli_select_db($link,"miniproject2");

// Attempt get query execution
$sql = "SELECT Email from Users where Email ='$Email'";
$result = mysqli_query($link, $sql);

if($result ->num_rows>0){
	exit("already signed up !");
}else{
	$sql = "INSERT INTO Users(email,password,nom,prenom,type,tel) VALUES ('$Email','$Password','$Nom','$Prenom','$Type','$Tel')";
	if(mysqli_query($link, $sql)){
		// Close connection
		mysqli_close($link);
		header('location: login.php');
		exit();
	} else{
		echo "ERROR: Could not able to execute $sql. " . mysqli_error($link);
	}
}

?>