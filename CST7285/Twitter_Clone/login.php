<?php
require 'config.php';
require 'functions.php';

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $email = $_POST['email'];
    $password = $_POST['password'];
    
    $user = authenticateUser($email, $password);
    
    if ($user) {
        $_SESSION['user_id'] = $user['id'];
        header('Location: profile.php');
        exit();
    } else {
        $error_message = 'Invalid email or password.';
    }
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="./css/styles.css">
</head>
<body>
    <main>
        <?php include 'header.php'; ?>
        <form action="login.php" method="post">
            <label for="email">Email:</label>
            <input type="email" name="email" id="email" required>
            <label for="password">Password:</label>
            <input type="password" name="password" id="password" required>
            <button type="submit">Login</button>
        </form>
        <?php if (isset($error_message)): ?>
            <p style="color:red;"><?php echo htmlspecialchars($error_message); ?></p>
        <?php endif; ?>
    </main>
    <?php include 'footer.php'; ?>
</body>
</html>
