<?php
session_start();
if(isset($_POST['submit'])){
    $log=$_SESSION['user'];
    $dbuser = 'm29333_projekt';
    $dbpass = 'Projekt123';
    $db = new PDO("mysql:host=mysql.ct8.pl;dbname=m29333_projekt", $dbuser,$dbpass) or die ("Unsuccessfulconnection");


    $newLine="\n";
    $log=$newLine.$log;
    $log .=": \n";
    $data=$_POST['clientSurvey'];
    $seperator="\n----------------------------------------------";
    $fp=fopen('data.txt','a');
    fwrite($fp,$log);
    fwrite($fp,$data);
    fwrite($fp,$seperator);
    fclose($fp);
    echo "Data has been saved ";
    header("refresh:3;url=opinion_form.php");



}else{
    echo "Sorry we didnt receive your survey try again";
    header("refresh:3;url=opinion_form.php");
}
