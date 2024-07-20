<?php 
    session_start();
    unset($_SESSION['cart']);
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Purchase Complete</title>
    <script src="./script.js"></script>
    <link rel="stylesheet" href="./style.css">
</head>
<body>
    <h1>Thanks for the purchase mate!</h1>
    <form action="index.php" method="GET">
        <button type="submit">Return to Order Page</button>
    </form>
</body>
</html>