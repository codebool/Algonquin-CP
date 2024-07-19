<?php
include('config.php');

if (!isset($_SESSION['user_id'])) {
    header('Location: login.php');
    exit;
}

$user_id = $_SESSION['user_id'];

$sql = "SELECT * FROM users WHERE id='$user_id'";
$result = $conn->query($sql);

if ($result->num_rows == 1) {
    $user = $result->fetch_assoc();
} else {
    echo "User not found.";
    exit;
}

$conn->close();
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Profile</title>
    <link rel="stylesheet" href="styles/style.css">
    <script src="scripts/script.js" defer></script>
</head>
<body>
    <?php include('header.php'); ?>
    <div class="container">
        <h1>Welcome, <?php echo htmlspecialchars($user['username']); ?></h1>
        <p>Email: <?php echo htmlspecialchars($user['email']); ?></p>
        <a href="edit_profile.php">Edit Profile</a>
        <a href="delete_profile.php">Delete Profile</a>
        <a href="logout.php">Logout</a>
    </div>
</body>
</html>
