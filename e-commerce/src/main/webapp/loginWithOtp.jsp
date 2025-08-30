<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login with OTP | My E-Commerce</title>
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

<!-- Messages -->
<div class="container mt-4">
    <c:if test="${not empty message}">
        <div class="alert alert-success text-center">${message}</div>
    </c:if>
    <c:if test="${not empty error}">
        <div class="alert alert-danger text-center">${error}</div>
    </c:if>
</div>

<!-- OTP Form -->
<div class="container mt-5">
    <h2 class="text-center mb-3">OTP Verification</h2>
    <p class="text-center text-muted">An OTP has been sent to your registered email. Please enter it below.</p>

    <form action="verifyOtp" method="post" onsubmit="return validateOtpForm()"
          class="mx-auto" style="max-width: 400px;">

        <!-- OTP -->
        <div class="mb-3">
            <label class="form-label">Enter OTP</label>
            <input type="text" name="otp" id="otp" class="form-control" maxlength="6" required>
            <div class="invalid-feedback">Please enter a valid 6-digit OTP.</div>
        </div>

        <!-- Submit -->
        <div class="d-grid">
            <button type="submit" class="btn btn-primary">Verify OTP</button>
        </div>
    </form>

    <!-- Resend OTP -->
    <div class="text-center mt-3">
        <form action="resendOtp" method="post">
            <button type="submit" class="btn btn-link">Resend OTP</button>
        </form>
    </div>
</div>

<!-- Footer -->
<footer>
    <p>&copy; 2025 My E-Commerce. All Rights Reserved.</p>
</footer>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<!-- Custom JS Validation -->
<script>
    function validateOtpForm() {
        const otp = document.getElementById("otp");
        const otpRegex = /^[0-9]{6}$/; // only 6-digit numbers
        if (!otpRegex.test(otp.value.trim())) {
            otp.classList.add("is-invalid");
            return false;
        } else {
            otp.classList.remove("is-invalid");
            return true;
        }
    }
</script>

</body>
</html>
