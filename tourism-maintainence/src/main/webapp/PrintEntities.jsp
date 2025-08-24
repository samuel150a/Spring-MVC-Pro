<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><html>
<body>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">

<a href="<c:url value='/pback'/>" >back</a>

<h1>Enities in table format</h1>


<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Id</th>
        <th scope="col">touristName </th>
        <th scope="col">destination</th>
        <th scope="col">days</th>
        <th scope="col">fee </th>
        <th scope="col">personCount</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach var="d" items="${ref}">
        <tr>

            <td>${d.ID}</td>
            <td>${d.touristName}</td>
            <td>${d.destination}</td>
            <td>${d.days}</td>
            <td>${d.fee}</td>
            <td>${d.personCount}</td>
            <td><a href="view/${d.ID}">view</a></td>


        </tr>
            </c:forEach>



    </tbody>
</table>
</body>
</html>
