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
  <spring:form action="addcategory" method="POST" modelAttribute="category">
      <spring:input path="categoryName"/>
      <spring:input path="categoryDescription"/>
      <input type="submit" value="Submit"/>
      </spring:form>
 
</body>
</html>