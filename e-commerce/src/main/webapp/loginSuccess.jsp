<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login Success | My E-Commerce</title>
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
    <div class="ms-auto d-flex align-items-center">
        <a href="home" class="btn btn-outline-light me-2">Home</a>
        <span class="text-white me-3">Welcome, <strong>${name}</strong></span>
        <a href="logout" class="btn btn-danger">Logout</a>
    </div>
</nav>

<!-- Success Message -->
<div class="container mt-5 text-center">
    <h2 class="mb-3">🎉 Login Successful!</h2>
    <p>Welcome back, <strong>${name}</strong>. You are now logged in.</p>
</div>

<!-- Footer -->
<footer>
    <p>&copy; 2025 My E-Commerce. All Rights Reserved.</p>
</footer>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
