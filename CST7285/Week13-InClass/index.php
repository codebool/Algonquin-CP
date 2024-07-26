<?php

// header('Content-Type: application/json');
$response = array();

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

$sql = "SELECT * FROM users WHERE username = 'test'";

$result = $conn->query($sql);

if($result->num_rows > 0){
    while($row = $result->fetch_assoc()){
        $response['username'] = $row['username'];
    }
}

// echo json_encode($response);
// $conn->close();
?>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile Page</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<div class="container">
    <header>
        <h1>My X</h1>
    </header>
    <nav>
        <ul>
            <li><a href="index.php">Profile</a></li>
            <li><a href="#">Hobbies</a></li>
            <li><a href="#">Courses</a></li>
            <li><a><span>Login as:</span> <?php echo htmlspecialchars($response['username']); ?></a></li>
        </ul>
    </nav>
    <aside>
        <div class="profile">
            <img src="head.jpg" alt="Profile Picture">
            <p>Bo Qu<br>@algonquinlive.com<br>Measuring out life with coffee spoons.<br>Pembroke<br>bq.com</p>
        </div>
    </aside>
    <section class="stats">
        <div class="stat"><span>TWEETS</span><br>3,433</div>
        <div class="stat"><span>PHOTOS/VIDEOS</span><br>124</div>
        <div class="stat"><span>FOLLOWING</span><br>555</div>
        <div class="stat"><span>FAVORITES</span><br>11 <span class="star">⭐</span></div>
        <div class="stat"><span>VIEW</span><br>222</div>
    </section>
    <main>
        <p class="music-note">🎵 Enjoy your day, enjoy our Classic Music @ FM 123.45 9:00 a.m. to 11:00 a.m. EVERYDAY!</p>
        <div class="images">
            <img src="violin.jpg" alt="Violin" title='violin'>
            <img src="orchestra.jpg" alt="Orchestra" title='orchestra'>
        </div>
    </main>
</div>
</body>
</html>

