<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  margin: 0;
  font-size: 28px;
  font-family: Arial, Helvetica, sans-serif;
}

.header {
  background-color: #f1f1f1;
}

#navbar {
  overflow: hidden;
  background-color: rgb(49, 15, 15);
}

#navbar a {
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

#navbar a:hover {
  background-color: rgb(153, 53, 53);
  color: rgb(255, 255, 255);
}

#navbar a.active {
  background-color: #be0d0d;
  color: white;
  
}

.content {
  padding: 16px;
}

.sticky {
  position: fixed;
  top: 0;
  width: 100%;
}

.sticky + .content {
  padding-top: 60px;
}
</style>
</head>
<body>

<div class="header">
    <div style="width:1366px;height:250px;background-color:red;background-image:linear-gradient(rgb(184, 12, 12), #a33d3d);"></div>
    <div style="width:200px;height:250px;position: absolute;left: 84%;top: 0%;opacity: 0.8;background-color:white;background-image:linear-gradient(rgb(235, 165, 165), #a13535b9);"></div>
    <h1 style="position: absolute;left: 18%;top: 19%;opacity: 0.9;color: #f1f1f1;text-shadow: 2px 2px 4px #000000;font-family:'Times New Roman', Times, serif;">Online Blood Donor</h1>
</div>

<div id="navbar">
  
  <a class="active" href="javascript:void(0)">HOME</a>
  <a href="javascript:void(0)"><B>ELIGIBILITY</B></a>
  <a href="javascript:void(0)">BLOOD FACTS</a>
  <a href="javascript:void(0)">DONOR REGISTRATION</a>
  <a href="javascript:void(0)">DONATION CAMPS</a>
  <a href="javascript:void(0)">SEARCH A DONOR</a>
  <a href="javascript:void(0)">LOGIN</a>
</div>

<script>
window.onscroll = function() {myFunction()};

var navbar = document.getElementById("navbar");
var sticky = navbar.offsetTop;

function myFunction() {
  if (window.pageYOffset >= sticky) {
    navbar.classList.add("sticky")
  } else {
    navbar.classList.remove("sticky");
  }
}
</script>

</body>
</html>