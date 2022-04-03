<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false" %>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/CSS/smsstyle.css">
<style>
td{
width : 500px;
height : 40px;
}
h3
{
text-align : center;
color : white;
font-size : 30px;
}
</style>
</head>
<body id="stuaddbg">
<a  href="/stuinfo"> <button class="btnd">Back</button></a>
<form:form  action="/submitstuadd" modelAttribute="student">
<h3>${msg}</h3>
<table id="stuform">
<tr><td><h1 id="stuh1">Student Details </h1></td></tr>
<tr>
<td><form:label path="id">Student Id </form:label> </td>
<td><form:input type="number" path="id" placeholder="Enter ID" required="required"></form:input>
</tr>
<tr>
<td><form:label path="name">Student Name </form:label> </td>
<td><form:input type="text" path="name" placeholder="Enter Name" required="required" pattern="[A-Za-z ]{3,}" title="Name should contains atleast 3 characters , No Special Characters"></form:input></td>
</tr> 
<tr>
<td><form:label path="gender">Student Gender </form:label></td>
<td><form:radiobutton path="gender"  value="male" autofocus="autofocus" required="required"/>Male &nbsp; &nbsp;&nbsp; &nbsp;
<form:radiobutton path="gender" value="female" checked="checked" required="required" />Female </td>
</tr>
<tr>
<td><form:label path="email">Student Email </form:label> </td>
<td><form:input type="email" path="email" placeholder="abc@gmail.com" required="required"></form:input></td>

</tr>
<tr>
<td><form:label path="dob1">Student Date Of Birth </form:label> </td>
<td><form:input type="date" path="dob1" required="required"></form:input></td>
</tr>
<tr>
<td><form:label path="fname">Student Father Name </form:label></td>
<td><form:input type="text" path="fname" placeholder="Enter Father Name" required="required" pattern="[A-Za-z ]{3,}" title="Name should contains atleast 3 characters, No Special Characters"></form:input></td>
</tr>
<tr>
<td><form:label path="mname">Student Mother Name </form:label></td>
<td><form:input type="text" path="mname" placeholder="Enter Mother Name" required="required" pattern="[A-Za-z ]{3,}" title="Name should contains atleast 3 characters, No Special Characters"></form:input></td>
</tr>
<tr>
<td><form:label path="phno">Student Phone Number </form:label></td>
<td><form:input type="tel" path="phno" placeholder="Enter Phno" required="required" pattern="[6-9]{1}[0-9]{9}" title="Give 10 digits starts with(6-9)"></form:input></td>
</tr>
<tr>
<td><button type="submit" value="Submit">Submit</button></td>
</form:form>
</table>
</body>
</html>