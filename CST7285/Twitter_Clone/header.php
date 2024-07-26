<?php
if (session_status() == PHP_SESSION_NONE) {
    session_start();
}

require 'functions.php';

if (isset($_SESSION['user'])) {
    $user_email = $_SESSION['user'];
    $user = getUserByEmail($user_email);
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Twitter Clone</title>
    <link rel="stylesheet" href="./css/styles.css">
</head>
<body>
    <nav>
        <a href="./index.php">Home</a>
        <?php if (isset($_SESSION['user'])): ?>
            <a href="profile.php">Profile</a>
            <a href="feed.php">Feed</a>
            <a href="logout.php">Logout</a>
        <?php else: ?>
            <a href="login.php">Login</a>
            <a href="register.php">Register</a>
        <?php endif; ?>
    </nav>
    <div class="container">