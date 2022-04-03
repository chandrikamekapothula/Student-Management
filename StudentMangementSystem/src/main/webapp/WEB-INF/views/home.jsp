<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false" %>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/CSS/smsstyle.css">
<style>
h2{
text-align : center;
color : red;
}
</style>
</head>
<body id="adminid1" >
<h2>${msg}</h2>
<h1 id="adminheader"> ADMIN Login</h1><br/>
<br/>

<fieldset  id="fieldid">
<legend id="lgid">Admin Login </legend><br/>
<form:form id="formid" action="/studetail" method="post" modelAttribute="admin">
<form:label path="email">Email</form:label> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
<form:input type="email" path="email" placeholder="abc@gmail.com" required="required"></form:input><br/><br/>
<form:label path="password">Password</form:label> &nbsp; &nbsp;
<form:input type="password" path="password" placeholder="Enter Password"></form:input><br/><br/>

<button type="submit" value="Submit">Submit</button>
</fieldset>
</form:form>
</body>
</html>