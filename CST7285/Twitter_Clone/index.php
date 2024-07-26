<?php
require 'functions.php';
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link rel="stylesheet" href="css/styles.css">
    <script src="js/main.js"></script>
</head>
<body>
    <?php include 'header.php'; ?>
    <div class="container">
        <h1>Trending Posts</h1>
        <div id="feed">
            <!-- Trending posts will be loaded here via AJAX -->
        </div>
    </div>
    <?php include 'footer.php'; ?>
</body>
</html>