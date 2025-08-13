<html>
<body>
<h2>Fill the Form</h2>
<form action="form" method="post">

    <label for="passportOffice">Passport Office:</label>
    <select name="passportOffice" id="passportOffice" required>
        <option value="">Select</option>
        <option value="Bengaluru">Bengaluru</option>
        <option value="Chennai">Chennai</option>
        <option value="Coimbatore">Coimbatore</option>
        <option value="Delhi">Delhi</option>
        <option value="Goa">Goa</option>
        <option value="Hyderabad">Hyderabad</option>
        <option value="Jalandhar">Jalandhar</option>
    </select>

    GivenName : <input type="text" name="givenName"> <br><br>
    Surname : <input type="text" name="surname"> <br><br>
    DateOfBirth : <input type="number" name="dateOfBirth"> <br><br>

    <span id="emailerror"></span><br>

    EmailId : <input type="email" name="emailId" id="email" onblur="loginMail()"> <br><br>
    PhoneNo : <input type="number" name="phoneNo"> <br><br>


    <label>Do you want Login ID to be same as Email?</label><br>

    <input type="radio" name="asEmail" value="yes" id="asEmailYes">
    <label for="asEmailYes">Yes</label>

    <input type="radio" name="asEmail" value="no" id="asEmailNo" checked>
    <label for="asEmailNo">No</label>
    <br><br> LoginID : <input type="text" name="loginID"> <br><br>


    Password : <input type="text" name="password"> <br><br>
    ConfirmPassword : <input type="text" name="confirmPassword"> <br><br>

    <label for="hintQuestion">HintQuestion:</label>
    <select name="hintQuestion" id="hintQuestion" required>
        <option value="">Select</option>
        <option value="BirthCity">birthCity</option>
        <option value="FavouriteColor">favouriteColor</option>
        <option value="FavouriteCricketer">favouriteCricketer</option>
        <option value="FavouriteFood">favouriteFood</option>

    </select>

    HintAnswer : <input type="text" name="hintAnswer"> <br><br>
    <input type="submit" value="Register">
</form>
<script>
    function loginMail()
    {
    console.log("Check");
    const email=document.getElementById('email').value;
    console.log(email);
    if(email!=="")
    {
        console.log("Check1",email);

    var xhttp=new XMLHttpRequest();
    xhttp.open("GET","http://localhost:8080/passport-seva/checkemail?email="+email);
    xhttp.send();
        console.log(xhttp);
    xhttp.onload=function()
    {
    document.getElementById("emailerror").innerHTML=this.responseText;

    }
    }
    }
</script>
</body>
</html>

