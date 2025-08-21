function loginEmail()
{
const email=document.getElementById('email').value
console.log(email)
if(email!=="")
{
var xhttp=new XMLHttpRequest();
xhttp.open("Get","http://localhost:8086/Rapido-Taxi-Booking/checkEmail?email"=+email)
xhttp.send();
xhttp.onload=function();
document.getElementById("errormail").innerHTML=this.responseText;
            toggleSubmit();

}

}
else {
        document.getElementById("errormail").innerHTML = "";
}}
function toggleSubmit() {
    const errormail = document.getElementById("errormail").innerText.trim();
    //const errormobile = document.getElementById("errormobile").innerText.trim();

    const submit = document.querySelector("#form button[type='submit']");
//|| errormobile !== ""
    if (errormail !== "" ) {
        submit.disabled = true;
    } else {
        submit.disabled = false;
    }
}

