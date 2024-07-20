<?php
session_start();

$inventory = array(
    array("mandolin", 225, 460),
    array("classical guitar", 568, 1200),
    array("acoustic guitar", 365, 750),
    array("kazoo", 3.25, 6.8),
    array("djembe", 123, 250),
    array("sitar", 378, 810),
    array("bamboo flute", 15, 48)
);

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    if (!isset($_SESSION['cart'])) {
        $_SESSION['cart'] = array();
    }

    if (isset($_POST['item'])) {
        $item = $_POST['item'];
        $retail = (float)$_POST['retail'];
        // TODO: Verify discount
        $discount = (float)$_POST['discount'];
        $total = $retail - ($discount * $retail / 100);

        // add items into session cart
        $_SESSION['cart'][] = [
            'item' => htmlspecialchars($item),
            'retail' => $retail,
            'discount' => $discount,
            'total' => $total
        ];
    }
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="Bo Qu">
    <script src="./script.js" defer></script>
    <script>
        const inventory = <?php echo json_encode($inventory); ?>;
    </script>
    <link rel="stylesheet" href="ACMEpurchase.css">
    <title>ACME Application</title>
</head>
<body>
<header>
    <h1>ACME Corporation</h1>
    <div class="tagline">yes we deliver!</div>
</header>

<main>
    <h2>Customer Invoice</h2>

    <table class="invoice">
        <tr>
            <th class="invoiceheader">Item</th>
            <th class="invoiceheader">Retail Cost</th>
            <th class="invoiceheader">Discount</th>
            <th class="invoiceheader">Total</th>
        </tr>

        <!-- HERE IS WHERE INVOICE ITEMS ARE LISTED -->
        <?php
        if (isset($_SESSION['cart']) && count($_SESSION['cart']) > 0) {
            $allTotal = 0;
            foreach ($_SESSION['cart'] as $item) {
                if ($item['item'] != '') {
                    echo "<tr>";
                    echo "<td>{$item['item']}</td>";
                    echo "<td class='centered'>{$item['retail']}</td>";
                    echo "<td class='centered'>{$item['discount']}%</td>";
                    echo "<td class='centered'>{$item['total']}</td>";
                    echo "</tr>";
                    $allTotal += $item['total'];
                }
            }
            $_SESSION['allTotal'] = $allTotal;
        }
        ?>

        <!-- THE FOLLOWING LINE IS ALWAYS PRESENT -->

        <tr class="totalline">
            <td colspan="3">Invoice total</td>
            <td class="centered">$<?php echo isset($_SESSION['allTotal']) ? number_format($_SESSION['allTotal'], 2) : '0.00'; ?></td>
        </tr>
    </table>

    <div id="purchase">
        <form action="ACMEpurchases.php" method="POST">
            <button id="submitOrder" <?php if (!isset($_SESSION['allTotal']) || $_SESSION['allTotal'] == 0) { echo "disabled"; } ?>>Purchase</button>
        </form>
    </div>

    <hr>

    <form action="index.php" method="POST">
        <fieldset class="additem">
            <legend>Add Item to Order</legend>
            <select id="newitem" name="newitem">
                <option value="none">Select an item</option>
                <?php
                foreach ($inventory as $key => $value) {
                    echo "<option value='{$key}'>{$value[0]}</option>";
                }
                ?>
            </select>

            <div class="itemdetails">
                <label for="item">Item:</label>
                <input type="text" name="item" id="item" readonly>
            </div>
            <div class="itemdetails">
                <label for="retail">Price:</label>
                <input type="text" name="retail" id="retail" readonly>
                <label for="discount">Discount (%):</label>
                <input type="text" name="discount" id="discount">
                <label for="total">Total:</label>
                <input type="text" name="total" id="total" readonly>
            </div>

            <div class="purchase">
                <button type="submit" id="addItemButton">Add to Invoice</button>
            </div>

            <p class="centered">
                Attention, all discounts will be verified by our software.
            </p>

        </fieldset>
    </form>

    <footer>ACME Corporation for all that you can scheme up!</footer>

</main>
</body>
</html>
