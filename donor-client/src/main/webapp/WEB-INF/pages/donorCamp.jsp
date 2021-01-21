<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Blood Donation Online</title>
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
	   $('#button').click(function() {
		   var s="<table id=\"donor\" style=\"width: 900px;font-size: medium; margin-left: 230px;\"><tr><<th>Sl.no</th><th>campId</th><th>donorId</th></tr>";
		   var urlval="http://localhost:2020/donor-camp-service/registry/"+$("#id").val();
			$.ajax({
				type : 'GET',
				url :urlval,
				dataType : 'json',
				contentType : 'application/json',
				success : function(result) {
					$.each(result, function(key,value) {
                    s+="<tr><td>"+value.slno+"</td><td>"+value.campId+"</td><td>"+value.donorId+"</td></tr>";
					
					});
					s+="</table>"
					$('#display').html(s);
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
<div style="text-align: center;">
    <p>List of active camps are<br><c:out value="${count}" /></p>
    <p> List of active camps:</p>
    
    <table id="donor" style="width: 900px;font-size: medium;margin-left: 220px;">
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

<br>
<br>
<div style="text-align: center;">
    <p>List of ended camps:</p>
    <table id="donor" style="width: 900px;font-size: medium;margin-left: 220px;">
<tr>
<th>Id</th>
<th>Name</th>
<th> startDate</th>
<th>endDate</th>
<th>Location</th>
<th>City</th>
<c:forEach items="${ended}" var="donor">
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
<br>
<div style="text-align: center;">
  <p>Search the donor registered for a perticular camp</p>
     <form name="" method="post">
         <b style="font-size: medium;">ID:</b>
         <input type="text" name="id" id="id" value="">
         <input type="button" value="Submit" id="button">
      </form>
   <div id="display"></div>
</div>

</body>
</html>