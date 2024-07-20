<?php
    session_start();
    // array entries: name, actual cost, price

    $inventory = [
		"item1" => ["price" => 100],
		"item2" => ["price" => 200],
		"item3" => ["price" => 300]
	];

    // Note that when you send this to the front end with PHP 
    // do not include the actual cost value, we will compare  
    // this on the back end only.

    if ($_SERVER['REQUEST_METHOD'] === 'POST') {   
        $item = $_POST['item'];
        $discount = (float)$_POST['discount'];

        $cost = $inventory[$item]['price'] - ($inventory[$item]['price'] * $discount/100);

        if (!isset($_SESSION['cart'])) {
            $_SESSION['cart'] = [];
        }
	
        $_SESSION['cart'][] = [
            'item' => $item,
            'price' => $inventory[$item]['price'],
            'discount' => $discount,
            'cost' => $cost
        ];
    }

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Invoice Application</title>
    <script src="./script.js" defer></script>
    <link rel="stylesheet" href="./style.css">
</head>
<body>
    <form id="orderForm" method="POST" action="index.php">
        <select name="item" id="item">
            <?php
                foreach ($inventory as $key => $value) {
                    echo "<option value=\"$key\">$key</option>";
                }
            ?>
        </select>
		<br>
		<label for="price">Price: </label>
		<input type="text" id="price" name="price" readonly><br>
		<label for="discount">Discount: </label>
		<input type="text" id="discount" name="discount">%<br>
		<label for="total">Total: </label>
		<input type="text" id="total" name="total" readonly>$<br>
		<button type="submit" id="addButton">Add item to order</button>
    </form>

    <?php if (isset($_SESSION['cart'])): ?>
            <h2>Invoice</h2>
            <ul>
                <?php 
                    foreach ($_SESSION['cart'] as $item):
                ?>
                <li><?php echo "{$item['item']} - {$item['price']} - {$item['discount']}% - {$item['cost']}"; ?></li>
                <?php endforeach; ?>
            </ul>
            <form action="purchase.php" method="POST">
                <button type="submit">Purchase</button>
            </form>
        <?php endif; ?>
</body>
</html>

