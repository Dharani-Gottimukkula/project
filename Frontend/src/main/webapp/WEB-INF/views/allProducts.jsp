<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set value="resources/images" var="images"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<c:forEach items="${products}" var="product" begin="0" end="3">
<tr>
<td><a href="product/${product.productId}">
<div>
<img src="${images}/${product.productId}.jpg" width="100" height="100"/>
<tr>
<td>${product.productName}</td>
<td>${product.productDescription}</td>
<td>${product.productPrice}</td>
<td>${product.productQuantity}</td>
<td>${product.productImage}</td>
</tr>
</div>
</a>
</td>

</tr>
</c:forEach>
</table>
</body>
</html>