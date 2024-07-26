document.addEventListener("DOMContentLoaded", function () {
  function fetchTweets() {
      var feedElement = document.getElementById("feed");
      if (feedElement) {
          var xhttp = new XMLHttpRequest();
          xhttp.onreadystatechange = function () {
              if (this.readyState == 4 && this.status == 200) {
                  feedElement.innerHTML = this.responseText;
              }
          };
          xhttp.open("GET", "fetch_tweets.php", true);
          xhttp.send();
      }
  }

  fetchTweets();
  setInterval(fetchTweets, 5000); // Fetch new tweets every 5 seconds

  if (window.matchMedia && window.matchMedia("(prefers-color-scheme: dark)").matches) {
      document.body.classList.add("dark-mode");
  } else {
      document.body.classList.add("light-mode");
  }

  // Handle profile picture upload
  const uploadForm = document.getElementById("upload-form");
  const profilePictureInput = document.getElementById("profile_picture");
  const errorMessage = document.getElementById("error-message");
  const profilePicture = document.getElementById("profile-picture");

  if (uploadForm && profilePictureInput && errorMessage) {
      uploadForm.addEventListener("submit", function (event) {
          event.preventDefault();

          const formData = new FormData();
          formData.append("profile_picture", profilePictureInput.files[0]);

          fetch("profile.php", {
              method: "POST",
              body: formData
          })
          .then(response => response.text())
          .then(data => {
              if (data.includes("error")) {
                  errorMessage.textContent = data;
              } else {
                  // Reload the profile page to show the new profile picture
                  window.location.reload();
              }
          })
          .catch(error => {
              errorMessage.textContent = "An error occurred while uploading the profile picture.";
          });
      });

      profilePictureInput.addEventListener("change", function () {
          const file = profilePictureInput.files[0];
          if (file) {
              const reader = new FileReader();
              reader.onload = function (e) {
                  if (profilePicture) {
                      profilePicture.src = e.target.result;
                  } else {
                      const img = document.createElement("img");
                      img.id = "profile-picture";
                      img.src = e.target.result;
                      img.style.width = "150px";
                      img.style.height = "150px";
                      uploadForm.insertBefore(img, uploadForm.firstChild);
                  }
              };
              reader.readAsDataURL(file);
          }
      });
  }
});
