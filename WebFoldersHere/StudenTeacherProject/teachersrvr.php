<?php

session_start();

if($_POST["questionphp"]!="" && $_POST["answerphp"]!=""){
$qstn = $_POST["questionphp"];
$ansr = $_POST["answerphp"];
$domain=$_POST["domainphp"];
$owner = $_SESSION["Email"];

// Attempt MySQL server connection.
$link = mysqli_connect("localhost", "root","");

// Check connection.
if(!$link)die("ERROR: Could not connect. " . mysqli_connect_error());

//Selecting DB.
$db_selected=  mysqli_select_db($link,"miniproject2");

$sql1 = "SELECT id from users WHERE Email = '$owner'";
$id = mysqli_query($link,$sql1);
$row = $id -> fetch_assoc();
$row = $row["id"];
$sql = "INSERT INTO questions(Domain,Qstn,Answr,qstnowner) VALUES ('$domain','$qstn','$ansr','$row')";

if(mysqli_query($link, $sql)){
	echo "haha done";
	mysqli_close($link);
	exit();
} else{
	echo "ERROR: Could not able to execute $sql. " . mysqli_error($link);
}
}


?>