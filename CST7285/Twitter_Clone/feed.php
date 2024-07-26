<!-- feed.php -->
<?php include 'header.php'; ?>

<div id="feed" class="container">
    <form id="tweet-form" action="welcome.php" method="post">
        <input type="text" name="tweet" placeholder="What's happening?" required>
        <button type="submit">Tweet</button>
    </form>
    <div id="feed-content">
        <!-- Tweets will be loaded here via AJAX -->
    </div>
</div>

<?php include 'footer.php'; ?>