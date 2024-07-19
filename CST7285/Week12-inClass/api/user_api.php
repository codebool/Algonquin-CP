<?php 
include('../config.php');

header('Content-Type: application/json');

$response = array();

if($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['action'])) {
    $action = $_POST['action'];
    if ($action == 'register' && isset($_POST['username']) && isset($_POST['password']) && isset($_POST['email'])) {
        $username = $conn->real_escape_string($_POST['username']);
        $password = password_hash($conn->real_escape_string($_POST['password']), PASSWORD_BCRYPT);
        $email = $conn->real_escape_string($_POST['email']);
        
        $sql = "INSERT INTO users(username, password, email) VALUES('$username', '$password', '$email')";

        if($conn->query($sql) === TRUE){
            $response['status'] = 'success';
            $response['redirect'] = 'login.php';
        } else {
            $response['status'] = 'error';
            $response['message'] = 'Error registering user: ' . $conn->error;
        }
    } else if ($action == 'login' && isset($_POST['username']) && isset($_POST['password'])) {
        $username = $conn->real_escape_string($_POST['username']);
        $password = $_POST['password'];
        
        $sql = "SELECT * FROM users WHERE username='$username'";
        
        $result = $conn->query($sql);
        
        if($result->num_rows == 1){
            $user = $result->fetch_assoc();
            if (password_verify($password, $user['password'])) {
                $_SESSION['user_id'] = $user['id'];
                $response['status'] = 'success';
                $response['redirect'] = 'profile.php';
            } else {
                $response['status'] = 'error';
                $response['message'] = 'Invalid username or password';
            }
        } else {
            $response['status'] = 'error';
            $response['message'] = 'User not found';
        }
    } else if ($action == 'edit_profile' && isset($_POST['email'])) {
        if (!isset($_SESSION['user_id'])) {
            $response['status'] = 'error';
            $response['message'] = 'You must be logged in to edit your profile';
        } else {
            $email = $conn->real_escape_string($_POST['email']);
            $user_id = $_SESSION['user_id'];
            
            $sql = "UPDATE users SET email='$email' WHERE id=$user_id";
            
            if($conn->query($sql) === TRUE){
                $response['status'] = 'success';
                $response['message'] = 'Profile updated successfully';
            } else {
                $response['status'] = 'error';
                $response['message'] = 'Error updating profile: ' . $conn->error;
            }
        }
    } else if ($action == 'delete_profile') {
        if (!isset($_SESSION['user_id'])) {
            $response['status'] = 'error';
            $response['message'] = 'You must be logged in to delete your profile';
        } else {
            $user_id = $_SESSION['user_id'];
            
            $sql = "DELETE FROM users WHERE id=$user_id";
            
            if($conn->query($sql) === TRUE){
                session_destroy();
                $response['status'] = 'success';
                $response['redirect'] = 'register.php';
            } else {
                $response['status'] = 'error';
                $response['message'] = 'Error deleting profile: ' . $conn->error;
            }
        }
    } else {
        $response['status'] = 'error';
        $response['message'] = 'Invalid action';
    }
}

echo json_encode($response);
$conn->close();

?>