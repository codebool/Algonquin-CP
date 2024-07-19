<?php
include('config.php');
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link rel="stylesheet" href="styles/style.css">
    <script src="scripts/script.js" defer></script>
</head>
<body>
    <?php include('header.php'); ?>
    <main>
        <h1>Welcome to Our User Profile Application</h1>
        <p>This is a basic application demonstrating PHP, MySQL, and CRUD operations.</p>
        <?php if (isset($_SESSION['user_id'])): ?>
            <p>You are logged in. Visit your <a href="profile.php">profile</a>.</p>
        <?php else: ?>
            <p>Please <a href="login.php">login</a> or <a href="register.php">register</a>.</p>
        <?php endif; ?>
    </main>
</body>
</html>
