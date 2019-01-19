<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="springform"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<th>CategoryName</th>
<th>CategoryDescription</th>

</tr>

<c:forEach items="${categories}" var="category">
<tr>
<td>${category.categoryName}</td>
<td>${category.categoryDescription}</td>
<td><a href="editcategory/${category.categoryId}"><button>edit</button></a></td>
<td><button>delete</button></td>
</tr>


</c:forEach>



</table>


</body>
</html>