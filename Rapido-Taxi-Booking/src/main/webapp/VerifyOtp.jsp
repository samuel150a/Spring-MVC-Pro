<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en" xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <meta charset="UTF-8">
    <title>Verify Otp</title>
</head>
<body>
<h1>Verify Otp</h1>
<!-- Show message if available -->
<c:if test="${not empty message}">
    <p style="color: red; font-weight: bold;">${message}</p>
</c:if>
<form action="verify" method="post">
    <input type="hidden" name="email" value="${rapidoDto.email}">
    <label>Enter OTP:</label>
    <input type="text" name="otp" required>
    <button type="submit">Verify</button>
</form>

</body>

</html>