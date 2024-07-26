<?php
require 'functions.php';
if (session_status() == PHP_SESSION_NONE) {
    session_start();
}
if (isset($_SESSION['user'])) {
    header('Location: profile.php');
    exit();
}

?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel="stylesheet" href="./css/styles.css">
</head>
<body>
    <?php include 'header.php'; ?>
    <form action="register.php" method="post">
        Name: <input type="text" name="name" required><br>
        Email: <input type="email" name="email" required><br>
        Password: <input type="password" name="password" required><br>
        <button type="submit">Register</button>
        <p style="color:green;">
        <?php  
        if ($_SERVER["REQUEST_METHOD"] == "POST") {
            $name = $_POST['name'];
            $email = $_POST['email'];
            $password = $_POST['password'];
            if (registerUser($name, $email, $password)) {
                echo "Registration successful!";
                header('Location: login.php');
                exit();
            } else {
                echo "Registration failed.";
            }
        }        
        ?></p>
    </form>
    <?php include 'footer.php'; ?>
</body>
</html>
