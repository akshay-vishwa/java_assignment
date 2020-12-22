<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.training.model.BloodDonor" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>view table</title>
<style>
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  text-align: left;
  padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
  background-color: #4CAF50;
  color: white;
}
</style>
</head>
<body>
<table>
   <tr>
     <th>Name</th>
     <th>Age</th>
     <th>Gender</th>
     <th>BloodGroup</th>
     <th>PhoneNumber</th>
     <th>Email</th>
     <th>dateOfBirth</th>
    </tr>
     <c:forEach items="${donorList}" var="donor">
       <tr>
         <td><c:out value="${donor.getName() }"/></td>
         <td><c:out value="${donor.getAge() }"/></td>
         <td><c:out value="${donor.getGender() }"/></td>
         <td><c:out value="${donor.getBloodGroup()}"/></td>
         <td><c:out value="${donor.getPhoneNumber() }"/></td>
         <td><c:out value="${donor.getEmail() }"/></td>
         <td><c:out value="${donor.getDateOfBirth() }"/></td>
         
       </tr>
     </c:forEach>
</table>
</body>
</html>