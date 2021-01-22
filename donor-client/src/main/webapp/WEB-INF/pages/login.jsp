<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    


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
					  if(flag==1){
						  $('#validity').html("<i style=\"color:red;font-size:small;\">User Id does not exist</i>");
						  $("#submit").attr("disabled", true);
						  $("#submit").css("background-color", "red");
						  
					  }
					  else{
						  $('#validity').html("");
						  $("#submit").css("background-color", " #4CAF50");
						  $("#submit").attr("disabled", false);
					  }
				}
			});
		  });

	   $('#submit').click(function(e){

			  $.ajax({
					type : 'GET',
					url : "http://localhost:2020/donor-service/donorservice/",
					dataType : 'json',
					contentType : 'application/json',
			        success : function(result){
			        	var flag=true;
						$.each(result, function(key,value) {

							if(value.userId==$("#userid").val() && value.password==$("#password").val()){
								flag=false;
							}
			                   
						});
						if(flag){
							  $('#result').html("<i style=\"color:red;font-size:large;\">wrong entry</i>");	  
							  $('#link').html("");
						  }
						else{
							  $('#result').html("<i style=\"color:green;font-size:large;\">successful</i>");
							  $('#link').html("<i style=\"font-size:small;\">click <a href=\"/login/"+$("#userid").val()+"\">here</a> for going to account</i>");
						  }
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
<h3 style="margin-left: 100px;">login</h3>

<div id="entry">
  <form name="" method="post">
    <label for="userid">Login Id</label>
    <input type="text" id="userid" name="userid" placeholder="Your login id..">
    <div id="validity"></div>
    <label for="password">password</label>
    <input type="text" id="password" name="password" placeholder="Your password..">

    <input type="button" value="Login" id="submit">
  </form>
</div>
<i id="result" style="margin-left: 100px;"></i>
<i id="link" style="margin-left: 310px;"></i>
</body>
</html>