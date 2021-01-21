<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<script
  src="https://code.jquery.com/jquery-1.12.4.min.js"
  integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
  crossorigin="anonymous"></script>

<script type="text/javascript">

   $(document).ready(function(){
	   
	   $("#userid").focusout(function(){
		   var urlval="http://localhost:2020/donor-service/donorservice/";
			$.ajax({
				type : 'GET',
				url :urlval,
				dataType : 'json',
				contentType : 'application/json',
				success : function(result) {
					var flag=1;
					$.each(result, function(key,value) {

						if(value.userId==$("#userid").val()){
							flag=0;
						}
		                   
					});
					  if(flag==0){
						  $('#validity').html("<i style=\"color:red;font-size:small;\">User Id exists</i>");
						  $("#submit").attr("disabled", true);
					  }
					  else{
						  $('#validity').html("");
						  $("#submit").attr("disabled", false);
					  }
				}
			});
		  });

		  $('#submit').click(function(e){

			  var data={};
			  data.name=$("#name").val();
			  data.dateOfBirth=$("#dateofbirth").val();
			  data.bloodGroup=$("#bloodgroup").val();
			  data.address=$("#address").val();
			  data.city=$("#city").val();
			  data.mailId=$("#mailid").val();
			  data.phoneNumber=$("#phonenumber").val();
			  data.plasmaDonor=$("#plasmadonor").val();
			  data.readyToDonate=$("#readytodonate").val();
			  data.userId=$("#userid").val();
			  data.password=$("#password").val();

			  $('#success').html("New entry succussfully added:");
			  
			  $.ajax({
					type : 'POST',
					url : "http://localhost:2020/donor-service/donorservice/",
					dataType : 'json',
					data : JSON.stringify(data),
					contentType : 'application/json',
			        success : function(result){

			        	$('#success').html("New entry succussfully added:");
				        }
			  });
		  });
   });
   </script>

<style>
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
  margin-left: 100px;
  width:550px;
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
<body>
<header>
<jsp:include page="menu.jsp" />
</header>
<br>
<h3 style="margin-left: 100px;">Registration Form</h3>

<div id="entry">
  <form name="" method="post">
    <label for="name">Name</label>
    <input type="text" id="name" name="name" placeholder="Your name..">
    
    <label for="dateofbirth">DateOfBirth</label>
    <input type="text" id="dateofbirth" name="dateofbirth" placeholder="Your date of birth(yyyy-mm-dd)..">
    
    <label for="bloodgroup">Blood Group</label>
    <select id="bloodgroup" name="bloodgroup">
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
    <input type="text" id="address" name="address" placeholder="Your address..">
    
    <label for="city">City</label>
    <input type="text" id="city" name="city" placeholder="Your city..">
    
    <label for="mailid">Mail Id</label>
    <input type="text" id="mailid" name="mailid" placeholder="Your mail id..">
    
    <label for="phonenumber">Phone Number</label>
    <input type="text" id="phonenumber" name="phonenumber" placeholder="Your phone number..">
    
    <label for="plasmadonor">Plasma Donor</label>
    <select id="plasmadonor" name="plasmadonor">
      <option value="true">Willing to donate</option>
      <option value="false">Not Willing to donate</option>
    </select>
    
    <label for="readytodonate">Ready to donate</label>
    <select id="readytodonate" name="readytodonate">
      <option value="true">Yes</option>
      <option value="false">No</option>
    </select>
    
    <label for="userid">Login Id</label>
    <input type="text" id="userid" name="userid" placeholder="Your login id..">
    <div id="validity"></div>
    <label for="password">password</label>
    <input type="text" id="password" name="password" placeholder="Your password..">

    <input type="button" value="Submit" id="submit">
  </form>
</div>
<div id="succuss" style="text-align: center;"></div>
</body>
</html>