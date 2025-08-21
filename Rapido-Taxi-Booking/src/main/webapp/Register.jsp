<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">

</head>
<body>
<h2> Fill Details</h2>

<form action="register" method="post">
    Name:<input type="text" name="name"> <br><br>

    <span id="emailerror"></span>
    Email:<input type="text" name="email" id="email" onchange="loginemail()"> <br><br>


    PhoneNumber:<input type="number" name="phoneNumber" onblur="calling()"> <br><br>
    Dob:<input type="date" name="dob"> <br><br>
    Gender:<input type="text" name="gender"> <br><br>
    State:<input type="text" name="state"> <br><br>
    Address:<input type="text" name="address"> <br><br>
    Password:<input type="text" name="password"> <br><br>
    ConfirmPassword:<input type="text" name="confirmPassword"> <br><br>
    <input type="submit" value="Submit"> <br><br>
</form>
<script>



    function calling()
    {
    console.log("helo")
    }

    function loginemail()
{
console.log("hai")
const email=document.getElementById('email').value
console.log(email)
if(email!=="")
{
var xhttp=new XMLHttpRequest();
xhttp.open("Get","http://localhost:8086/Rapido-Taxi-Booking/checkEmail?email="+email)
xhttp.send();
xhttp.onload=function(){

document.getElementById("emailerror").innerHTML=this.responseText;
            toggleSubmit();
};
}

else {
        document.getElementById("errormail").innerHTML = "";
}
}

<!--function toggleSubmit() {-->
<!--    const errormail = document.getElementById("errormail").innerText.trim();-->
<!--    //const errormobile = document.getElementById("errormobile").innerText.trim();-->

<!--    const submit = document.querySelector("#form button[type='submit']");-->
<!--//|| errormobile !== ""-->
<!--    if (errormail !== "" ) {-->
<!--        submit.disabled = true;-->
<!--    } else {-->
<!--        submit.disabled = false;-->
<!--    }-->
<!--}-->



</script>
<!--<script src="js/Ajax.js" defer></script>-->

</body>
</html>

