<?php
require 'config.php';

if (!function_exists('getUserByEmail')) {
    function getUserByEmail($email) {
        global $conn;
        $stmt = $conn->prepare("SELECT * FROM users WHERE email = ?");
        $stmt->bind_param('s', $email);
        $stmt->execute();
        return $stmt->get_result()->fetch_assoc();
    }
}

if (!function_exists('registerUser')) {
    function registerUser($name, $email, $password) {
        global $conn;
        $hashedPassword = password_hash($password, PASSWORD_DEFAULT);
        error_log("Registering user: $email with hashed password: $hashedPassword");
        $stmt = $conn->prepare("INSERT INTO users (name, email, password) VALUES (?, ?, ?)");
        $stmt->bind_param('sss', $name, $email, $hashedPassword);
        return $stmt->execute();
    }
}

if (!function_exists('authenticateUser')) {
    function authenticateUser($email, $password) {
        global $conn;
        $stmt = $conn->prepare("SELECT * FROM users WHERE email = ?");
        $stmt->bind_param('s', $email);
        $stmt->execute();
        $user = $stmt->get_result()->fetch_assoc();

        if ($user) {
            error_log("User found: " . print_r($user, true));
            error_log("Password provided: '" . bin2hex($password) . "'");
            error_log("Hashed password: '" . bin2hex($user['password']) . "'");

            if (password_verify($password, $user['password'])) {
                error_log("Password verified successfully");
                return $user;
            } else {
                error_log("Password verification failed");
            }
        } else {
            error_log("User not found");
        }
        return false;
    }
}

if (!function_exists('updateProfilePicture')) {
    function updateProfilePicture($userId, $profilePicture) {
        global $conn;
        $stmt = $conn->prepare("UPDATE users SET profile_picture = ? WHERE id = ?");
        $stmt->bind_param('si', $profilePicture, $userId);
        return $stmt->execute();
    }
}
?>
