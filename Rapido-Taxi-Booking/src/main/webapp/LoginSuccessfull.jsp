<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">

</head>
<a href="login">Login</a>
<a href="regi">Register</a>

<body>
<h2>${message}</h2>
<h1>Welcome, ${user.name}!</h1>

<table border="1" cellpadding="10">
    <tr>
        <th>Email</th>
        <td>${user.email}</td>
    </tr>
    <tr>
        <th>Phone Number</th>
        <td>${user.phoneNumber}</td>
    </tr>
    <tr>
        <th>Date of Birth</th>
        <td>${user.dob}</td>
    </tr>
    <tr>
        <th>Gender</th>
        <td>${user.gender}</td>
    </tr>
    <tr>
        <th>State</th>
        <td>${user.state}</td>
    </tr>
    <tr>
        <th>Address</th>
        <td>${user.address}</td>
    </tr>
</table>


</body>
</html>
