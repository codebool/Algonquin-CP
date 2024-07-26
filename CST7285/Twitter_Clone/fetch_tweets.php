<?php
require 'functions.php';
$query = "SELECT * FROM tweets ORDER BY created_at DESC";
$result = $conn->query($query);

while ($row = $result->fetch_assoc()) {
    echo "<div class='tweet'>";
    echo "<h3>" . htmlspecialchars($row['user_email']) . "</h3>";
    echo "<p>" . htmlspecialchars($row['content']) . "</p>";
    echo "<small>" . htmlspecialchars($row['created_at']) . "</small>";
    echo "</div>";
}
?>