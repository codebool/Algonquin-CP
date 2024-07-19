<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="styles/style.css">
    <script src="scripts/script.js" defer></script>
</head>
<body>
    <?php include('header.php'); ?>
    <div class="container">
        <form id="loginForm">
            <h1>Login</h1>
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required><br>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required><br>
            <button type="submit">Login</button>
        </form>
        <div id="response"></div>
    </div>
</body>
</html>