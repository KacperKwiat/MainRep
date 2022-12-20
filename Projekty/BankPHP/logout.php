<?php
session_start();
unset($_SESSION['user']);
unset($_SESSION['accountNumber']);
session_destroy();
header("Location: index.html");