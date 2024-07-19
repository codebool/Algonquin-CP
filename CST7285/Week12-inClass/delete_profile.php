<?php
include('config.php');

if (!isset($_SESSION['user_id'])) {
    header('Location: login.php');
    exit;
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Delete Profile</title>
    <link rel="stylesheet" href="styles/style.css">
    <script src="scripts/script.js" defer></script>
</head>
<body>
    <?php include('header.php'); ?>
    <div class="container">
        <h1>Delete Profile</h1>
        <p>Are you sure you want to delete your profile? This action cannot be undone.</p>
        <form id="deleteProfileForm">
            <button type="submit">Delete Profile</button>
        </form>
        <a href="profile.php">Cancel</a>
        <div id="response"></div>
    </div>
</body>
</html>