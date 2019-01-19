<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<spring:form action="registration" method="post" modelAttribute="user" >
<table>
<tr>
<td><spring:input type="hidden" path="userId"/></td>
</tr>
<tr>
<td><label>FirstName</label></td>
<td><spring:input path="firstName"/></td>
</tr>
<tr>
<td><label>LastName</label></td>
<td><spring:input path="lastName"></spring:input>
</tr>
<tr>
<td><label>Email</label></td>
<td><spring:input path="email"></spring:input></td>
</tr>
<tr>
<td><label>UserName</label></td>
<td><spring:input path="userName"/></td>
</tr>
<tr>
<td><label>Mobile</label></td>
<td><spring:input path="mobile"/></td>
</tr>
<tr>
<td><label>Password</label></td>
<td><spring:input path="password" type="password"/></td>
</tr>
<tr>
<td><label>UserRole </label></td>
<td><spring:input path="userRole"/></td>
</tr>
<tr>
<td><spring:input type="hidden" path="enable"></spring:input></td>
</tr>
<tr>
<td><label>Register</label></td>
<td><spring:button value="submit">Register</spring:button></td>
</tr>
</table>
</spring:form>
</body>
</html>