<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div align="center">
<form action="details" method="post">
    Documentary Name:<input type="text" name="documentaryName" required> <br><br>
    Episode:<input type="number" name="episode" required><br><br>
    Photographer:<input type="text" name="photographer"><br><br>
    Fliming Location:<input type="text" name="filmingLocation"><br><br>
    Category:<input type="text" name="category"><br><br>
    <input type="submit" value="submit">
    <p1>${error}</p1>


</form>
</div>
</body>
</html>