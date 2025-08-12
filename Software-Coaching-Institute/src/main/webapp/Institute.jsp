<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<h2>welcome !</h2>
<a href="back">back</a>
<form action="insti" method="post">
CandidateName:<input type="text" name="candidateName"> <br><br>
Degree:<input type="text" name="degree"> <br><br>
YearOfPassout:<input type="text" name="yearOfPassout"> <br><br>
Course:<input type="text" name="course"> <br><br>
Duration:<input type="number" name="duration"> <br><br>
<input type="submit" value="Register"> <br><br>
</form>

</body>
</html>
