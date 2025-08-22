<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">

</head>
<body>
<h2> Fill Details</h2>

<form action="log" method="post">
    Email:<input type="text" name="email"> <br><br>

    Password:<input type="text" name="password"> <br><br>
    <input type="submit" value="Submit"> <br><br>
</form>

</body>
</html>

