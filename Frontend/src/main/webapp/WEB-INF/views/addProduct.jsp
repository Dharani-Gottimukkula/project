<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<spring:form action="addProduct" method="POST" modelAttribute="product" enctype="multipart/form-data">

<spring:select path="subCategory.subCategoryId">
<c:forEach items="${subCategories}" var="subCategory">
<spring:option value="${subCategory.subCategoryId}">${subCategory.subCategoryName}</spring:option>
</c:forEach>
</spring:select>

<spring:input path="productName"/>
<spring:input path="productDescription"/>

<spring:input path="productPrice"/>
<spring:input path="productQuantity"/>
<spring:input type="file" path="productImage"/>
<spring:button value="submit">submit</spring:button>
</spring:form>

</body>
</html>