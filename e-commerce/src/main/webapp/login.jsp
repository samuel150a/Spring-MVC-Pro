<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login | My E-Commerce</title>
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
    </style>
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark px-3">
    <a class="navbar-brand d-flex align-items-center" href="/">
        <img src="https://getbootstrap.com/docs/5.3/assets/brand/bootstrap-logo-shadow.png" alt="Logo">
        <span class="ms-2">My E-Commerce</span>
    </a>
    <div class="ms-auto">
        <a href="register" class="btn btn-outline-light me-2">Register</a>
        <a href="login" class="btn btn-light">Login</a>
    </div>
</nav>

<div class="container mt-4">
    <c:if test="${not empty message}">
        <div class="alert alert-success text-center">${message}</div>
    </c:if>
    <c:if test="${not empty error}">
        <div class="alert alert-danger text-center">${error}</div>
    </c:if>
</div>

<!-- Login Form -->
<div class="container mt-5">
    <h2 class="text-center mb-4">User Login</h2>
    <form action="login" method="post" onsubmit="return validateLogin()"
          class="mx-auto" style="max-width: 400px;">

        <!-- Email -->
        <div class="mb-3">
            <label class="form-label">Email</label>
            <input type="email" name="email" id="email" class="form-control" required>
            <div class="invalid-feedback">Please enter a valid email.</div>
        </div>

        <!-- Password -->
        <div class="mb-3">
            <label class="form-label">Password</label>
            <input type="password" name="password" id="password" class="form-control" required minlength="6">
            <div class="invalid-feedback">Password must be at least 6 characters.</div>
        </div>

        <!-- Submit -->
        <div class="d-grid">
            <button type="submit" class="btn btn-primary">Login</button>
        </div>
    </form>
</div>

<!-- Footer -->
<footer>
    <p>&copy; 2025 My E-Commerce. All Rights Reserved.</p>
</footer>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<!-- Custom Validation JS -->
<script>
    function validateLogin() {
        let valid = true;

        // Email validation
        const email = document.getElementById("email");
        if (email.value.trim() === "") {
            email.classList.add("is-invalid");
            valid = false;
        } else {
            email.classList.remove("is-invalid");
        }

        // Password validation
        const password = document.getElementById("password");
        if (password.value.trim().length < 6) {
            password.classList.add("is-invalid");
            valid = false;
        } else {
            password.classList.remove("is-invalid");
        }

        return valid;
    }
</script>

</body>
</html>
