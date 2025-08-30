<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h2>Login Successful 🎉</h2>

<h3>Welcome, ${user.name}!</h3>

<c:if test="${not empty user.profilePic}">
    <img src="<c:url value='/download?profile=${user.profilePic}'/>"
         alt="Profile Picture" width="150" height="150"/>
</c:if>

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
