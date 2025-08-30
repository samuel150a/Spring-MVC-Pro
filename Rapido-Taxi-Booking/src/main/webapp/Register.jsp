<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">

</head>
<body>
<h2> Fill Details</h2>

<form action="register" method="post" enctype="multipart/form-data">
    Name:<input type="text" name="name"> <br><br>

    <span id="emailerror"></span>
    Email:<input type="text" name="email" id="email" onchange="loginemail()"> <br><br>

    <span id="PhNoerror"></span>

    PhoneNumber:<input type="number" name="phoneNumber" id="PhNo" onchange="loginPhNo()"> <br><br>
    Dob:<input type="text" name="dob"> <br><br>
    Gender:<input type="text" name="gender"> <br><br>
    State:<input type="text" name="state"> <br><br>
    Address:<input type="text" name="address"> <br><br>
    Password:<input type="text" name="password"> <br><br>
    ConfirmPassword:<input type="text" name="confirmPassword"> <br><br>

        Profile Picture:
        <input type="file" name="profilePicture" value="${rapidoDto.profilePicture}"/></td>

    <input type="submit" value="Submit"> <br><br>
</form>



<script src="js/Ajax.js" defer></script>


</body>
</html>

