<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View List Of Students</title>
<link rel="stylesheet" href="/CSS/smsstyle.css">
<style>
h2
{
text-align : center;
color : green;
font-size : 30px;
}

th{
text-align : center;
color : #e30955;
}

td{
text-align : center;
color : #130ceb;
font-weight:700;
}

#viewalltable
{
width : 75%;
height : 20%;
}
</style>
</head>
<body id="viewallbg">
<a  href="/stuinfo"> <button class="btnd">Back</button></a>
<c:if test="${stulist==null}">
<h2>${msg}</h2>
</c:if>
<c:if test="${stulist!=null}">
<h2>List Of All Student Details</h2>
<table align="center" id="viewalltable" border="1">
<tr>
<th>
Student Id
</th>
<th>
Student Name
</th>
<th>
Gender
</th>

<th>
Email
</th>
<th>
DateOfBirth
</th>

<th>
Father Name
</th>
<th>
Mother Name
</th>
<th>

Phone Number
</th>
</tr>
<c:forEach var="student" items="${stulist}">
<tr>
<td>
<c:out value="${student.id}"></c:out>
</td>
<td>
<c:out value="${student.name}"></c:out>
</td>
<td>
<c:out value="${student.gender}"></c:out>
</td>
<td>
<c:out value="${student.email}"></c:out>
</td>

<td>
<c:out value="${student.dob1}"></c:out>
</td>
<td>
<c:out value="${student.fname}"></c:out>
</td>
<td>
<c:out value="${student.mname}"></c:out>
</td>
<td>
<c:out value="${student.phno}"></c:out>
</td>

</tr>
</c:forEach>
</table>
 
</c:if>


</body>
</html>