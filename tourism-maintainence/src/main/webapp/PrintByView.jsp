<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><html>
<body>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">

<a href="tourism"> RedirectToTourism</a>
<a href="<c:url value='/back'/>"> Back</a>

<h5>ID -->${value.ID}</h5>
<h5>touristName-->${value.touristName}</h5>
<h5>destination-->${value.destination}</h5>
<h5>days-->${value.days}</h5>
<h5>fee-->${value.fee}</h5>
<h5>personCount-->${value.personCount}</h5>



    </tbody>
</table>
</body>
</html>
