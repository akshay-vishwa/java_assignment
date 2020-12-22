<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
<form action="donor" method="post">

    <label for="">Name</label><br>
	<input type="text" name="name"/><br>
	<label for="">age</label><br>
	<input type="text" name="age"/><br>
	<label for="">gender</label><br>
	<select name="gender" >
       <option value="male">male</option>
       <option value="female">female</option>
    </select><br>
	<label for="">bloodgroup</label><br>
	<select name="bloodgroup" >
       <option value="apos">apos</option>
       <option value="bpos">bpos</option>
       <option value="aneg">aneg</option>
       <option value="bneg">bneg</option>
    </select><br>
	<label for="">phonemunber</label><br>
	<input type="text" name="phonenumber"/><br>
	<label for="">email</label><br>
	<input type="text" name="email"/><br>
	<label for="">dateofbirth</label><br>
	<input type="date" name="dateofbirth"/><br>
	
	<input type="submit" value="ADD" />
	<!-- add c:if here -->
    <p>rows added is:</p><c:out value="${row}"/>
</form>
</body>
</html>