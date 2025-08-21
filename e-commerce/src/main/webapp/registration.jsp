<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register | My E-Commerce</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            display: flex;
            flex-direction: column;
            min-height: 100vh;
        }
        footer {
            margin-top: auto;
            background: #343a40;
            color: #fff;
            text-align: center;
            padding: 15px 0;
        }
        .navbar-brand img {
            height: 40px;
        }
        .error-message {
            color: red;
            font-size: 0.9rem;
            display: none;
        }
    </style>
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark px-3">
    <a class="navbar-brand d-flex align-items-center" href="#">
        <img src="https://getbootstrap.com/docs/5.3/assets/brand/bootstrap-logo-shadow.png" alt="Logo">
        <span class="ms-2">My E-Commerce</span>
    </a>
    <div class="ms-auto">
        <a href="register" class="btn btn-outline-light me-2">Register</a>
        <a href="login" class="btn btn-light">Login</a>
    </div>
</nav>

<!-- Messages -->
<div class="container mt-4">
    <c:if test="${not empty error}">
        <div class="alert alert-danger text-center">${error}</div>
    </c:if>
    <c:if test="${not empty message}">
        <div class="alert alert-success text-center">${message}</div>
    </c:if>
</div>

<!-- Registration Form -->
<div class="container mt-3">
    <h2 class="text-center mb-4">User Registration</h2>
    <form action="register" method="post" onsubmit="return validateForm()" class="mx-auto" style="max-width: 600px;">

        <!-- Name -->
        <div class="mb-3">
            <label class="form-label">Name</label>
            <input type="text" name="name" id="name" class="form-control" required minlength="3">
            <div class="invalid-feedback">Name must be at least 3 characters.</div>
        </div>

        <!-- Email -->
        <div class="mb-3">
            <label class="form-label">Email</label>
            <input type="email" name="email" id="email" onblur="checkEmail()" class="form-control" required>
            <div class="invalid-feedback">Please enter a valid email.</div>
            <span id="emailError" style="color: red;"></span>
        </div>

        <!-- Phone Number -->
        <div class="mb-3">
            <label class="form-label">Phone Number</label>
            <input type="text" name="phoneNumber" id="phoneNumber" onblur="checkPhoneNumber()" class="form-control" required pattern="^[0-9]{10}$">
            <div class="invalid-feedback">Phone number must be 10 digits.</div>
            <span id="phoneError" style="color: red;"></span>
        </div>

        <!-- DOB -->
        <div class="mb-3">
            <label class="form-label">Date of Birth</label>
            <input type="date" name="dob" id="dob" class="form-control" required>
        </div>

        <!-- Gender -->
        <div class="mb-3">
            <label class="form-label">Gender</label>
            <select name="gender" id="gender" class="form-select" required>
                <option value="">-- Select --</option>
                <option>Male</option>
                <option>Female</option>
                <option>Other</option>
            </select>
        </div>

        <!-- State -->
        <div class="mb-3">
            <label class="form-label">State</label>
            <input type="text" name="state" id="state" class="form-control" required>
        </div>

        <!-- Address -->
        <div class="mb-3">
            <label class="form-label">Address</label>
            <textarea name="address" id="address" class="form-control" rows="3" required minlength="10"></textarea>
            <div class="invalid-feedback">Address must be at least 10 characters.</div>
        </div>

        <!-- Password -->
        <div class="mb-3">
            <label class="form-label">Password</label>
            <input type="password" name="password" id="password" class="form-control" required minlength="6">
        </div>

        <!-- Confirm Password -->
        <div class="mb-3">
            <label class="form-label">Confirm Password</label>
            <input type="password" name="confirmPassword" id="confirmPassword" class="form-control" required minlength="6">
            <div class="error-message" id="passwordError">Passwords do not match.</div>
        </div>

        <!-- Submit -->
        <div class="d-grid">
            <button type="submit" class="btn btn-primary">Register</button>
        </div>
    </form>
</div>
<br>

<!-- Footer -->
<footer>
    <p>&copy; 2025 My E-Commerce. All Rights Reserved.</p>
</footer>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<!-- Custom Validation JS -->
<script>
    let isPhoneValid = true; // global flag
    let isEmailValid = true; // can also add email check if needed

    function validateForm() {
        let valid = true;

        // Name validation
        const name = document.getElementById("name");
        if (name.value.trim().length < 3) {
            name.classList.add("is-invalid");
            valid = false;
        } else {
            name.classList.remove("is-invalid");
        }

        // Email validation
        const email = document.getElementById("email");
        if (email.value.trim() === "") {
            email.classList.add("is-invalid");
            valid = false;
        } else {
            email.classList.remove("is-invalid");
        }

        // Phone validation
        const phone = document.getElementById("phoneNumber");
        const phoneRegex = /^[0-9]{10}$/;
        if (!phoneRegex.test(phone.value.trim())) {
            phone.classList.add("is-invalid");
            valid = false;
        } else {
            phone.classList.remove("is-invalid");
        }

        // Prevent submit if phone already exists
        if (!isPhoneValid) {
            valid = false;
        }

        // Address validation
        const address = document.getElementById("address");
        if (address.value.trim().length < 10) {
            address.classList.add("is-invalid");
            valid = false;
        } else {
            address.classList.remove("is-invalid");
        }

        // Password match validation
        const password = document.getElementById("password");
        const confirmPassword = document.getElementById("confirmPassword");
        const errorMsg = document.getElementById("passwordError");

        if (password.value !== confirmPassword.value) {
            confirmPassword.classList.add("is-invalid");
            errorMsg.style.display = "block";
            valid = false;
        } else {
            confirmPassword.classList.remove("is-invalid");
            errorMsg.style.display = "none";
        }

        return valid;
    }

    // AJAX check email
    function checkEmail() {
        const email = document.getElementById('email').value;
        if (email !== "") {
            var xhttp = new XMLHttpRequest();
            xhttp.open("GET", "http://localhost:8080/e-commerce/checkEmail?email=" + email);
            xhttp.send();

            xhttp.onload = function () {
                document.getElementById("emailError").innerHTML = this.responseText;

                  if (this.responseText.includes("Email already exists!")) {
                                    isEmailValid = false; // block form submit
                                } else {
                                    isEmailValid = true;
                                }
            }
        }
    }

    // AJAX check phone number
    function checkPhoneNumber() {
        const phone = document.getElementById('phoneNumber').value;
        if (phone !== "") {
            var xhttp = new XMLHttpRequest();
            xhttp.open("GET", "http://localhost:8080/e-commerce/checkPhoneNumber?phoneNumber=" + phone);
            xhttp.send();

            xhttp.onload = function () {
                document.getElementById("phoneError").innerHTML = this.responseText;

                if (this.responseText.includes("Phone number already exists!")) {
                    isPhoneValid = false; // block form submit
                } else {
                    isPhoneValid = true;
                }
            }
        }
    }
</script>

</body>
</html>
