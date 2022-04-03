<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false" %>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/CSS/smsstyle.css">
<style>
h3{
text-align : center;
color : white;
font-size : 30px;
}
.btnd{

border-radius : 10px;
padding : 15px;

}

</style>
</head>
<body id="studelbg">
<h3>${msg}</h3>
<a  href="/stuinfo"> <button class="btnd">Back</button></a>
<h1 id="stu3h1">Delete Student Details</h1>
<form:form id="studelform" action="/submitstudel" modelAttribute="student">
<form:label path="id">Student Id </form:label> &nbsp; 
<form:input type="number" path="id" placeholder="Enter ID" required="required"></form:input><br><br>
<button type="submit" value="Submit">Submit</button>
</form:form>

</body>
</html>
</html>