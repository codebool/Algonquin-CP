<?php
require 'config.php';
require 'functions.php';

if (!isset($_SESSION['user_id'])) {
    header('Location: login.php');
    exit();
}

$userId = $_SESSION['user_id'];
$user = getUserById($userId);

if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_FILES['profile_picture'])) {
    if (isset($_FILES['profile_picture']) && $_FILES['profile_picture']['error'] === UPLOAD_ERR_OK) {
        $fileTmpPath = $_FILES['profile_picture']['tmp_name'];
        $fileName = $_FILES['profile_picture']['name'];
        $fileSize = $_FILES['profile_picture']['size'];
        $fileType = $_FILES['profile_picture']['type'];
        $fileNameCmps = explode(".", $fileName);
        $fileExtension = strtolower(end($fileNameCmps));

        $newFileName = md5(time() . $fileName) . '.' . $fileExtension;
        $dest_path = $uploadDir . $newFileName;

        if (move_uploaded_file($fileTmpPath, $dest_path)) {
            updateProfilePicture($userId, $dest_path);
            header('Location: profile.php');
            exit();
        } else {
            $error_message = 'There was an error moving the uploaded file.';
        }
    }
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile</title>
    <link rel="stylesheet" href="style.css">
    <script src="main.js" defer></script>
</head>
<body>
    <header>
        <h1>Profile</h1>
    </header>
    <main>
        <h2>Welcome, <?php echo htmlspecialchars($user['name']); ?></h2>
        <?php if ($user['profile_picture']): ?>
            <img id="profile-picture" src="<?php echo htmlspecialchars($user['profile_picture']); ?>" alt="Profile Picture" style="width:150px;height:150px;">
        <?php endif; ?>
        <form id="upload-form" action="profile.php" method="post" enctype="multipart/form-data">
            <label for="profile_picture">Upload Profile Picture:</label>
            <input type="file" name="profile_picture" id="profile_picture" accept="image/*" required>
            <button type="submit">Upload</button>
        </form>
        <div id="error-message" style="color:red;"></div>
    </main>
</body>
</html>
