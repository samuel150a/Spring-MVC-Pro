<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<a href="back">back</a>
<h2>welcome !</h2>

<form action="docs" method="post">
    patientName:<input type="text" name="patientName"> <br><br>
    sickness:<input type="text" name="sickness"> <br><br>
    age:<input type="number" name="age"> <br><br>
    howLong:<input type="text" name="howLong"> <br><br>
    disabilities:<input type="text" name="disabilities"> <br><br>
    <input type="submit" value="Submit"> <br><br>
</form>

</body>
</html>
