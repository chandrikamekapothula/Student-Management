<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View List Of Students Academic Details</title>
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
tr.fail
{
background-color :#eb7171;
}

#viewalltable
{
width : 75%;
height : 20%;
}
</style>
</head>
<body id="viewallbg">
<a  href="/studetail"> <button class="btnd">Back</button></a>
<c:if test="${stulist==null}">
<h2>${msg}</h2>
</c:if>
<c:if test="${stulist!=null}">
<h2>List Of All Student Academic Details</h2>
<table align="center" id="viewalltable" border="1">
<tr>
<th>
Student Id
</th>
<th>
Student Name
</th>
<th>
Subject1
</th>

<th>
Subject2
</th>
<th>
Subject3
</th>

<th>
Grade
</th>

</tr>
<c:forEach var="student" items="${stulist}">

<tr class="${student.grade =='F' ? 'fail' : 'pass'}">
<td>
<c:out value="${student.id}"></c:out>
</td>
<td>
<c:out value="${student.name}"></c:out>
</td>
<td>
<c:out value="${student.marks1}"></c:out>
</td>
<td>
<c:out value="${student.marks2}"></c:out>
</td>

<td>
<c:out value="${student.marks3}"></c:out>
</td>
<td>
<c:out value="${student.grade}"></c:out>
</td>

</tr>
</c:forEach>
</table>
 
</c:if>


</body>
</html>