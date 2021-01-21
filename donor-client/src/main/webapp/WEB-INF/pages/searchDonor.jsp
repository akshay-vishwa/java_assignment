<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>searchDonor</title>


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

<script
  src="https://code.jquery.com/jquery-1.12.4.min.js"
  integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
  crossorigin="anonymous"></script>
  

<script type="text/javascript">

   $(document).ready(function(){
	   $('#findAll').click(function() {
		   var s="<table id=\"donor\" style=\"width: 900px;font-size: medium; margin-left: 115px;\"><tr><th>Id</th><th>Name</th><th>DateOfBirth</th><th>BloodGroup</th><th>address</th>"+
		   "<th>city</th><th>mailId</th><th>phoneNumber</th><th>PlasmaDonor</th></tr>";
		   var urlval="http://localhost:2020/donor-service/donorservice/";
			$.ajax({
				type : 'GET',
				url :urlval,
				dataType : 'json',
				contentType : 'application/json',
				success : function(result) {
					$.each(result, function(key,value) {
                    s+="<tr><td>"+value.id+"</td><td>"+value.name+"</td><td>"+value.dateOfBirth+"</td><td>"+value.bloodGroup+"</td><td>"+value.address+"</td><td>"+value.city+"</td><td>"+value.mailId+"</td><td>"+value.phoneNumber+"</td><td>"+value.plasmaDonor+"</td></tr>";
					
					});
					s+="</table><br><br>"
					$('#display').html(s);
				}
			});
		});

	   $('#byId').click(function() {
		   var s="<table id=\"donor\" style=\"width: 900px;font-size: medium; margin-left: 230px;\"><tr><th>Id</th><th>Name</th><th>DateOfBirth</th><th>BloodGroup</th><th>address</th>"+
		   "<th>city</th><th>mailId</th><th>phoneNumber</th><th>PlasmaDonor</th></tr>";
		   var urlval="http://localhost:2020/donor-service/donorservice/srchId/"+$("#donorid").val();
			$.ajax({
				type : 'GET',
				url :urlval,
				dataType : 'json',
				contentType : 'application/json',
				success : function(srcResult) {
                    s+="<tr><td>"+srcResult.id+"</td><td>"+srcResult.name+"</td><td>"+srcResult.dateOfBirth+"</td><td>"+srcResult.bloodGroup+"</td><td>"+srcResult.address+"</td><td>"+srcResult.city+"</td><td>"+srcResult.mailId+"</td><td>"+srcResult.phoneNumber+"</td><td>"+srcResult.plasmaDonor+"</td></tr>";
					s+="</table><br><br>"
					$('#display1').html(s);
				}
			});
		});

	   $('#byGroup').click(function() {
		   var s="<table id=\"donor\" style=\"width: 900px;font-size: medium; margin-left: 230px;\"><tr><th>Id</th><th>Name</th><th>DateOfBirth</th><th>BloodGroup</th><th>address</th>"+
		   "<th>city</th><th>mailId</th><th>phoneNumber</th><th>PlasmaDonor</th></tr>";
		   var urlval="http://localhost:2020/donor-service/donorservice/srchGrp/"+$("#group").val();
			$.ajax({
				type : 'GET',
				url :urlval,
				dataType : 'json',
				contentType : 'application/json',
				success : function(result) {
					$.each(result, function(key,value) {
                    s+="<tr><td>"+value.id+"</td><td>"+value.name+"</td><td>"+value.dateOfBirth+"</td><td>"+value.bloodGroup+"</td><td>"+value.address+"</td><td>"+value.city+"</td><td>"+value.mailId+"</td><td>"+value.phoneNumber+"</td><td>"+value.plasmaDonor+"</td></tr>";
					
					});
					s+="</table><br><br>"
					$('#display2').html(s);
				}
			});
		});

	   $('#rdyToDonate').click(function() {
		   var s="<table id=\"donor\" style=\"width: 900px;font-size: medium; margin-left: 230px;\"><tr><th>Id</th><th>Name</th><th>DateOfBirth</th><th>BloodGroup</th><th>address</th>"+
		   "<th>city</th><th>mailId</th><th>phoneNumber</th><th>PlasmaDonor</th></tr>";
		   var urlval="http://localhost:2020/donor-service/donorservice/rdydonate";
			$.ajax({
				type : 'GET',
				url :urlval,
				dataType : 'json',
				contentType : 'application/json',
				success : function(result) {
					$.each(result, function(key,value) {
                    s+="<tr><td>"+value.id+"</td><td>"+value.name+"</td><td>"+value.dateOfBirth+"</td><td>"+value.bloodGroup+"</td><td>"+value.address+"</td><td>"+value.city+"</td><td>"+value.mailId+"</td><td>"+value.phoneNumber+"</td><td>"+value.plasmaDonor+"</td></tr>";
					
					});
					s+="</table><br><br>"
					$('#display3').html(s);
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
<br>
<div >
<form name="" method="post">
         <b style="font-size:medium;">click here to find all donors:</b>
         <input type="button" value="click" id="findAll">
</form>
<div id="display" style="text-align: center;"></div>
</div>
<div >
<form name="" method="post">
         <b style="font-size:medium;">click here to find by donor id:</b><br>
         <label style="font-size: medium;">ID:</label>
         <input type="text" name="donorid" id="donorid" value="">
         <input type="button" value="click" id="byId">
</form>
<div id="display1" style="text-align: center;"></div>
</div>
<div >
<form name="" method="post">
         <b style="font-size:medium;">click here to find all donors by bloodgroup:</b><br>
         <label style="font-size: medium;">Group:</label>
         <input type="text" name="group" id="group" value="">
         <input type="button" value="click" id="byGroup">
</form>
<div id="display2" style="text-align: center;"></div>
</div>
<div >
<form name="" method="post">
         <b style="font-size:medium;">click here to find all donors who are ready to donate:</b>
         <input type="button" value="click" id="rdyToDonate">
</form>
<div id="display3" style="text-align: center;"></div>
</div>
</body>
</html>