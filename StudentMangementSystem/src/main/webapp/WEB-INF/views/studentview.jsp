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
color : #db9935;
}
table{
margin-right : 200px;
}
#viewa
{
color : #d6db35;
}
th
{
color : #35dbd0;
font-size : 22px;
}
td{
color :#24e050;
text-align : center;
font-size : 20px;
}
</style>
</head>
<body id="stuviewbg">
<a  href="/stuinfo"> <button class="btnd">Back</button></a>
<h1 id="stu2h1">View Student Details</h1>
<form:form id="stuviewform" action="/submitstuview" modelAttribute="student">
<form:label path="id">Student Id </form:label> &nbsp; 
<form:input type="number" path="id" placeholder="Enter ID" required="required"></form:input> &nbsp; &nbsp; <a id="viewa" href="viewall">View All Student Details</a> <br><br>
<button type="submit" value="Submit">Submit</button>
<br/>

<c:if test="${student1==null}">  
<h3>${msg}</h3>
  </c:if>  
 <c:if test="${student1!=null}">  
<h3 id="viewid"> List Of Student Details</h3>
<table  align="center" border="1">
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
<tr>
<td>
<c:out value="${student1.id}"></c:out>
</td>
<td>
<c:out value="${student1.name}"></c:out>
</td>
<td>
<c:out value="${student1.gender}"></c:out>
</td>
<td>
<c:out value="${student1.email}"></c:out>
</td>

<td>
<c:out value="${student1.dob1}"></c:out>
</td>
<td>
<c:out value="${student1.fname}"></c:out>
</td>
<td>
<c:out value="${student1.mname}"></c:out>
</td>
<td>
<c:out value="${student1.phno}"></c:out>
</td>

</tr>
</table>
  </c:if> 
</form:form>


</body>
</html>
