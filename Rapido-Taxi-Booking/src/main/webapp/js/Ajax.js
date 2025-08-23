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


function loginPhNo()
{
const PhNo=document.getElementById('PhNo').value
if(PhNo!=="")
{
var xhttp=new XMLHttpRequest();
<!--checkPhNo(Mapping Attribute)?phoneNumber(name=)="+PhNo(var)-->

xhttp.open("Get","http://localhost:8086/Rapido-Taxi-Booking/checkPhNo?phoneNumber="+PhNo)
xhttp.send();
xhttp.onload=function(){
document.getElementById("PhNoerror").innerHTML=this.responseText;
toggleSubmit();
};
}

else{
document.getElementById("PhNoerror").innerHTML="";
}
}

//function loginName()
//{
//const Name=
//const Name=
//}


