<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Academic Details</title>
<link rel="stylesheet" href="/CSS/smsstyle.css">
<style>
h1{
margin-top : 20px;
text-align : center;
color :#3449eb;
font-size : 30px;
}
h3
{
margin-left : 20px;
font-size : 20px;
color : #d62418;
}
#viewform
{
color: green;
margin-left :650px;
font-size : 20px;

}
#viewalltable
{
width : 95%;
height : 30%;

}
th
{
color : #c41f14;
font-size : 22px;
}
td{
color :#a120a8;
text-align : center;
font-size : 20px;
}
h2{
tex-align :center;
}
#viewac
{
color : green;
}
</style>
</head>
<body id="viewacd">
<a  href="/acd"> <button class="btnd">Back</button></a>
<h1>View Academic Student Details</h1><br>
<form:form id="viewform" action="/submitviewac"  modelAttribute="student">
<form:label path="id" >Enter Id</form:label> &nbsp; &nbsp; &nbsp;
<form:input type="number" path="id" required="required"></form:input> &nbsp; &nbsp; <a id="viewac" href="viewallac">View All Student Academic Details</a> <br><br><br><br>
<button type="submit" value="Submit">Submit </button><br>

<c:if test="${student1==null}">  
<h3>${msg}</h3>
  </c:if>  
 <c:if test="${student1!=null}">  
<h2 > List Of Student Details</h2>
<table id="viewalltable"  border="1">
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
<tr>
<td>
<c:out value="${student1.id}"></c:out>
</td>
<td>
<c:out value="${student1.name}"></c:out>
</td>
<td>
<c:out value="${student1.marks1}"></c:out>
</td>
<td>
<c:out value="${student1.marks2}"></c:out>
</td>

<td>
<c:out value="${student1.marks3}"></c:out>
</td>
<td>
<c:out value="${student1.grade}"></c:out>
</td>


</tr>
</table>
  </c:if> 
</form:form>
</body>
</html>