<?php
if (session_status() == PHP_SESSION_NONE) {
    session_start();
}

$uploadDir = 'uploads/';
if (!is_dir($uploadDir)) {
    mkdir($uploadDir, 0755, true);
}

$host = 'localhost';
$db = 'twitter_clone';
$user = 'root';
$password = '';
$port = '33066';

$conn = new mysqli($host, $user, $password, $db, $port);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}
?>
