<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>

ul>li{

 display:inline;
 margin:10px 10px;
 border:2px solid red;
 border-radius:5px;

}

</style>

</head>
<body>

<ul>
      
      <c:if test = "${valid=='true'}">
         <li><a href="addDonor.jsp">Add donor</a></li>
      </c:if>
      <c:if test = "${valid=='false'}">
         <li><a href="index.jsp">Add donor</a></li>
      </c:if>
   <li><a href="donor">View donor</a></li>
</ul>

</body>
</html>