document.addEventListener('DOMContentLoaded', () => {
    const registerForm = document.getElementById('registerForm');
    const loginForm = document.getElementById('loginForm');
    const editProfileForm = document.getElementById('editProfileForm');
    const deleteProfileForm = document.getElementById('deleteProfileForm');
    const responseDiv = document.getElementById('response');
    const themeToggleButton = document.getElementById('themeToggleButton');
    const prefersDarkScheme = window.matchMedia('(prefers-color-scheme: dark)');

    if (registerForm) {
        registerForm.addEventListener('submit', event => {
            event.preventDefault();
            handleFormSubmit(registerForm, 'register');
        });
    }

    if (loginForm) {
        loginForm.addEventListener('submit', event => {
            event.preventDefault();
            handleFormSubmit(loginForm, 'login');
        });
    }

    if (editProfileForm) {
        editProfileForm.addEventListener('submit', event => {
            event.preventDefault();
            handleFormSubmit(editProfileForm, 'edit_profile');
        });
    }

    if (deleteProfileForm) {
        deleteProfileForm.addEventListener('submit', event => {
            event.preventDefault();
            handleFormSubmit(deleteProfileForm, 'delete_profile');
        });
    }

    function handleFormSubmit(form, action) {
        const formData = new FormData(form);
        formData.append('action', action);
        sendRequest(formData);
    }

    function sendRequest(formData) {
        fetch('./api/user_api.php', {
            method: 'POST',
            body: formData
        })
        .then(response => response.json())
        .then(data => {
            if (data.status === 'success') {
                if (data.redirect) {
                    window.location.href = data.redirect;
                } else {
                    responseDiv.textContent = 'Success!';
                }
            } else {
                responseDiv.textContent = data.message;
            }
        })
        .catch(error => {
            responseDiv.textContent = 'An error occurred';
            console.error('Error:', error);
        });
    }

    // Theme toggle functionality
    themeToggleButton.addEventListener('click', () => {
        let theme = localStorage.getItem('theme');
        if (theme === 'dark' || (theme === null && prefersDarkScheme.matches)) {
            applyTheme('light');
        } else {
            applyTheme('dark');
        }
    });

    function applyTheme(theme) {
        if (theme === 'dark') {
            document.body.classList.add('dark-theme');
            document.body.classList.remove('light-theme');
        } else {
            document.body.classList.add('light-theme');
            document.body.classList.remove('dark-theme');
        }
        localStorage.setItem('theme', theme);
    }

    const currentTheme = localStorage.getItem('theme');
    if (currentTheme === 'dark' || (currentTheme === null && prefersDarkScheme.matches)) {
        applyTheme('dark');
    } else {
        applyTheme('light');
    }
});
