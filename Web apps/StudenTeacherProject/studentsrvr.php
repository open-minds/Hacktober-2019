<?php

session_start();

$domain = $_POST["domain"];
$link = mysqli_connect("localhost", "root","");
// Check connection
if(!$link)die("ERROR: Could not connect. " . mysqli_connect_error());

$db_selected=  mysqli_select_db($link,"miniproject2");

// Attempt get query execution
$sql = "SELECT Qid,qstn from questions where Domain ='$domain'";
$result = mysqli_query($link, $sql);

if($result->num_rows==0){
	exit(json_encode("no result"));
}else{
	$data_array = array();
	while($rows =$result->fetch_assoc()) {
		$data_array[] = $rows; 
	}

	exit(json_encode($data_array)) ;
}
// Close connection
mysqli_close($link);

?>