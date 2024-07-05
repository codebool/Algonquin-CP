document.addEventListener("DOMContentLoaded", function () {
    // Add event listener to the form submit button
    document.getElementById("newsletter").addEventListener("change", function () {
        if (this.checked) {
            alert("By subscribing, you may receive emails that could be considered spam. Please ensure you want to proceed.");
        }
    });

    // Add event listener to the form reset button
    document.getElementById("btn-reset").addEventListener("click", function (event) {
        // Clear any error messages
        document.getElementById('emailError').innerHTML = '';
        document.getElementById('loginError').innerHTML = '';
        document.getElementById('passError').innerHTML = '';
        document.getElementById('pass2Error').innerHTML = '';
        document.getElementById('termsError').innerHTML = '';
    });
});

function validate() {
    // Get the values from the form and trim them
    let login = document.getElementById("login").value.trim();
    const email = document.getElementById("email").value.trim();
    const pass = document.getElementById("pass").value.trim();
    const pass2 = document.getElementById("pass2").value.trim();
    const bookNewsletter = document.getElementById("newsletter").checked;
    const agreeWithTerms = document.getElementById("terms").checked;

    const isEmailPassValidation = validateEmail(email);
    const isLoginPassValidation = validateLogin(login);
    if (isEmailPassValidation) {
        document.getElementById("login").value = login.toLowerCase();
    }
    const isPasswordPassValidation = validatePass(pass, pass2);
    const isAgreeWithTerms = checkTerms(agreeWithTerms);

    return isEmailPassValidation && isLoginPassValidation && isPasswordPassValidation && isAgreeWithTerms;
}

function validateEmail(email) {
    let emailError = document.getElementById("emailError");
    let emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;

    if (email === "") {
        emailError.innerHTML = "(Email is required)";
        emailError.style.color = "red";
        return false;
    } else if (!emailPattern.test(email)) {
        emailError.innerHTML = "(Invalid email format. Example:xyz@xyz.xyz)";
        emailError.style.color = "red";
        return false;
    } else {
        emailError.innerHTML = "";
    }
    return true;
}

function validateLogin(login) {
    let loginError = document.getElementById("loginError");
    let loginPattern = /^[a-zA-Z0-9._-]{1,20}$/;

    if (login === "") {
        loginError.innerHTML = "(Login is required)";
        loginError.style.color = "red";
        return false;
    } else if (!loginPattern.test(login)) {
        loginError.innerHTML = "(Login must be no more than 20 characters long)";
        loginError.style.color = "red";
        return false;
    } else {
        loginError.innerHTML = "";
    }
    return true;
}

function validatePass(pass, pass2) {
    let passError = document.getElementById("passError");
    let pass2Error = document.getElementById("pass2Error");
    let passPattern = /^(?=.*[a-z])(?=.*[A-Z]).{6,}$/;

    if (pass === "") {
        passError.innerHTML = "(Password is required)";
        passError.style.color = "red";
        return false;
    } else if (!passPattern.test(pass)) {
        passError.innerHTML = "(Password must contain at least one uppercase and lowercase letter, and at least 6 or more characters)";
        passError.style.color = "red";
        return false;
    } else if (pass !== pass2) {
        pass2Error.innerHTML = "(Passwords do not match)";
        pass2Error.style.color = "red";
        return false;
    } else {
        passError.innerHTML = "";
        pass2Error.innerHTML = "";
    }

    return true;
}

function checkTerms(agreeWithTerms) {
    let termsError = document.getElementById("termsError");
    if (!agreeWithTerms) {
        termsError.innerHTML = "(You must agree to the terms)";
        termsError.style.color = "red";
        return false;
    } else {
        termsError.innerHTML = "";
    }
    return true;
}