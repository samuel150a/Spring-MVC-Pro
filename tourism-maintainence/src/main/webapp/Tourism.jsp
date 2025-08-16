<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>Welcome to Tourism</h1>
<a href="<c:url value='/indexPage'/>"> klmlBack</a>

<form action="register" method="post">
    TouristName:<input type="text" name="touristName" required> <br><br>
    Destination:<input type="text" name="destination" required> <br><br>
    Days:<input type="number" name="days" required> <br><br>
    Fee:<input type="number" name="fee" required> <br><br>
    PersonCount:<input type="number" name="personCount" required> <br><br>
    <input type="submit" value="submit">


</form>

</body>
</html>

