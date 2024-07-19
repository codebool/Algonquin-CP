<?php 
$host = "localhost";
$port = "3306";
$user = "root";
$pass = '';
$db = "user_profile";

$conn = new mysqli($host, $user, $pass, '', $port);

if($conn->connect_error){
    die("Connection failed: " . $conn->connect_error);
}

$sql = "CREATE DATABASE IF NOT EXISTS $db";
if($conn->query($sql) !== TRUE){
    die("Error creating database: " . $conn->error);    
}

$conn->select_db($db);

$sql = "CREATE TABLE IF NOT EXISTS users(
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)";

if($conn->query($sql) !== TRUE){
    die("Error creating database: " . $conn->error);    
}

if (session_status() == PHP_SESSION_NONE) {
    session_start();
}
?>