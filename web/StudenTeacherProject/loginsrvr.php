<?php
session_start();

$Email= $_POST["emailPHP"];
$Password = $_POST["passwordPHP"];

/* Attempt MySQL server connection. Assuming you are running MySQL
server with default setting (user 'root' with no password) */
$link = mysqli_connect("localhost", "root","");

// Check connection
if(!$link)die("ERROR: Could not connect. " . mysqli_connect_error());

$db_selected=  mysqli_select_db($link,"miniproject2");

// Attempt get query execution
$sql = "SELECT Email,Password,Type from Users where Email ='$Email' and Password= '$Password'";
$result = mysqli_query($link, $sql);

// Close connection
mysqli_close($link);
if($result->num_rows > 0){
	while($row = $result->fetch_assoc()) {
		$_SESSION['Email']=$row['Email'];
		$_SESSION['Password']=$row['Password'];
		$_SESSION['Type'] = $row['Type']; 
		exit($row['Type']);
	}
}else{
	exit ('Failed');
}