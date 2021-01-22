<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script
  src="https://code.jquery.com/jquery-1.12.4.min.js"
  integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
  crossorigin="anonymous">
</script>
  
<style>

#donor {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 600px;
  font-size: medium;
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

input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=button] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=button]:hover {
  background-color: #45a049;
}

label{
  font-size:medium;
  font-weight:bold;
}

#entry {
  margin-left: 60px;
  margin-top: 25px;
  float:left;
  width:550px;
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}

#registry{
  float:left;
  margin-left: 30px;
  width:600px;
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}

</style>

<script type="text/javascript">

   $(document).ready(function(){

	   $("#campid").focusout(function(){
		   var urlval="http://localhost:2020/donor-camp-service/campservice/activecamp";
			$.ajax({
				type : 'GET',
				url :urlval,
				dataType : 'json',
				contentType : 'application/json',
				success : function(result) {
					var flag=0;
					$.each(result, function(key,value) {

						if(value.id==$("#campid").val()){
							flag=1;
						}
		                   
					});
					  if(flag==0){
						  $('#validity1').html("<i style=\"color:red;font-size:small;\">User Id doesnt exist</i>");
						  $("#register").css("background-color", "red");
						  $("#register").attr("disabled", true);
						  
					  }
					  else{
						  $('#validity1').html("");
						  $("#register").css("background-color", " #4CAF50");
						  $("#register").attr("disabled", false);
						  
					  }
				}
			});
		  });
		  
	   
		  $('#update').click(function(e){

			  var data={};
			  data.id=${donor.id};
			  data.name=$("#name").val();
			  data.dateOfBirth=$("#dateofbirth").val();
			  data.bloodGroup=$("#bloodgroup").val();
			  data.address=$("#address").val();
			  data.city=$("#city").val();
			  data.mailId=$("#mailid").val();
			  data.phoneNumber=$("#phonenumber").val();
			  data.plasmaDonor=$("#plasmadonor").val();
			  data.readyToDonate=$("#readytodonate").val();
			  data.userId="${donor.userId}";
			  data.password=$("#password").val();
			  
			  $.ajax({
					type : 'POST',
					url : "http://localhost:2020/donor-service/donorservice/",
					dataType : 'json',
					data : JSON.stringify(data),
					contentType : 'application/json',
			        success : function(result){

			        	 $('#check').text("Update succussfull:");
			        	 $("#check").fadeOut(10000);
				        }
			  });
		  });

		  $('#register').click(function(e){

			  var data={};
			  data.campId=$("#campid").val();
			  data.donorId=${donor.id};
			  
			  $.ajax({
					type : 'POST',
					url : "http://localhost:2020/donor-camp-service/registry/",
					dataType : 'json',
					data : JSON.stringify(data),
					contentType : 'application/json',
			        success : function(result){

			        	$('#check1').text("registered succussfully:");
			        	$("#check1").fadeOut(4000);
				        }
			  });
		  });
   });
   </script>
  
</head>

<body>

<header>
<jsp:include page="menu.jsp" />
</header>

<div id="entry">
<br>
<h3>User details:</h3>
  <form name="" method="post">
    <label for="name">Name</label>
    <input type="text" id="name" name="name" value="${donor.name}" >
    
    <label for="dateofbirth">DateOfBirth</label>
    <input type="text" id="dateofbirth" name="dateofbirth" value="${donor.dateOfBirth}">
    
    <label for="bloodgroup">Blood Group</label>
    <select id="bloodgroup" name="bloodgroup" >
      <option value="${donor.bloodGroup}">${donor.bloodGroup}</option>
      <option value="apos">A+</option>
      <option value="aneg">A-</option>
      <option value="bpos">B+</option>
      <option value="bneg">B-</option>
      <option value="opos">O+</option>
      <option value="oneg">O-</option>
      <option value="abpos">AB+</option>
      <option value="abneg">AB-</option>
    </select>

    <label for="address">Address</label>
    <input type="text" id="address" name="address" value="${donor.address}">
    
    <label for="city">City</label>
    <input type="text" id="city" name="city" value="${donor.city}">
    
    <label for="mailid">Mail Id</label>
    <input type="text" id="mailid" name="mailid" value="${donor.mailId}">
    
    <label for="phonenumber">Phone Number</label>
    <input type="text" id="phonenumber" name="phonenumber" value="${donor.phoneNumber}">
    
    <label for="plasmadonor">Plasma Donor</label>
    <select id="plasmadonor" name="plasmadonor" >
      <option value="${donor.plasmaDonor}">${donor.plasmaDonor}</option>
      <option value="true">Willing to donate</option>
      <option value="false">Not Willing to donate</option>
    </select>
    
    <label for="readytodonate">Ready to donate</label>
    <select id="readytodonate" name="readytodonate" >
      <option value="${donor.readyToDonate}">${donor.readyToDonate}</option>
      <option value="true">Yes</option>
      <option value="false">No</option>
    </select>
    
    <label for="password">password</label>
    <input type="text" id="password" name="password" value="${donor.password}">

    <input type="button" value="Update" id="update">
  </form>
  <div id="check" style="font-size:medium; color: green; width:500px"></div>
</div>

<br>
<br>
<div id="registry">
<h3>Camp registry:</h3>
  <form name="" method="post">
    <label for="user">Enter the camp id you want to register for:</label>
    <input type="text" id="campid" name="campid" placeholder="camp id..">
    <div id="validity1"></div>
    <input type="button" value="Register" id="register">
  </form>
  <div id="check1" style="font-size:medium;color: green; width:600px"></div>
  <table id="donor" >
<tr>
<th>Id</th>
<th>Name</th>
<th> startDate</th>
<th>endDate</th>
<th>Location</th>
<th>City</th>
<c:forEach items="${active}" var="donor">
<tr>
<td><c:out value="${donor.id }"/></td>
<td><c:out value="${donor.name }"/></td>
<td><c:out value="${donor.startDate}"/></td>
<td><c:out value="${donor.endDate }"/></td>
<td><c:out value="${donor.location }"/></td>
<td><c:out value="${donor.city }"/></td>
</tr>
</c:forEach>
</tr>
</table>
</div>


</body>

</html>