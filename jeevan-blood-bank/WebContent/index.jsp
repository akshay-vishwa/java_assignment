<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<header>
<jsp:include page="menu.jsp" />
</header>


   <div >
      <form action = "donor" method="post">
         <label for="">Login id</label><br>
	     <input type="text" name="loginId"/><br>
	     <label for="">Password</label><br>
	     <input type="text" name="password"/><br>
	     <input type="submit" value="Login" name="login"/>
      </form>
   </div>

</body>
</html>