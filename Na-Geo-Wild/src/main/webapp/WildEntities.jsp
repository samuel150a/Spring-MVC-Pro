<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">

</head>
<body>
<h1>Enities in table format</h1>


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
    <c:forEach var="ref" items="${listOfDto}">
    <tr>

        <td>${ref.id}</td>
        <td>${ref.documentaryName}</td>
        <td>${ref.episode}</td>
        <td>${ref.photographer}</td>
        <td>${ref.filmingLocation}</td>
        <td>${ref.category}</td>


    </tr>
    </c:forEach>


    </tbody>
</table>


    </tbody>
</table>
</body>
</html>