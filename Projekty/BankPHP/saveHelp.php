<?php


$dbuser = 'm29333_projekt';
$dbpass = 'Projekt123';
$db = new PDO("mysql:host=mysql.ct8.pl;dbname=m29333_projekt", $dbuser,$dbpass) or die ("Unsuccessfulconnection");

$cookie_name = "vote";
$cookie_value = "done";
if(isset($_POST['submit'])){
    setcookie($cookie_name, $cookie_value, time() + 3600, "/");
    $mail=$_POST['email'];
    $opinion=$_POST['clientHelp'];
    $sql="insert into client_help(id, email, help) values (null,'$mail', '$opinion')";
    $db->query($sql);
}?>
<?php
$cookie_name = "vote";
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Survey Answers</title>
</head>
<body>
<script>
    function goBack() {
        window.location.href = 'index.html';
    }
</script>
<h2>Thank you for your opinion</h2>
<button onclick="goBack()">Go back</button>
</body>
</html>