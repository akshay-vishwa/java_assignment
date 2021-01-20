<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<table>
<tr>
<th>Roll number</th>
<th>Student name</th>
<th> marks Scored</th>
<c:forEach items="${log}" var="eachStudent">
<tr>
<td><c:out value="${eachStudent.id }"/></td>
<td><c:out value="${eachStudent.slNo }"/></td>
<td><c:out value="as"/></td>
</tr>
</c:forEach>
</tr>
</table>

</body>
</html>