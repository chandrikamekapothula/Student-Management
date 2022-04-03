<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Academic Page</title>
<link rel="stylesheet" href="/CSS/smsstyle.css">
<style>
h1{
margin-top : 20px;
text-align : center;
color :#41c447;
font-size : 30px;
}
h3
{
margin-left : 20px;
font-size : 20px;
color : #cfca3c;
}
#acform
{
color:#c241c4;
margin-left :150px;
font-size : 20px;

}
</style>
</head>
<body id="acdbg">
<a  href="/studetail"> <button class="btnd">Back</button></a>
<a  href="/viewac"> <button class="btns">Next</button></a>
<h1>Students Academic Information</h1>

<form:form id="acform" action="/submitid"  modelAttribute="student">
<form:label path="id" >Enter Id</form:label> &nbsp; &nbsp; &nbsp;
<form:input type="number" path="id" required="required"></form:input><br><br>
<button type="submit" value="Submit">Submit </button>
</form:form>
<c:if test="${stu==null}">
<h3>${msg}</h3>
</c:if>

<c:if test="${stu!=null}">
<h3>Enter "${stu.getName()}" Marks </h3>
<form:form id="acform" action="/submitacd"  modelAttribute="stu">
<form:label path="marks1" >Enter Marks1</form:label> &nbsp; &nbsp; &nbsp;
<form:input type="number" path="marks1" required="required"></form:input><br><br>
<form:label path="marks2" >Enter Marks2</form:label> &nbsp; &nbsp; &nbsp;
<form:input type="number" path="marks2" required="required"></form:input><br><br>
<form:label path="marks3" >Enter Marks3</form:label> &nbsp; &nbsp; &nbsp;
<form:input type="number" path="marks3" required="required"></form:input><br><br>
<button type="submit" value="Submit">Submit </button><br><br>
<h3>${msg}</h3>
</form:form>


</c:if>
</body>
</html>