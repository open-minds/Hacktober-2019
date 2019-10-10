<?php
session_start();

// Attempt MySQL server connection.
$link = mysqli_connect("localhost", "root","");

// Check connection.
if(!$link)die("ERROR: Could not connect. " . mysqli_connect_error());

//Selecting DB.
$db_selected=  mysqli_select_db($link,"miniproject2");

$Email=$_SESSION["Email"];
$sql = "SELECT id from Users where Email ='$Email' ";
$result = mysqli_query($link, $sql);
$row = $result->fetch_assoc();
$stdid = $row['id'];
$domain = $_POST["domain"];

$sql = "SELECT Answr from questions where Domain ='$domain'";
$result = mysqli_query($link, $sql);
$row = $result->fetch_assoc();
$correctanswer = $row['Answr'];
$qid = $_POST["qid"];

$sql = "SELECT nbAnswrRight,nbAnswrFalse from stdscore where StdId ='$stdid'and Domain='$domain' ";
$result = mysqli_query($link, $sql) ;
$row = $result->fetch_assoc() ;
	
if($result->num_rows==0){
	$nbAnswrFalse=0;
	$nbAnswrRight=0;
	if($correctanswer==$_POST["answer"]){
		$nbAnswrRight++;
		echo "true";
	}else{
		echo "wrong";
		$nbAnswrFalse++;
	}
	echo "m here ";
	$sql = "INSERT INTO stdscore(StdId,Domain,nbAnswrRight,nbAnswrFalse) VALUES ('$stdid','$domain','$nbAnswrRight','$nbAnswrFalse')";
	if(mysqli_query($link, $sql)){
		echo "inserted successfuly";
	}else{
		echo "ERROR: Could not able to execute $sql. " . mysqli_error($link);
	}
}else{
	$nbAnswrRight= $row['nbAnswrRight'];
	$nbAnswrFalse = $row['nbAnswrFalse'];
	if($correctanswer==$_POST["answer"]){
		$nbAnswrRight++;
		echo "true";
	}else{
		echo "wrong";
		$nbAnswrFalse++;
	}
	$sql = "UPDATE stdscore SET nbAnswrRight='$nbAnswrRight',nbAnswrFalse='$nbAnswrFalse' WHERE StdId ='$stdid' and Domain ='$domain'";
	if(mysqli_query($link, $sql)){
		echo "updated successfuly";
	}else{echo "ERROR: Could not able to execute $sql. " . mysqli_error($link);}
}


/*
if($nbAnswrFalse== "") $nbAnswrFalse=0;
if($nbAnswrRight== "") $nbAnswrRight=0;*/
echo " it's $nbAnswrFalse";
/*
$sql = "INSERT INTO stdscore(StdId,Domain,nbAnswrRight,nbAnswrFalse) VALUES ('$stdid','$domain','$nbAnswrRight','$nbAnswrFalse')";
	if(mysqli_query($link, $sql)){
		echo "instert successfuly";
	}*/





	?>