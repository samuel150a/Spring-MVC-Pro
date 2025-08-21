


<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<html>
<body>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
<a href="dback">back</a>
<h2>All Datas in table format!</h2>
<h1>Enities in table format</h1>
<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Id</th>
        <th scope="col">patientName </th>
        <th scope="col">sickness</th>
        <th scope="col">age</th>
        <th scope="col">howLong </th>
        <th scope="col">disabilities</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
        <tr>
            <c:forEach var="d" items="${data}">



                <td>${d.ID}</td>
            <td>${d.patientName}</td>
            <td>${d.sickness}</td>
            <td>${d.age}</td>
            <td>${d.howLong}</td>
            <td>${d.disabilities}</td>
            <td><a href="view/${d.ID}">view</a></td>





        </tr>
    </c:forEach>

</body>
</html>
