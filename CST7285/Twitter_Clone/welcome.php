<?php
require 'functions.php';
if (session_status() == PHP_SESSION_NONE) {
    session_start();
}
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $content = htmlspecialchars($_POST['tweet']);
    $user_email = $_SESSION['user'];
    $query = "INSERT INTO tweets (user_email, content, created_at) VALUES ('$user_email', '$content', NOW())";
    $conn->query($query);
    header('Location: feed.php');
    exit();
}
?>