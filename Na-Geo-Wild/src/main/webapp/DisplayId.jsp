<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">

<h2>Hello World!</h2>
<!--<a href="wback">back</a>-->

<a href="<c:url value='/wback'/>">Back</a>

<div align="center">
<h5>ID :${onlyId.id}</h5> <br><br>
<h5>DocumentaryName :${onlyId.documentaryName}</h5><br><br>
<h5>Episode :${onlyId.episode}</h5><br><br>
<h5>Photographer :${onlyId.photographer}<br><br>
<h5>FilmingLocation :${onlyId.filmingLocation}</h5><br><br>
<h5>Category :${onlyId.category}</h5>
</div>

</body>
</html>
