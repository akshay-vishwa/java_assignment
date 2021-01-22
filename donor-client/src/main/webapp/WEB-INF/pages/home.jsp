<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Blood Donation Online</title>

<script
  src="https://code.jquery.com/jquery-1.12.4.min.js"
  integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
  crossorigin="anonymous">
</script>
  

<script type="text/javascript">

   $(document).ready(function(){
	   $('#button').click(function() {
		   var s="<table id=\"donor\" style=\"width: 900px;font-size: medium; margin-left: 230px;\"><tr><th>Id</th><th>Name</th><th>DateOfBirth</th><th>BloodGroup</th><th>address</th>"+
		   "<th>city</th><th>mailId</th><th>phoneNumber</th><th>PlasmaDonor</th></tr>";
		   var urlval="http://localhost:2020/donor-service/donorservice/eligible";
			$.ajax({
				type : 'GET',
				url :urlval,
				dataType : 'json',
				contentType : 'application/json',
				success : function(result) {
					$.each(result, function(key,value) {
                    s+="<tr><td>"+value.id+"</td><td>"+value.name+"</td><td>"+value.dateOfBirth+"</td><td>"+value.bloodGroup+"</td><td>"+value.address+"</td><td>"+value.city+"</td><td>"+value.mailId+"</td><td>"+value.phoneNumber+"</td><td>"+value.plasmaDonor+"</td></tr>";
					
					});
					s+="</table>"
					$('#display').html(s);
				}
			});
		});
   });
   </script>

<style>
#donor {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#donor td, #donor th {
  border: 1px solid #ddd;
  padding: 8px;
}

#donor tr:nth-child(even){background-color: #f2f2f2;}

#donor tr:hover {background-color: #ddd;}

#donor th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #8f3a3a;
  color: white;
}
</style>
</head>
<body>

<header>
<jsp:include page="menu.jsp" />
</header>
<div style="text-align: center;color: #0000009a;">
  <br>
  <h2 style="font-family:'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;color: #423535;">The Blood Donation Process</h2>
  <p>The blood donation process from the time you arrive until the time you leave takes about an hour. <br>The donation itself is only about 8-10 minutes on average.</p>
</div>
<br>
<div style="background-color: #eea3a3; width: auto;height: 600px;">

  <div style="float: left; margin-left: 70px; border: 2px solid rgb(139, 78, 78);border-radius: 8px; width: 400px;height: 600px; background-color: #f3e9e9;box-shadow: 2px 2px 8px 1px #888888;">
    <h2 style="text-align: center; color: #423535; font-family:'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;">Health History</h2>
    <p style="margin-left: 20px; font-size:large; font-family: 'Courier New', Courier, monospace;">
      -You’ll answer a few questions about your health history and places you’ve traveled, during a private and confidential interview.
      <br><br>-You’ll tell us about any prescription and/or over the counter medications that may be in your system.
      <br><br>-We’ll check your temperature, pulse, blood pressure and hemoglobin level. 
    </p>
  </div>

  <div style=" float: left; margin-left:10px; border: 2px solid rgb(139, 78, 78);border-radius: 8px; width: 400px;height: 600px; background-color: #f3e9e9;box-shadow: 2px 2px 8px 1px #888888;">
    <h2 style="text-align: center; color: #423535;font-family:'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;">Your Donation</h2>
    <p style="margin-left: 20px; font-size:large; font-family:'Courier New', Courier, monospace;">
      -If you’re donating whole blood, we’ll cleanse an area on your arm and insert a brand new sterile needle for the blood draw. (This feels like a quick pinch and is over in seconds.)
       <br><br>-Other types of donations, such as platelets, are made using an apheresis machine which will be connected to both arms.
       <br><br>-A whole blood donation takes about 8-10 minutes, during which you’ll be seated comfortably or lying down.
       <br><br>-When approximately a pint of whole blood has been collected, the donation is complete and a staff person will place a bandage on your arm.
    </p>
  </div>

  <div style="float: left; margin-left: 10px; border: 2px solid rgb(139, 78, 78);border-radius: 8px; width: 400px;height: 600px; background-color: #f3e9e9;box-shadow: 2px 2px 8px 1px #888888;">
    <h2 style="text-align: center; color: #423535;font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;">Refreshment and Recovery</h2>
    <p style="margin-left: 20px; font-size:large;font-family: 'Courier New', Courier, monospace;">
      -After donating blood, you’ll have a snack and something to drink in the refreshment area.
      <br><br>-You’ll leave after 10-15 minutes and continue your normal routine.
      <br><br>-Enjoy the feeling of accomplishment knowing you are helping to save lives.
      <br><br>-Take a selfie, or simply share your good deed with friends. It may inspire them to become blood donors. 
    </p>
  </div>

</div>
<p style="text-align: center;margin-top: 40px;" > Total donations so far are <br><c:out value="${count}" /></p>

<p style="margin-left: 40px;text-align: center;">Recent donations are..</p>
<table id="donor" style="width: 900px;font-size: medium; margin-left: 260px;">
<tr>
<th>Sl.no</th>
<th>Donor ID</th>
<th> donatedDate</th>
<th>CampId</th>
<th>Location</th>
<th>City</th>
<c:forEach items="${log}" var="donor">
<tr>
<td><c:out value="${donor.slNo }"/></td>
<td><c:out value="${donor.id }"/></td>
<td><c:out value="${donor.donatedDate}"/></td>
<td><c:out value="${donor.campId }"/></td>
<td><c:out value="${donor.location }"/></td>
<td><c:out value="${donor.city }"/></td>
</tr>
</c:forEach>
</tr>
</table>
<br>
<div style="text-align: center;">
  <p>Click here to find out eligible and willing to donate donors:-</p>
     <form name="" method="post">
         <input type="button" value="click" id="button">
      </form>
   <div id="display"></div>
</div>
</body>
</html>