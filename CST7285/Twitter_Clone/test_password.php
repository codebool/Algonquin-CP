<?php
$original_password = 'password';
$hashed_password = password_hash($original_password, PASSWORD_DEFAULT);
echo "Original password: $original_password\n";
echo "Hashed password: $hashed_password\n";

if (password_verify($original_password, $hashed_password)) {
    echo "Password verified successfully\n";
} else {
    echo "Password verification failed\n";
}
?>
