<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<a href="<c:url value='/wback'/>">back</a>
<body>
<div align="center">
<h2>Datas Fetched by id!</h2>
<h5>Id  :${myid.id}</h5>
<h5>candidateName  :${myid.candidateName}</h5>
<h5>degree  :${myid.degree}</h5>
<h5>yearOfPassout   :${myid.yearOfPassout}</h5>
<h5>course  :${myid.course}</h5>
<h5>duration :${myid.duration}</h5>
</div>
</body>
</html>


