<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">

<body>
<h2>Datas!</h2>


<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Documentary Name</th>
        <th scope="col">Episode</th>
        <th scope="col">Photographer</th>
        <th scope="col">Filming Location</th>
        <th scope="col">Category</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="ck" items="${ref}">
        <tr>

            <td>${ck.id}</td>
            <td>${ck.candidateName}</td>
            <td>${ck.degree}</td>
            <td>${ck.yearOfPassout}</td>
            <td>${ck.course}</td>
            <td>${ck.duration}</td>


        </tr>
    </c:forEach>


    </tbody>
</table>


</tbody>
</table>
</body>
</html>

