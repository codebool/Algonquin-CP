<?php
session_start(); // Start the session
unset($_SESSION['cart']); // Unset the cart session
unset($_SESSION['allTotal']); // Unset the allTotal session
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Purchase Complete</title>
    <link rel="stylesheet" href="./ACMEpurchase.css">
</head>
<body>
<h2 id="purchaseMessage">Thanks for the purchase mate!</h2>
<form action="index.php" method="GET">
    <button type="submit" id="back">Return to Order Page</button>
</form>
</body>
</html>
